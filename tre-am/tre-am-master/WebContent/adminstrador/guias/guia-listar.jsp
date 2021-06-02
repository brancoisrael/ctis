<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.jsp" />

<div  class="container">

	<div class="container"
		style="background-color: white; margin-top: 0px;">
		<!-- breadcrumb -->
		<nav aria-label="breadcrumb" style="margin-top: 0px;">
			<ol class="breadcrumb" style="background-color: white !important;">
				<li class="breadcrumb-item active">Inicio</li>
			</ol>
		</nav>
		<!-- breadcrumb -->
	</div>
	<div class="container"
		style="background-color: white; margin-top: 0px; padding-top: 20px; padding-bottom: 20px;">
	
		
		<!-- cards -->
		<div class="row">
			<!--  card 1-->
			<div class="col-4">
				<div class="card text-white bg-info" style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters" style="min-height: 114px;">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>30</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text" style="font-size: 20px;">Guias autorizadas no ultimo mês.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card text-white bg-warning" style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters" style="min-height: 114px;">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>30</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text" style="font-size: 20px;">Guias em análise.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card text-white bg-danger"
					style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters" style="min-height: 114px;">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>30</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text" style="font-size: 20px;">Guias rejeitadas.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Cards -->
		
		<div class="card" style="margin-top: 30px;">
			<div class="card-header">Guias</div>
			<div class="card-body">
				<div class="row">
					<div class="col-12">
						<table id="tbGuia" class="table">
							<thead>
								<tr>
									<th width="10%" scope="col">Nº Guia</th>
									<th scope="col">Ano</th>
									<th scope="col">Situação</th>
									<th scope="col">Valor</th>
									<th style="min-width: 170px;" scope="col">Tipo Procedimento</th>
									<th scope="col">Data</th>
									<!-- <th scope="col"></th> -->
									<!--  <th scope="col">Procedimento</th>-->
									<th scope="col">Opções</th>
								</tr>
								<!-- pesquisa -->
								<tr>
									<form id="frmPesquisa">
										<td><input type="text" class="form-control" name="params.numeroGuia"></td>
										<td><input type="text" class="form-control" name="params.anoExercicio"></td>
										<td><select id="cbxSituacao" name="params.idSituacaoGuia" class="form-control"></select></td>
										<td><input type="text" class="form-control" name="params.valor"></td>
										<td>
											<select class="form-control">
												<option>Selecione</option>
												<option>Pré-autorizados</option>
												<option>Pré-autorizados e não autorizados</option>
											</select>
										</td>
										<td>
											<div style="display: flex; align-items: center;">
												<input type="date" style="max-width: 195px;" class="form-control" name="params.dataInicialString">
												<i style="margin-left: 5px; cursor: pointer;" id="fasExibirDivDataAte" title="Exibir data até" onclick="exibirOcultarDataAte()" class="fas fa-angle-double-down"></i>
												<i style="margin-left: 5px; cursor: pointer;" id="fasOcultarDivDataAte" title="Ocultar data até" onclick="exibirOcultarDataAte()" class="fas fa-angle-double-up"></i>
											</div>
											<div style="display: flex; margin-top: 2px; align-items: center; " id="divDataAte">
												até <input type="date" style="margin-left: 10px; max-width: 165px;" class="form-control" name="params.dataFinalString">
											</div>
										</td>
										<td><button type="button" onclick="pessuisarGuiaMedica(1)" class="btn btn-info"><i class="fas fa-search"></i> Pesquisar</button></td>
									</form>
								</tr>
								<!-- pesquisa -->
							</thead>
							<tbody id="trTable"></tbody>
						</table>
					</div>				
				</div>
			     <!-- paginação -->
			    <div class="row" id="pagination"></div>
			    <!-- paginação -->				
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="infoGuiaModal" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg" role="document">
	        <div class="modal-content">
	        <div class="modal-header" style="background: #cff1f7; color: #27899a;">
	            <h5 class="modal-title" id="myExtraLargeModalLabel">Informações da Guia</h5>
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	            <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	        <div class="modal-body">
	        	<table style="width: 100%; font-size: 12px; margin-bottom: 10px;">
					<tr>
						<td width="50%" id="infModNumeroGuia"></td>
						<td width="50%" id="infModTitular"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModEmissao"></td>
						<td  width="50%" id="infModFuncao"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModValidade"></td>
						<td  width="50%" id="infModPaciente"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModCredenciado"></td>
						<td  width="50%" id="infModParcelaServidor"></td> 
					</tr>
					<tr>
						<td  width="50%" id="infModAcrecimos"></td>
						<td  width="50%" id="infModParcelaTRE"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModTotal"></td>
						<td  width="50%" ></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
				</table>
				<div class="row" style="overflow: auto; max-height: 400px;">
					<div class="col-12">
						<table id="tbInfoGuia" class="table">
								<thead>
									<tr>
										<th scope="col">Procedimento</th>
										<th style="min-width: 150px;" scope="col">R$ Unidade</th>
										<th scope="col">Via</th>
										<th scope="col">Video</th>
										<th scope="col">Quantidade</th>
										<th scope="col">Valor(R$)</th>
									</tr>
								</thead>
								<tbody id="trTableInfoGuiaModal"></tbody>
						</table>
					</div>				
				</div>
				<form id="frmFormulario">
				 <input type="hidden" id="pkNumeroGuia"  name="guiaPK.numeroGuia" value=""/>
			     <input type="hidden" id="pkanoExercicio" name="guiaPK.anoExercicio" value=""/> 
			     <input type="hidden" id="tipoGuia" name="guiaPK.tipoGuia.id" value=""/>
					<div class="form-group row">
					 	<label for="inputDescricao" style="text-align: end; max-width: 120px;" class="col-sm-2 col-form-label">Ação:</label>
						<div class="col-sm-10 align-self-center">
							<div class="form-check form-check-inline">
							  	<input class="form-check-input" type="radio" name="situacao.id" id="autorizar" value="8">
							  	<label class="form-check-label" for="autorizar">Autorizar</label>
							</div>
							<div class="form-check form-check-inline">
							  	<input class="form-check-input" type="radio" name="situacao.id" id="rejeitar" value="9">
							  	<label class="form-check-label" for="autorizar">Rejeitar</label>
							</div>
						</div>				
					</div>
					
					<div class="form-group row">
	                      <label for="inputDescricao" style="text-align: end; max-width: 120px;" class="col-sm-2 col-form-label">Descrição:</label>
	                      <div class="col-sm-10">
	                          <textarea class="form-control" name="justificativa" id="descricao" maxlength="255" rows="3"></textarea>
	                      </div>
	               	</div>
				</form>      
	        </div>
	        <div class="modal-footer">
	        	<div style="width: 100%; text-align: center;">
		            <a class="btn btn-info" id="downloadGuia" href="" target="_blank">Imprimir</a>
				    <a class="btn btn-info" id="downloadDespesa" href="" target="_blank">Despesas</a>
		            <button type="button" id="btnEditar" class="btn btn-info">Salvar</button>
		            <button type="button" onclick="closeLoading()" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	            </div>
	        </div>
	        </div>
	    </div>
	</div>
	<!-- Modal -->
	
	<!-- Loading -->
	<jsp:include page="/pages/loading.jsp" />
	<!-- Loading -->

</div>
<!-- /.container -->
<jsp:include page="/javascripts.jsp" />
<script src="${pageContext.request.contextPath}/js/listagem.guias.js"></script>
<script type="text/javascript">
pessuisarGuiaMedica("${pagination.page_number}");
getSituacoes();
function pessuisarGuiaMedica(pag) {
	var urlBase = "${pageContext.request.contextPath}";
	pesquisarAndRedirect(pag, urlBase);
}
function geraTabelaDados(data) {
	var html = '';
	if (data.length > 0) {
		data.forEach(function(objeto){
			if (objeto.guia) {
				html += '<tr id="tr_' + objeto.guia.numeroGuia + '">';
				html += '	<th scope="row">' + objeto.guia.numeroGuia + '</th>';
				html += '	<td>' + objeto.guia.anoExercicio + '</td>';
				html += '	<td>' + verificaSituacaoGuia(objeto) + '</td>';
				html += '	<td>' +  formatarMoeda(objeto.valor) + '</td>';
				html += '	<td>' + verificaTipoProcedimento(objeto.procedimentos) + '</td>';
				html += '	<td>' + retornaDataFormatadaByCalendar(objeto.guia.dataEmissao) + '</td>';
				html += '	<td style="text-align: center;">';
				html += '  <a href="javascript:void(0)" onclick="antesPreparaModal('+objeto.guia.numeroGuia +',' + objeto.guia.anoExercicio + ' , ' + objeto.guia.tipoGuia.id + ',false)"><i class="fas fa-eye" data-toggle="modal"  data-placement="top" title="Visualizar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';
				if (objeto.guia.situacao.id != 6) {
				html += '  <a href="javascript:void(0)" onclick="antesPreparaModal('+objeto.guia.numeroGuia +',' + objeto.guia.anoExercicio + ' , ' + objeto.guia.tipoGuia.id + ', true)"><i class="fas fa-pen" data-toggle="modal"  data-placement="top" title="Editar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';
				}				
				html += ' 	</td>';
		        html += '</tr>';
			}
		});
	} else {
		html += '<tr>';
		html += '	<th colspan="9" scope="row">Nenhuma informação encontrada!</th>';
		html += '</tr>';
	}
	
	$("#trTable").html(html);
}

function antesPreparaModal(id, ano, tipoGuia, editar) {
	if (editar) {
		$("#btnEditar").show();
		$("#autorizar").attr("disabled", false);
		$("#rejeitar").attr("disabled", false);
		$("#descricao").attr("disabled", false);
	} else {
		$("#btnEditar").hide();
		$("#autorizar").attr("disabled", true);
		$("#rejeitar").attr("disabled", true);
		$("#descricao").attr("disabled", true);
	}
	preparaModal(id, ano, tipoGuia);
}
$(document).ready(function() {
	$('#divDataAte').hide();
	$('#fasOcultarDivDataAte').hide();
	
	var dataValidade = dateToBr("${credenciado.dataValidade}");
	$('#credenciadoValidadeContrato').html("<strong>Validade do contrato: </strong>" + dataValidade);
	
	$("#btnEditar" ).click(function() {
			
			openLoading();
			
			var dados = $('#frmFormulario').serialize();		    	
	    	var url = "salvar.action";
	    	
	    	$.ajax({
	    	      url: url,
	    	      data: dados,
	    	      type: 'post',
	    	      traditional: true,
	    	      success: function(data) {
	    	    	alert("ok");
	    	      },
	    	      error: function() {
	    	    	  alert("Error");
	    	      }
	    	    }).done(function() {
	    			 closeLoading();   
	    		 }).fail(function(jqXHR) {
	    			 closeLoading();
	    			 toRedirectLogin(urlBase);
	    		 });
	
	});
	
});
</script>
<jsp:include page="/mainfooter.inc.jsp" />