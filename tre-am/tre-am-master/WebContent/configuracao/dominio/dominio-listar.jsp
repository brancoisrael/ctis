<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.jsp" />

<div class="container" style="background-color: white; margin-top: 0px;">
     <!-- breadcrumb -->
    <nav aria-label="breadcrumb" style="margin-top: 0px;">
        <ol class="breadcrumb" style="background-color: white !important;">
            <li class="breadcrumb-item active">Inicio</li>
        </ol>
    </nav>
    <!-- breadcrumb -->
</div>

<div class="container" style="background-color: white; margin-top: 20px;">
  <div class="container-fluid">
  
  	<div class="row justify-content-end" style="margin-bottom: 10px; padding-top: 20px;">
        <!-- Mensagens-->
        <div class="col-10">
        	<div id="msgSucesso"></div>
            <s:if test="%{#danger}">
	            <div class="alert alert-danger" role="alert">
	                Falha ao realizar operação.
	            </div>
             </s:if>
        </div>
        <!-- Mensagens-->
        <!-- botão novo -->
        <div class="col-2 align-self-end" style="text-align: end;">
            <a class="btn btn-primary" href="frmSetupNovo" role="button">Novo</a>
        </div>
        <!-- botão novo -->
    </div>
     
      <!-- tablea listagem -->
    <div class="row" style="min-height: 200px;">
        <div class="col-12">
            <table id="tbDominio" class="table">
                <thead>
                    <tr>
                        <th width="10%" scope="col">ID</th>
                        <th scope="col">Domínio</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Situação</th>
                        <th scope="col">Opções</th>
                    </tr>
                    <!-- pesquisa -->
                    <tr>
                        <td>
                            <input type="text" name="params.id" value="" id="id" class="form-control">
                        </td>
                        <td>
                            <select class="form-control" name="params.dominio" id="cbxdominio">
                            </select>
                        </td>
                        <td>
                            <input type="text" value=""  name="params.valor" class="form-control" id="valor">
                        </td>
                        <td>
                            <input type="text" value=""  name="params.descricao" class="form-control" id="descricao">
                        </td>
                        <td>
                            <select class="form-control"  name="params.situacao" id="situacao" style="min-width: 120px" >
                                <option value="">Selecione</option>
                                <option value="ATIVO">ATIVO</option>
                                <option value="INATIVO">INATIVO</option>
                            </select>
                        </td>
                        <td>
                            <button type="button" onclick="pesquisar()" class="btn btn-info"><i class="fas fa-search"></i> Pesquisar</button>
                        </td>
                    </tr><!-- pesquisa -->
                </thead>
                <tbody id="trTable"></tbody>
            </table>        
        </div>
    </div>
    <!-- Tabela listagem-->
     <!-- paginação -->
    <div class="row" id="pagination"></div>
    <!-- paginação -->
   </div>  
</div>
<!-- Modal -->
<div class="modal fade" id="confimaExclusaoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Exclusão de Informação</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
        <input type="hidden" id="idExclusao" value="" />
            Confirma a eclusão permanente da informação <span class="nome"></span>? 
        </div>
        <div class="modal-footer">
            <button type="button" onclick="excluir()" class="btn btn-danger">Excluir</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        </div>
        </div>
    </div>
</div>
<!-- Modal -->
     		
<jsp:include page = "/javascripts.jsp" />
<script type="text/javascript">
var urlBase = "'${pageContext.request.contextPath}'";
var pagaNumber = 1;
//retorna todos os dados
getAll();
//gera paginação
geraPagination("${pagination.page_number}", "${pagination.total_pages}");

function pesquisar() {
	var id = $('#id').val();
	var dominio = $('#cbxdominio option:selected').val()
	var valor = $('#valor').val();
	var situacao = $('#situacao option:selected').val();
	$.getJSON( "pesquisar?params.id="+id+"&params.dominio="+dominio+"&params.valor="+valor+"&params.situacao="+situacao+"&pagination.page_number=1", function( data ) {
		if (data) {
			geraTabelaDados(data);
			geraPagination(1, "${pagination.total_pages}");
		}
	 }).fail(function(jqXHR) {
		 toRedirectLogin(urlBase);
	 });
}

function excluir() {
	var idExcluir = $("#idExclusao").val();
	if (idExcluir) {
		$.getJSON( "remover?dominio.id="+idExcluir, function( data ) {
    		console.log(data);
    		if (data.id == 1) {
    			$('#confimaExclusaoModal').modal('hide');
    			getAllPagination(pagaNumber);
    			geraMensagemSucesso(data.mensagem);
    		}
    	 }).fail(function(jqXHR) {
    		 toRedirectLogin(urlBase);
    	 });
	}
}
function geraMensagemSucesso(mensagem) {
	var html = '';
	html += '<div class="alert alert-success" role="alert">';
	html += mensagem;
	html += '</div>';
	$('#msgSucesso').html(html);
	setTimeout(function(){ 
		$('#msgSucesso').html(''); 
	}, 5000);
}

function preparaModal(obj) {
	var nome = $(obj).data('nome');
    var id = $(obj).data('id');
    $("#idExclusao").val(id);
	$('span.nome').text(nome);
	$('#confimaExclusaoModal').modal('show');
}
function geraTabelaDados(data) {
	var html = '';
	if (data.length > 0) {
		data.forEach(function(objeto){
			html += '<tr id="tr_' + objeto.id + '">';
			html += '	<th scope="row">' + objeto.id + '</th>';
			html += '	<td>' + objeto.dominio+ '</td>';			
			html += '	<td>' + objeto.valor+ '</td>';
			html += '	<td>' + objeto.descricao+ '</td>';
			html += '	<td>';
			html += '	<span class="badge '+ objeto.badgeSituacao + '">';
			html += objeto.situacao;
			html += '	</span>';
			html += '	</td>';
			html += '	<td style="text-align: center;">';
			html += '<a href="frmSetupEditar?id='+objeto.id+'"  title="Editar">';
			html += ' 		<i class="fas fa-pen" title="Editar" style="margin-right: 5px; cursor: pointer;"></i>';
			html += '   	<a href="javascript:void(0)" data-id="'+objeto.id+'" data-nome="'+objeto.descricao+'" onclick="preparaModal(this)"><i class="fas fa-trash-alt" data-toggle="modal"  data-placement="top" title="Excluir" style="color:red; cursor: pointer;"></i></a>';                            
	        html += ' 	</td>';
	        html += '</tr>';
		});
	} else {
		html += '<tr>';
		html += '	<th colspan="6" scope="row">Nenhuma informação encontrada!</th>';
		html += '</tr>';
	}
	
	$("#trTable").html(html);
}

function getAll() {
	$.getJSON( "listarJson", function( data ) {
		if (data) {
			geraTabelaDados(data);
		}
	 }).fail(function(jqXHR) {
		 toRedirectLogin(urlBase);
	 });
}

function getAllPagination(pagina){	
	if (pagina) {
		pagaNumber = pagina;
		$.getJSON( "listarJson?pagination.page_number="+pagina, function( data ) {
			if (data) {
				geraTabelaDados(data);
				geraPagination(pagina, "${pagination.total_pages}");
			}
		 }).fail(function(jqXHR) {
			 toRedirectLogin(urlBase);
		 });
	}
}
function geraPagination(pag, pageNumber) {
	var html = '';
	html += '<div class="col-12">';
	html += '<nav aria-label="Page navigation example">';
	html += '<ul class="pagination justify-content-center">';
	if (pag > 1) {
		var paginaAnterior = pag - 1;
		html += '    <li class="page-item">';
	    html += '    	<a class="page-link" onclick="getAllPagination(' + paginaAnterior + ')"  aria-label="Previous">';
	    html += '			<span aria-hidden="true">&laquo;</span>';
	    html += '		</a>';
	    html += '	</li>';
	}      
    for (var i = 1; i <= pageNumber; i++) {
    	var active = '';
    	if (pag == i) {
    		 active = 'active';
    	}
	    html += '<li class="page-item ' + active + '">';
	    html += '<a class="page-link" onclick="getAllPagination('+i+')">';
	    html += i;
	    html += ' </a>';
	    html += '</li>';
    }
    if (pag != pageNumber) {
    	var paginaPosterior = pag + 1;
	    html += '<li class="page-item">';
	    html += '	<a class="page-link" onclick="getAllPagination(' + paginaPosterior + ')"  aria-label="Next">';
	    html += '   	<span aria-hidden="true">&raquo;</span>';
	    html += '    </a>';
	    html += '</li>';
    }
    html += '</ul>';
    html += '</div>';
    $("#pagination").html(html);

}
carregaComboboxDominio();
function carregaComboboxDominio(){
	  var select = $('#cbxdominio');	      
	      select.find('option').remove();
	      $('<option>').val("").text("Selecione").appendTo(select);		
		$.getJSON('tiposDominio',function(jsonResponse) {
			 console.log(jsonResponse);
			if (jsonResponse) {
				jsonResponse.forEach(function(item, index){
					$('<option>').val(item).text(item).appendTo(select);
		       	});
			}
       	}).fail(function(jqXHR) {
   		 	toRedirectLogin(urlBase);
   	 	});
}	

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();	
});
</script>	


<jsp:include page = "/mainfooter.inc.jsp" />