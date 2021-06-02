<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.credenciada.jsp" />

<div  class="container">

	<div class="container"
		style="background-color: white; margin-top: 0px;">
		<!-- breadcrumb -->
		<nav aria-label="breadcrumb" style="margin-top: 0px;">
			<ol class="breadcrumb" style="background-color: white !important;">
				<li class="breadcrumb-item active">Inicio</li>
				<li class="breadcrumb-item">Guias Odontol�gica</li>
			</ol>
		</nav>
		<!-- breadcrumb -->
	</div>
	<div class="container"
		style="background-color: white; margin-top: 0px; padding-top: 20px; padding-bottom: 20px;">
		
		<div class="card" style="margin-bottom: 30px;">
			<div class="card-header">Informa��es da Credenciada</div>
			<div class="card-body">
				<table style="width: 100%; font-size: 12px;">
					<tr>
						<td><strong>Login: </strong>${usuario.login}</td>
						<td><strong>Tabela: </strong>${credenciado.tabela.nome}</td>
					</tr>
					<tr>
						<td><strong>Nome do Usu�rio: </strong>${usuario.nome}</td>
						<td><strong>N�mero do Contrato: </strong>${credenciado.numeroContrato}</td>
					</tr>
					<tr>
						<td><strong>C�digo do Credenciado: </strong>${credenciado.id}</td>
						<td  id="credenciadoValidadeContrato"><strong>Validade do contrato: </strong></td>
					</tr>
					<tr>
						<td><strong>Nome do Credenciado: </strong>${credenciado.nome}</td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- cards -->
		<div class="row">
			<!--  card 1-->
			<div class="col-3">
				<div class="card text-white bg-primary" style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>${totalGuiaEmtidaMes}</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text">Total de Guias emitidas no m�s.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div class="card text-white bg-success" style="width: 100%;">
					<div class="row no-gutters">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>${totalGuiasAutorizadaMes}</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text">Total de Guias Atualizadas no m�s.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div class="card text-white bg-warning"
					style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>${totalGuiasEmAutorizacaoMes}</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text">Total de Guias Em Atualiza��o.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div class="card text-white bg-danger"
					style="width: 100%; box-shadow: 1px 2px 2px 0 rgba(119, 151, 178, 0.16);">
					<div class="row no-gutters">
						<div class="col-md-3 align-self-center" style="text-align: center;">
							<h3>${totalGuiasCanceladasMes}</h3>
						</div>
						<div class="col-md-9 align-self-center">
							<div class="card-body">
								<p class="card-text">Total de Guias N�o Autorizados.</p>
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
				<div class="row" style="margin-bottom: 20px;">
					<div class="col-12" style="text-align: end;">
						<!--<strong>Nova Guia: </strong>
						 <a href="${pageContext.request.contextPath}/guia-clinica-laboratorial/frmSetupNovo">
							<button type="button" class="btn btn-primary"><i class="fas fa-plus"></i> Cl�nica/ Laboratorial</button>
						</a>-->
						<a href="${pageContext.request.contextPath}/guia-odontologica/frmSetupNovo">
							<button type="button" class="btn btn-primary"><i class="fas fa-plus"></i> Nova Guia Odontol�gica</button>
						</a>
					</div>				
				</div>
				<div class="row">
					<div class="col-12">
						<table id="tbGuia" class="table">
							<thead>
								<tr>
									<th width="10%" scope="col">N� Guia</th>
									<th scope="col">Ano</th>
									<th scope="col">Situa��o</th>
									<th scope="col">Valor</th>
									<th style="min-width: 170px;" scope="col">Tipo Procedimento</th>
									<th scope="col">Data</th>
									<!-- <th scope="col"></th> -->
									<!--  <th scope="col">Procedimento</th>-->
									<th scope="col">Op��es</th>
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
												<option>Pr�-autorizados</option>
												<option>Pr�-autorizados e n�o autorizados</option>
											</select>
										</td>
										<td>
											<div style="display: flex; align-items: center;">
												<input type="date" style="max-width: 195px;" class="form-control" name="params.dataInicialString">
												<i style="margin-left: 5px; cursor: pointer;" id="fasExibirDivDataAte" title="Exibir data at�" onclick="exibirOcultarDataAte()" class="fas fa-angle-double-down"></i>
												<i style="margin-left: 5px; cursor: pointer;" id="fasOcultarDivDataAte" title="Ocultar data at�" onclick="exibirOcultarDataAte()" class="fas fa-angle-double-up"></i>
											</div>
											<div style="display: flex; margin-top: 2px; align-items: center; " id="divDataAte">
												at� <input type="date" style="margin-left: 10px; max-width: 165px;" class="form-control" name="params.dataFinalString">
											</div>
										</td>
										<td><button type="button" onclick="pessuisarGuiaOdonto(1)" class="btn btn-info"><i class="fas fa-search"></i> Pesquisar</button></td>
									</form>
								</tr>
								<!-- pesquisa -->
							</thead>
							<tbody id="trTable"></tbody>
						</table>
					</div>				
				</div>
			     <!-- paginacao -->
			     <s:if test="guiaProcedimentoDashBoardDTO.size > 0">						          
			    	<div class="row" id="pagination"></div>
			     </s:if>
			     <!-- paginacao -->				
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="infoGuiaModal" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg" role="document">
	        <div class="modal-content">
		        <div class="modal-header" style="background: #cff1f7; color: #27899a;">
		            <h5 class="modal-title" id="myExtraLargeModalLabel">Informa��es da Guia</h5>
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
					<div class="row" style="overflow: auto; max-height: 625px;">
						<div class="col-12">
							<table id="tbInfoGuia" class="table">
								<thead>
									<tr>
										<th scope="col">Procedimento</th>
										<th style="min-width: 150px;" scope="col">R$ Unidade</th>
										<!-- <th scope="col">Via</th>
										<th scope="col">Video</th> -->
										<th scope="col">Quantidade</th>
										<th scope="col">Valor(R$)</th>
									</tr>
								</thead>
								<tbody id="trTableInfoGuiaModal"></tbody>
							</table>
						</div>				
					</div>
		        </div>
		        <div class="modal-footer">
		        	<div style="width: 100%; text-align: center;">
			            <a class="btn btn-info" id="downloadGuia" href="" target="_blank">Imprimir</a>
			            <a class="btn btn-info" id="downloadDespesa" href="" target="_blank">Despesas</a>
			            <button type="button" class="btn btn-secondary" onclick="closeLoading()" data-dismiss="modal">Fechar</button>
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
var urlBase = "'${pageContext.request.contextPath}'";
pessuisarGuiaOdonto("${pagination.page_number}");
getSituacoes();
function pessuisarGuiaOdonto(pag) {
	var urlBasePesquisa = "${pageContext.request.contextPath}";
	pesquisarAndRedirect(pag, urlBasePesquisa);
}

function geraTabelaDados(data) {
	var html = '';
	if (data.length > 0) {
		data.forEach(function(objeto){
			html += '<tr id="tr_'+objeto.guia.numeroGuia+'">';
			html += '	<th scope="row">'+objeto.guia.numeroGuia+'</th>';
			html += '	<td>' + objeto.guia.anoExercicio + '</td>';
			html += '	<td>' + verificaSituacaoGuia(objeto) + '</td>';
			html += '	<td>' +  formatarMoeda(objeto.valor) + '</td>';
			html += '	<td>' + verificaTipoProcedimento(objeto.procedimentos) + '</td>';
			html += '	<td>' + retornaDataFormatadaByCalendar(objeto.guia.dataEmissao) + '</td>';
			html += '	<td style="text-align: center;">';
			html += '  <a href="javascript:void(0)" onclick="preparaModalOdonto('+objeto.guia.numeroGuia +',' + objeto.guia.anoExercicio + ' , ' + objeto.guia.tipoGuia.id + ', '+urlBase+')"><i class="fas fa-eye" data-toggle="modal"  data-placement="top" title="Visualizar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';                            
			html += '  <a href="${pageContext.request.contextPath}/guia-odontologica/frmSetupEditar?guiaPK.numeroGuia='+objeto.guia.numeroGuia+'&guiaPK.anoExercicio='+objeto.guia.anoExercicio+'&guiaPK.tipoGuia.id='+objeto.guia.tipoGuia.id+'"><i class="fas fa-pen" data-toggle="modal"  data-placement="top" title="Editar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';
	        html += ' 	</td>';
	        html += '</tr>';
		});
	} else {
		html += '<tr>';
		html += '	<th colspan="9" scope="row">Nenhuma informa��o encontrada!</th>';
		html += '</tr>';
	}
	
	$("#trTable").html(html);
}
$(document).ready(function() {
	$('#divDataAte').hide();
	$('#fasOcultarDivDataAte').hide();
	
	var dataValidade = dateToBr("${credenciado.dataValidade}");
	$('#credenciadoValidadeContrato').html("<strong>Validade do contrato: </strong>" + dataValidade);
});
</script>
<jsp:include page="/mainfooter.inc.jsp" />