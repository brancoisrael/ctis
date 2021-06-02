<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.servidor.jsp" />

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
									<th scope="col"></th>
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
										<td><input type="date" style="max-width: 165px;" class="form-control" name="params.dataInicialString"></td>
										<td style="display: flex;margin-left: -15px;">até <input type="date" style="margin-left: 10px; max-width: 165px;" class="form-control" name="params.dataFinalString"></td>
										<!--<td><input type="text" class="form-control"></td>-->
										<td><button type="button" onclick="pesquisar(1)" class="btn btn-info"><i class="fas fa-search"></i> Pesquisar</button></td>
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
	        	<table style="width: 100%; font-size: 12px;">
					<tr>
						<td width="50%" id="infModNumeroGuia"></td>
						<td width="50%" id="infModTitular"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModEmissao"></td>
						<td  width="50%" id="infModFuncao"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModCredenciado"></td>
						<td  width="50%" id="infModPaciente"></td>
					</tr>
					<tr>
						<td  width="50%" id="infModTotal"></td>
						<td  width="50%"></td>
					</tr>
				</table>
				<div class="row" style="overflow: auto; max-height: 625px;">
					<div class="col-12">
						<table id="tbInfoGuia" class="table">
							<thead>
								<tr>
									<th scope="col">Procedimento</th>
									<th style="min-width: 150px;" scope="col">R$ Unidade</th>
									<th scope="col">Via</th>
									<th scope="col">Video</th>
									<th scope="col">Quantidade</th>
								</tr>
							</thead>
							<tbody id="trTableInfoGuiaModal"></tbody>
						</table>
					</div>				
				</div>
				      
	        </div>
	        <div class="modal-footer">
	            <button type="button" onclick="imprimir()" class="btn btn-info">Imprimir</button>
	            <button type="button" onclick="closeLoading()" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
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
<script type="text/javascript">
var urlBase = "${pageContext.request.contextPath}";
pesquisar();
function pesquisar() {
	openLoading();
	var dados = $('#frmPesquisa').serialize();
	var url = "listarJson?"+dados;
	$.getJSON(url, function(data) {
		if (data) {
			geraTabelaDados(data);
			geraPagination("${pagination.page_number}", "${pagination.total_pages}");
		}
	 }).done(function() {
		 closeLoading();   
	 }).fail(function(jqXHR) {
		 closeLoading();
		 toRedirectLogin(urlBase);
	 });
}
function verificaTipoProcedimento(procedimentos) {
	var requerAutorizacao = 0;
	procedimentos.forEach(function(procedimento) {
		requerAutorizacao += procedimento.requerAutorizacao;
	});
	
	if (requerAutorizacao > 0) {
		return "Requer Autorização";
	} else {
		return "Pré-Autorizado";
	}
}
function verificaSituacaoGuia(procedimentos) {
	var requerAutorizacao = 0;
	procedimentos.forEach(function(procedimento) {
		requerAutorizacao += procedimento.requerAutorizacao;
	});
	
	if (requerAutorizacao > 0) {
		return '<span class="badge badge-danger">Não Autorizado </span>';
	} else {
		return '<span class="badge badge-success">Autorizado </span>';
	}
}
function retornaProcedimentos(procedimentos) {
	var htmlProcediemento = "";
	var limit = 2;
	var contador = 0;
	procedimentos.forEach(function(procedimento) {
		if (contador < limit) {
			if (contador != 0) {
				htmlProcediemento += ", <br/>";
			}
			htmlProcediemento += procedimento.nome;
		}
		contador++;
	});
	htmlProcediemento += "...";
	return htmlProcediemento;
}
function geraTabelaDados(data) {
	var html = '';
	if (data.length > 0) {
		data.forEach(function(objeto){
			html += '<tr id="tr_' + objeto.guia.numeroGuia + '">';
			html += '	<th scope="row">' + objeto.guia.numeroGuia + '</th>';
			html += '	<td>' + objeto.guia.anoExercicio + '</td>';
			html += '	<td>' + verificaSituacaoGuia(objeto.procedimentos) + '</td>';
			html += '	<td>' +  formatarMoeda(objeto.valor) + '</td>';
			html += '	<td>' + verificaTipoProcedimento(objeto.procedimentos) + '</td>';
			html += '	<td>' + retornaDataFormatadaByCalendar(objeto.guia.dataEmissao) + '</td>';
			html += '	<td></td>';
			html += '	<td style="text-align: center;">';
			html += '  <a href="javascript:void(0)" onclick="preparaModal('+objeto.guia.numeroGuia +',' + objeto.guia.anoExercicio + ' , ' + objeto.guia.tipoGuia.id + ')"><i class="fas fa-eye" data-toggle="modal"  data-placement="top" title="Visualizar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';                            
	        html += ' 	</td>';
	        html += '</tr>';
		});
	} else {
		html += '<tr>';
		html += '	<th colspan="9" scope="row">Nenhuma informação encontrada!</th>';
		html += '</tr>';
	}
	
	$("#trTable").html(html);
}
function preparaModal(id, ano, tipoGuia) {
	openLoading();
	$.getJSON( "infoGuiaJson?guiaPK.numeroGuia="+id+"&guiaPK.anoExercicio="+ano+"&guiaPK.tipoGuia.id="+tipoGuia, function(data) {
		var guia = data.guia;
		$('#infModNumeroGuia').html("<strong>Número da Guia: </strong>" + guia.numeroGuia);
		$('#infModTitular').html("<strong>Titular: </strong>" + data.titular);
		$('#infModEmissao').html("<strong>Emissão: </strong>" + retornaDataFormatadaByCalendar(guia.dataEmissao));
		$('#infModFuncao').html("<strong>Função: </strong>" + data.funcao);
		$('#infModCredenciado').html("<strong>Credenciado: </strong>" + guia.credenciado.nome);
		$('#infModPaciente').html("<strong>Paciente: </strong>" + data.dependente);
		$('#infModTotal').html("<strong>Total: </strong> " + formatarMoeda(guia.totalFaturado));
		
		var htmlTrTableInfoGuiaModal = "";
		guia.procedimentos.forEach(function(procedimento){
			htmlTrTableInfoGuiaModal += "<tr>";
			htmlTrTableInfoGuiaModal += "	<td>" +  procedimento.procedimento.codigoProcedimento + " - " +  procedimento.procedimento.nome + " </td>";
			htmlTrTableInfoGuiaModal += "	<td>" + formatarMoeda(procedimento.valorCalculado) + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.viaAcesso + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.video + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.quantidade + "</td>";
			htmlTrTableInfoGuiaModal += "</tr>";
		});
		$('#trTableInfoGuiaModal').html(htmlTrTableInfoGuiaModal);
		
		$('#infoGuiaModal').modal('show');
	 }).done(function() {
		 closeLoading();   
	 }).fail(function(jqXHR) {
		 closeLoading();
		 toRedirectLogin(urlBase);
	 });
}

function imprimir() {
	
}

$(document).ready(function() {
	var dataValidade = dateToBr("${credenciado.dataValidade}");
	$('#credenciadoValidadeContrato').html("<strong>Validade do contrato: </strong>" + dataValidade);
});
</script>
<jsp:include page="/mainfooter.inc.jsp" />