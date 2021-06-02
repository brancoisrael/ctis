<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.credenciada.jsp" />

<div class="container" style="background-color: white; margin-top: 0px;">
     <!-- breadcrumb -->
    <nav aria-label="breadcrumb" style="margin-top: 0px;">
        <ol class="breadcrumb" style="background-color: white !important;">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/guias-odontologica/listar">Inicio</a></li>
           <s:if test="flag=='editar'">
			      <li class="breadcrumb-item active" aria-current="page">Edição de Guia</li>
		    </s:if>
		    <s:else>
		     	<li class="breadcrumb-item active" aria-current="page">Cadastro de Guia</li>
		    </s:else>
        </ol>
    </nav>
    <!-- breadcrumb -->
</div>

<div class="container" style="background-color: white; margin-top: 20px; padding-top: 15px; padding-bottom: 1px;">
	<div class="container-fluid">
	<!-- form  -->
		<form name="frmGuia" id="frmGuia" class="needs-validation" enctype="multipart/form-data" novalidate>
			<s:if test="flag=='editar'">
			     <input type="hidden" name="guiaPK.numeroGuia" value="${guiaPK.numeroGuia}"/>
			     <input type="hidden" name="guiaPK.anoExercicio" value="${guiaPK.anoExercicio}"/>
			     <input type="hidden" name="guiaPK.tipoGuia.id" value="${guiaPK.tipoGuia.id}"/>
			     <input type="hidden" name="fileName" id="fileName" value=""/>
			     <textarea rows="4" cols="50" id="fileUploadHidden" name="fileUpload" style="display: none;"></textarea>
		    </s:if>
			<!-- Tipo de Guia  -->
			<div class="card" style="margin-bottom: 30px;">
				<div class="card-header">Tipo de Guia</div>
				<div class="card-body">
					<div class="form-group row">
						<div class="col-sm-9">
							<select onchange="processaTipoGuia()" class="form-control" name="idTipoGuia" id="idTipoGuia">
								<s:iterator value="tiposGuia">
								 <s:if test="guiaPK.tipoGuia.id == id">
						             <option selected="selected" value="${id}">${descricao}</option>
						          </s:if>
						          <s:else>
						               <option value="${id}">${descricao}</option>
						          </s:else>									
								</s:iterator>
							</select>
						</div>
					</div>					
				</div>
			</div>
			<!-- Tipo de Guia  -->		
			<div class="row">
				<div class="col-6">
					<div class="card" style="margin-bottom: 30px; min-height: 255px;">
						<div class="card-header">Informações do Beneficiário</div>
						<div class="card-body">
						
							<div class="form-group row">
								<label for="inputMatricula" style="text-align: end;" class="col-sm-3 col-form-label">Matricula:</label>
								<div class="col-sm-9">
									<input type="text" onchange="carregaComboboxPaciente(null)" name="frmGuiaClinicaLaboratorialDTO.matriculaServidor" class="form-control" id="matricula" placeholder="" required>
								</div>
							</div>
							<div class="form-group row" id="rowTitular">
								<label for="inputNomeTitular" style="text-align: end;" class="col-sm-3 col-form-label">Titular:</label>
								<div class="col-sm-9" id="divNomeTitular">Informe a matrícula</div>
							</div>
							<div class="form-group row" id="rowPaciente">
			                    <label for="inputPaciente" style="text-align: end;" class="col-sm-3 col-form-label">Paciente:*</label>
			                    <div class="col-sm-9">
			                        <select class="form-control" name="frmGuiaClinicaLaboratorialDTO.codigoDependente" id="paciente">
			                        <option>Informe a matrícula</option>
			                        </select>
			                    </div>
		               		</div>						
							
						</div>
					</div>
				</div>
				<div class="col-6">
					<div class="card" style="min-height: 255px;">
						<div class="card-header">Dados do Credenciado</div>
						<div class="card-body">
							<table class="table" style="width: 100%;">
								<tr>
									<td style="text-align: end; width: 20%;border-top: none;"><strong>Usuário: </strong></td>
									<td style="border-top: none;"> ${usuario.nome}</td>
								</tr>
								<tr>
									<td style="text-align: end; width: 20%; border-top: none;"><strong>Credenciado: </strong></td>
									<td style="border-top: none;">${credenciado.nome}</td>
								</tr>
								<tr>
									<td style="text-align: end; width: 20%; border-top: none;"><strong>Tabela: </strong></td>
									<td style="border-top: none;">${credenciado.tabela.nome}</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card" style="margin-bottom: 30px;">
						<div class="card-header">Procedimento</div>
						<div class="card-body">
							<div class="row">
		               			<div class="col-8">								
		               			</div>
		               			<div class="col-4" style="text-align: end;">
		               				<a href="javascript:void(0)" onclick="preparaModal(this)">
										<button type="button" class="btn btn-primary"><i class="fas fa-plus"></i> Novo Procedimento</button>
									</a>
		               			</div>
		               		</div>	
		               		<div class="row">
		               			<div class="col-12">
		               			<input type="text" style="display: none;" name="frmGuiaClinicaLaboratorialDTO.procedimentos" class="form-control" id="procedimentos">
		               				<table class="table" id="procedimentoTable" style="width: 100%; font-size: 12px;">
										<thead>
											<tr>
												<th style="border-top: none;">Código</th>
												<th style="border-top: none;">Descrição</th>
												<th style="border-top: none;">Valor</th>
												<th style="border-top: none;">Opções</th>
											</tr>
										</thead>
										<tbody id="trTableProcedimento"></tbody>
									</table>
		               			</div>
		               		</div>
						</div>
					</div>
				</div>
			</div>
			<s:if test="flag=='editar'">
				<div class="row"  id="divDespesas">
					<div class="col-12">
						<div class="card" style="margin-bottom: 30px;">
							<div class="card-header">Despesas:</div>
							<div class="card-body">
								<div class="row">
									<div class="col-6">
										<div class="form-group row">
					                        <label for="inputDescricao" style="text-align: end;" class="col-sm-2 col-form-label">Valor:</label>
					                        <div class="col-sm-10">
					                          	<input type="text" class="money" id="valorDespesa" name="frmGuiaClinicaLaboratorialDTO.valor" >
					                        </div>
					                	</div>
					                	<div class="form-group row">
					                        <label for="inputDescricao" style="text-align: end;" class="col-sm-2 col-form-label">Anexo:</label>
					                        <div class="col-sm-10">
					                            <s:file name="upload" accept="application/pdf" id="arquivo" onchange="processaArquivoBase64()"  size="40" style="display:none;"/>	
					                          	<button type="button" id="btnLinkArquivo" class="btn btn-secondary">Arquivo</button>
					                        </div>
					                        <div style="margin-left: 100px; font-size: 12px; margin-top: 5px;" id="lblArquivo">Selecionar Arquivo</div>
					                	</div>
									</div>
									<div class="col-6">
										<div class="form-group row">
					                        <label for="inputDescricao" style="text-align: end;" class="col-sm-3 col-form-label">Observação:</label>
					                        <div class="col-sm-9">
					                            <textarea class="form-control" name="frmGuiaClinicaLaboratorialDTO.observacao" maxlength="255" id="observacao" rows="5"></textarea>
					                        </div>
					                	</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</s:if>
			<div class="row">
				<div class="col-12">
					<div class="card" style="margin-bottom: 30px;">
						<div class="card-header">Acrescimos:</div>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="row" style="width: 100%;">
									<div class="col-4" style="display: flex; align-items: center;">
										<label for="inputUrgencia" style="text-align: end; max-width: 120px;" class="col-sm-2 col-form-label">Urgência:</label>
				                        <div class="col-sm-10 align-self-center">
				                            <div class="form-check form-check-inline"> 
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.urgencia" id="urgenciaSim" value="true">
											  <label class="form-check-label" for="inputUrgencia">Sim</label>
											</div>
											<div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.urgencia" id="urgenciaNao" value="false" checked="checked">
											  <label class="form-check-label" for="inputUrgencia">Não</label>
											</div>
				                        </div>
									</div>
									<div class="col-4" style="display: flex; align-items: center;">
										<label for="inputApartamento" style="text-align: end; max-width: 130px;" class="col-sm-2 col-form-label c-apartamento">Apartamento:</label>
				                        <div class="col-sm-10 align-self-center c-apartamento">
				                            <div class="form-check form-check-inline"> 
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.apartamento" id="apartamentoSim" value="true">
											  <label class="form-check-label" for="inputApartamento">Sim</label>
											</div>
											<div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.apartamento" id="apartamentoNao" value="false" checked="checked">
											  <label class="form-check-label" for="inputApartamento">Não</label>
											</div>
				                        </div>
									</div>
									<div class="col-4" style="display: flex; align-items: center;">
										<label for="inputInternacao" style="text-align: end; max-width: 120px;" class="col-sm-2 col-form-label c-internacao">Internação:</label>
				                        <div class="col-sm-10 align-self-center c-internacao">
				                            <div class="form-check form-check-inline"> 
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.internacao" id="internacaoSim" value="true">
											  <label class="form-check-label" for="inputInternacao">Sim</label>
											</div>
											<div class="form-check form-check-inline">
											  <input class="form-check-input" type="radio" name="frmGuiaClinicaLaboratorialDTO.internacao" id="internacaoNao" value="false" checked="checked">
											  <label class="form-check-label" for="inputInternacao">Não</label>
											</div>
				                        </div>
									</div>
								</div>
		                	</div>
	                
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card" style="margin-bottom: 30px;">
						<div class="card-header">Total</div>
						<div class="card-body">
							<div class="row" style="margin-bottom: 10px;">
								<div class="col-4" id="divCusteio">
									<strong>Custeio%: </strong> ${tipoGuia.custeio}
								</div>
								<div class="col-4" id="divParcServidor">
									<strong>Parc. Servidor R$: </strong>
								</div>
								<div class="col-4" id="divTotal">
									<strong>Total R$: </strong>
								</div>
							</div>
							<div class="row">
								<div class="col-4" id="divAcrescimos">
									<strong>Acréscimos R$: </strong>
								</div>
								<div class="col-4" id="divParcelaTRE">
									<strong>Parc. TRE R$: </strong>
								</div>
								<div class="col-4">
								</div>
							</div>						
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="min-height: 200px;">
				<div class="col-12">
					<div class="form-group row justify-content-center">
						<div class="col-sm-3">
							<s:if test="flag=='editar'">
							     <button id="btnEditar" type="button" class="btn btn-success">Editar</button>
						    </s:if>
						    <s:else>
						     	<button id="btnSalvar" type="button" class="btn btn-success">Salvar</button>
						    </s:else>
							<a class="btn btn-outline-secondary" role="button">Limpar</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- form  -->		
	</div>  
</div>
  
<!-- Modal -->
	<div class="modal fade" id="novoProcedimentoModal" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg" role="document">
	        <div class="modal-content">
	        <div class="modal-header" style="background: #cff1f7; color: #27899a;">
	            <h5 class="modal-title" id="myExtraLargeModalLabel">Inserir Procedimento</h5>
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	            <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	        <div class="modal-body">
	        	<div class="row" id="msgProcedimentos" style="display: none;">
	        		<div class="col-12">
	        			<div class="alert alert-danger" role="alert" id="divMsgErro">
						 	Informe o(s) procedimento(s)!
						</div>
	        		</div>
	        	</div>
	        	<div class="row" id="msgProcedimentosSucesso" style="display: none;">
	        		<div class="col-12">
	        			<div class="alert alert-success" role="alert" id="divMsgSucesso">
							Procedimento adicionado com sucesso!
						</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="col-12">
	        			<form class="form-inline">
						  <div class="form-group mb-4" style="margin-right: 10px;">
						    <label for="codigo" style="margin-right: 10px;">Código: </label>
						    <input type="text" class="form-control" id="codigo" style=" width: 130px;">
						  </div>
						  <div class="form-group mb-4" style="margin-right: 10px;">
						    <label for="inputDescricao" style="margin-right: 10px;" >Descrição</label>
						    <input type="text" class="form-control" id="inputDescricao" maxlength="100">
						  </div>
						  <div class="form-group mb-4">
						  	<button type="button" onclick="pesquisar()" class="btn btn-info"><i class="fas fa-search"></i> Pesquisar</button>
						  	 <span id="spinnerPesquisa" class="fa fa-spinner fa-spin fa-2x" style="margin-left: 15px; display: none;"></span>
						  </div>
						</form>
	        		</div>
	        	</div>
	        	<div class="row" id="procedimentoRowTable" style="display: none; max-height: 500px; overflow: auto;">
	        		<div class="col-12">
     					<table class="table" id="procedimentoModalTable" style="width: 100%; font-size: 12px;">
							<thead>
								<tr>
									<th style="border-top: none;">Código</th>
									<th style="border-top: none;">Descrição</th>
									<th style="border-top: none;">Valor</th>
									<th style="border-top: none; width: 95px;">Selecionar</th>
								</tr>
							</thead>
							<tbody id="trTableModalProcedimento"></tbody>
						</table>
					</div>
				</div>
				<div class="row justify-content-center" id="divSpinnerDiv" style="display: none;">
					<div class="col-2">
						<span class="fa fa-spinner fa-spin fa-2x" ></span>
					</div>
				</div>
	        	<div class="row" style="display: none;" id="procedimentoRow">
	        		<div class="col-12">
	        			<h6>Procedimento:</h6>
	        			<div class="card" style="border-style: dashed !important;">
		        			<div class="card-body">
			        			<div class="row">
			        				<div class="col-6">
			        					<div id="codigoProcedimento"></div>
			        				</div>
			        				<div class="col-6">
			        					<div id="descricaoProcedimento"></div>
			        				</div>
			        			</div>
			        			<div class="row">
			        				<div class="col-6">
			        					<div id="divValorProcedimento">
			        						<strong>Valor: </strong><input type="text" class="money" id="valorProcedimento" name="valorProcedimento" >
			        					</div>
			        				</div>
			        				<div class="col-6">
			        					<strong>Quantidade: </strong><input type="number" id="quantidadeProcedimento" name="quantidadeProcedimento" value="1" min="1" max="50"> 
			        				</div>
			        			</div>
		        			</div>
	        			</div>
	        		</div>
	        	</div>
	        	<div class="row" style=" display: none" id="mensagemRow">
	        		<div class="col-12">
	        			<h5>Nenhuma informação encontrada!</h5>
	        		</div>
	        	</div>
	        </div>
	        <div class="modal-footer">
	            <button type="button" onclick="adicionarPocedimento()" class="btn btn-info">Inserir</button>
	            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        </div>
	        </div>
	    </div>
	</div>
	<!-- Modal -->  		

<!-- Loading -->
	<jsp:include page="/pages/loading.jsp" />
<!-- Loading -->

  
<jsp:include page = "/javascripts.jsp" />

<script type="text/javascript">
var urlBase = "${pageContext.request.contextPath}";
var procedimentoDespesa = "${procedimentoDespesa}";
var procedimentoMedico;
var listaProcedimentoDTO = [];
var listaProcedimentos = [];
var tipoCusteio = 0;

function addProcedimentoDTO(procedimentoMedico, quantidade, valor) {
	var valorProcedimento = "0";
	procedimentoMedico.quantidade = quantidade;
	if (valor != null && valor > 0) {
		valorProcedimento = valor.replace(".", "").replace(",", ".");
	} 
	procedimentoMedico.valor = valorProcedimento
	var procedimento = {
			codigoProcedimento: procedimentoMedico.codigoProcedimento,
			quantidade: quantidade,
			valor: valorProcedimento
	}
	
	listaProcedimentoDTO.push(procedimento);
	listaProcedimentos.push(procedimentoMedico);
	
	processaCalculoTotal();
}
function removerPocedimento(item, codigoProcedimento, quantidade) {
	removeProcedimentoDTO(codigoProcedimento, quantidade);
	var tr = $(item).closest('tr');	
    tr.fadeOut(400, function() {	      
    	tr.remove();  	    
    });	
    return false;
}
function removeProcedimentoDTO(codigoProcedimento, quantidade ) {
	$.each(listaProcedimentoDTO, function(i) {
	    if (listaProcedimentoDTO[i].codigoProcedimento == codigoProcedimento) {
	    	listaProcedimentoDTO.splice(i,1);
	        return false;
	    }
	});
	$.each(listaProcedimentos, function(i) {
	    if (listaProcedimentos[i].codigoProcedimento == codigoProcedimento) {
	    	listaProcedimentos.splice(i,1);
	        return false;
	    }
	});
	
}
function processaCalculoTotal() {
	var percentualAcrescimentos = 30;
	var adicionarAcrescimo = false;
	if ($("#urgenciaSim").is(':checked') ){
		adicionarAcrescimo = true;  
	}
	var total = 0;
	var totalAcescimos = 0;
	listaProcedimentos.forEach(function(procedimento) {
		total += (procedimento.quantidade * procedimento.valor);
		if (adicionarAcrescimo && procedimento.consulta == 1) {
			totalAcescimos += (total * percentualAcrescimentos)/100;
			total += (total * percentualAcrescimentos)/100;
		}
	});
	
	var parcServidor = (total * parseInt(tipoCusteio)) / 100;
	var parcTRE= total - parcServidor;
	
	$("#divParcServidor").html('<strong>Parc. Servidor R$: </strong>' + formatarMoeda(parcServidor));
	$("#divTotal").html('<strong>Total R$: </strong>' + formatarMoeda(total));
	$("#divAcrescimos").html('<strong>Acréscimos R$: </strong>' + formatarMoeda(totalAcescimos));
	$("#divParcelaTRE").html('<strong>Parc. TRE R$: </strong>' + formatarMoeda(parcTRE));
}
function adicionaHtmlTipoCusteio() {
	$("#divCusteio").html('<strong>Custeio%: </strong>' + tipoCusteio);	
}
function validaProcedimento() {
	$("#divMsgErro").html("Informe o(s) procedimento(s)!");
	if (!procedimentoMedico) { 
		return false;
	}/* else 
	if ($("#quantidadeProcedimento").val() < 1) {
		$("#divMsgErro").html("A quantidade precisa ser maior que 0!");
		return false;
	}*/
	return true;
}
function adicionaProcedimentoTable(procedimentoMedico, quantidade, valor) {
	var newRow = $("<tr>");
	var cols = "";	
	cols += '<td>'+procedimentoMedico.codigoProcedimento+'</td>';
	cols += '<td>'+procedimentoMedico.nome+'</td>';
	cols += '<td>'+valor+'</td>';
	//cols += '<td>'+quantidade+'</td>';
	cols += '<td>';
	cols += '<a href="javascript:void(0)" onclick="removerPocedimento(this,'+procedimentoMedico.codigoProcedimento+', '+procedimentoMedico.quantidade+')"><i class="fas fa-trash-alt" data-toggle="modal"  data-placement="top" title="Excluir" style="color:red; cursor: pointer;"></i></a>';
	cols += '</td>';	
	newRow.append(cols);
	$("#procedimentoTable").append(newRow);
}

function adicionarPocedimento() {
	$("#msgProcedimentos").hide("slow");
	$("#msgProcedimentosSucesso").hide("slow");
	if (validaProcedimento()) {
		$("#msgProcedimentos").hide();
		$("#mensagemRow").hide();
		$("#procedimentoRow").hide("slow");
	
		var quantidade = $("#quantidadeProcedimento").val();
		var valor = $("#valorProcedimento").val();
		addProcedimentoDTO(procedimentoMedico, quantidade, valor);
		
		adicionaProcedimentoTable(procedimentoMedico, quantidade, valor);
		  
		  $("#codigo").val("");
		  $("#inputDescricao").val("");
		  
		  $("#msgProcedimentosSucesso").show("slow");
		  setTimeout(function(){
			  $("#msgProcedimentosSucesso").hide("slow");
		  }, 5000);
		  
	} else {
		$("#msgProcedimentos").show("slow");
	}
}

function pesquisar() {
	var totalEncontrado = 0;
	$("#msgProcedimentosSucesso").hide("slow");
	$("#procedimentoRow").hide("slow");
	$("#procedimentoRowTable").hide("slow");
	$("#spinnerPesquisa").show();
	$("#mensagemRow").hide();
	var codigoProcedimento = $('#codigo').val();
	var descricao = $('#inputDescricao').val();
	
	if (codigoProcedimento || descricao) {
		
			$.getJSON( "listaProcedimentosJson?procedimentoParams.id="+codigoProcedimento+"&procedimentoParams.nome="+descricao, function(data) {
				totalEncontrado = data.length;
				var html = '';
				if (totalEncontrado > 0) {
					if (totalEncontrado == 1) {
						$("#divSpinnerDiv").show("slow");
						selecionaProcedimentoModal(data[0].codigoProcedimento);
					} else {
						data.forEach(function(objeto){				
							html += '<tr>';
							html += '	<th scope="row">'+objeto.codigoProcedimento+'</th>';
							html += '	<td>' + objeto.nome + '</td>';
							html += '	<td>' +  formatarMoeda(objeto.valor) + '</td>';
							//html += '	<td>' + objeto.quantidade + '</td>';
							html += '	<td style="text-align: center;">';
							html += '  <a href="javascript:void(0)" onclick="selecionaProcedimentoModal('+objeto.codigoProcedimento+')"><i class="fas fa-check" data-toggle="modal"  data-placement="top" title="Selecionar" style="cursor: pointer; font-size: 24px;color: black;"></i></a>';                            
							html += '  <span id="spinner_'+objeto.codigoProcedimento+'" class="fa fa-spinner fa-spin fa-2x" style="margin-left: 15px; display: none;"></span>';
							html += ' 	</td>';
					        html += '</tr>';
						});
					}
				} else {
					html += '<tr>';
					html += '	<th colspan="5" scope="row">Nenhuma informação encontrada!</th>';
					html += '</tr>';
				}
				
				$("#trTableModalProcedimento").html(html);		
			
			 }).done(function() {
				 $("#spinnerPesquisa").hide();
				 if (totalEncontrado != 1) {
				 	$("#procedimentoRowTable").show("slow");
				 }
			 }).fail(function(jqXHR) {
				 $("#spinnerPesquisa").hide();
				 toRedirectLogin(urlBase);
			 });
		} else {
			$("#divMsgErro").html("Informe o(s) campo(s) de busca!");
			$("#msgProcedimentos").show();
		}
}

function selecionaProcedimentoModal(procedimento) {
	$("#spinner_"+procedimento).show();
	procedimentoMedico = null;
	$("#mensagemRow").hide();
	$("#procedimentoRow").hide("slow");
	$("#msgProcedimentos").hide();
	var codigoProcedimento = $('#codigo').val();
	$.getJSON( "listaProcedimentoJson?codigoProcedimento="+procedimento, function(data) {
		if (data.ret != "0") {
			procedimentoMedico = data; 
			$("#procedimentoRow").show("slow");
			$('#codigoProcedimento').html("<strong>Código: </strong>" + data.codigoProcedimento);
			$('#descricaoProcedimento').html("<strong>Descrição: </strong>" + data.nome);
			$('#valorProcedimento').val(formatarMoedaSemCifrao(data.valor));
		} else {
			$("#mensagemRow").show();
		}
		
	 }).done(function() {
		 $("#procedimentoRowTable").hide("slow");
		 $("#spinner_"+procedimento).show();
		 $("#divSpinnerDiv").hide("slow");
	 }).fail(function(jqXHR) {
		 $("#spinner_"+procedimento).show();
		 toRedirectLogin(urlBase);
	 });
}


function preparaModal(obj) {
	$('#novoProcedimentoModal').modal('show');
}
function carregaComboboxPaciente(paciente) {
	$('#divNomeTitular').html("Informe a matrícula");
	  var matricula = $('#matricula').val();
	  var select = $('#paciente');	      
	      select.find('option').remove();
		 $.getJSON('listarJson?matricula='+matricula,function(jsonResponse) {
			if (jsonResponse) {	
				jsonResponse.forEach(function(item) {
					if (item.chave == null) {
						$('#divNomeTitular').html(item.valor);
					}
					if (item.chave == paciente) {
						$('<option selected>').val(item.chave).text(item.valor).appendTo(select);
					} else {
						$('<option>').val(item.chave).text(item.valor).appendTo(select);
					}
		       	});
			} else {
				$('<option>').val("").text("Informe a matrícula").appendTo(select);
			}
      }).fail(function(jqXHR) {
    	  openLoading();
		 toRedirectLogin(urlBase);
	 });
}	

// validator
(function() {
    'use strict';
    window.addEventListener('load', function() {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName('needs-validation');
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();
//validator

function validaProcedimentos() {
	if (listaProcedimentoDTO.length < 1) {
		exibirMensagemDanger("Favor informar o(s) Procedimento(s)");
		return false;
	}
	return true;
}
//EDIÇÃO
var anexoBanco = false;
function validaAnexo() {
	var valorPreenchido = $("#valorDespesa").val();
	var filePreenchido = $("#fileUploadHidden").val();
	
	if (valorPreenchido && (!filePreenchido && !anexoBanco)) {
		exibirMensagemDanger("Um anexo deve ser informado!");
		return false;
	}
	if ((anexoBanco || filePreenchido) && !valorPreenchido) {
		exibirMensagemDanger("Um valor despesa deve ser informado!");
		return false;
	}
	return true;
}
function carregaDadosEdicao() {
	var matriculaServidor = "${frmGuiaClinicaLaboratorialDTO.matriculaServidor}";
	var paciente = "${frmGuiaClinicaLaboratorialDTO.codigoDependente}";
	var apartamento = "${guiaDTO.apartamento}";
	var internacao = "${guiaDTO.internacao}";
	if (apartamento == "true") {
		$("#apartamentoSim").attr("checked", true);
	}
	if (internacao == "true") {
		$("#internacaoSim").attr("checked", true);
	}
	$("#matricula").val(matriculaServidor);
	carregaComboboxPaciente(paciente);
}
function getGuia() {
	openLoading();
	console.warn("getGuia");
	$.getJSON('listarGuiaJson?guiaPK.numeroGuia=${guiaPK.numeroGuia}&guiaPK.anoExercicio=${guiaPK.anoExercicio}&guiaPK.tipoGuia.id=${guiaPK.tipoGuia.id}', function(guia) {
		if (guia) {
			if (guia.despesa) {
				$("#observacao").html(guia.despesa.observacao);
				$("#valorDespesa").val(formatarMoedaSemCifrao(guia.despesa.valor));
				$("#lblArquivo").html(guia.despesa.anexo.nome);
				anexoBanco = true;
			}
			guia.procedimentosOdonto.forEach(function(procedimento) {
				//if (procedimentoDespesa != procedimento.procedimento.codigoProcedimento) {
					adicionaProcedimentoTable(procedimento.procedimento, procedimento.quantidade, formatarMoedaSemCifrao(procedimento.valor));
					addProcedimentoDTO(procedimento.procedimento, procedimento.quantidade, formatarMoedaSemCifrao(procedimento.valor));
				//}
      		});
		}
	}).done(function() {		
		 closeLoading();
		 processaTipoGuia();		
	 }).fail(function(jqXHR) {		 
		 closeLoading();
		 toRedirectLogin(urlBase);	
	 });
}
function getTipoGuia() {
	var idTipoGuia = $("#idTipoGuia").val();
	setTimeout(function(){ 
		openLoading();
	}, 500);
	$.getJSON('retornaTipoJson?idTipoGuia='+idTipoGuia, function(tipoGuia) {
		if (tipoGuia) {
			tipoCusteio = tipoGuia.custeio;
			adicionaHtmlTipoCusteio();
			if (procedimentoMedico) { 
				processaCalculoTotal();
			}
		}
	}).done(function() {
		setTimeout(function(){ 
			closeLoading();
			console.warn("closeLoading done");
		}, 2000);
	 }).fail(function(jqXHR) {
		 setTimeout(function(){ 
			closeLoading();	
			console.warn("closeLoading fail");
		 }, 2000);
	 });
}
function getBase64(file) {
   var reader = new FileReader();
   reader.readAsDataURL(file);
   reader.onload = function () {
     $("textarea#fileUploadHidden").html(reader.result.toString().replace(new RegExp('data:\\w+/\\w+;base64,|"'), ''));
   };
   reader.onerror = function (error) {
     console.log('Error: ', error);
   };
}

function processaArquivoBase64(callback) {
	var files = $("#arquivo").get(0).files;
	if (files.length > 0) {
		var ext = files[0].name.split('.').pop();
		$("#lblArquivo").html(files[0].name);
		$("#fileName").val(files[0].name);
		if (ext.toLowerCase() == "pdf") {
			getBase64(files[0]);
		} else {
			exibirMensagemDanger("Arquivo com formato inválido! Apenas PDF pode ser anexado.");
		}
	}
}
//EDIÇÃO
function processaTipoGuia() {
	var tipoGuia = $("#idTipoGuia").val();
	getTipoGuia();
	if (tipoGuia == 1) {
		//$(".c-internacao").hide("slow");
		//$(".c-apartamento").hide("slow");
	} else {
		//$(".c-internacao").show("slow");
		//$(".c-apartamento").show("slow");
	}
}
$(document).ready(function() {
	$(".c-internacao").hide();
	$(".c-apartamento").hide();
	
	//adiciona mascaram monetaria
	$('.money').mask('#.##0,00', {reverse: true});
	
	if ("${periodoUrgencia}" == "false") {
		$("#urgenciaSim").attr("disabled", true);
		$("#urgenciaNao").attr("disabled", true);
	}
	
	var flag = "${flag}";
	if (flag == "editar") {
		$("#matricula").prop( "disabled", true);
		$("#divNomeTitular").prop( "disabled", true);
		$("#paciente").prop( "disabled", true);
		$("#idTipoGuia").prop( "disabled", true);
		getGuia();		
		carregaDadosEdicao();
	} else {
		if ($("#idTipoGuia").val()) {
			processaTipoGuia();
		}
	}
	$("#btnLinkArquivo").click(function() {
	    $("#arquivo").trigger('click');
	});
	
	var form = $( "#frmGuia");
	form.validate({
		messages: {
			"frmGuiaClinicaLaboratorialDTO.matriculaServidor": "Campo obrigatório!",
			"frmGuiaClinicaLaboratorialDTO.codigoDependente": "Campo obrigatório!",			
			"frmGuiaClinicaLaboratorialDTO.urgencia": "Campo obrigatório!"
		}
	});
	$( "#btnSalvar" ).click(function() {
		if (form.valid() && validaProcedimentos()) {
				openLoading();
				
				$('#procedimentos').val(JSON.stringify(listaProcedimentoDTO));
		    	
				var dados = $('#frmGuia').serialize();
		    	// flag variavel do struts
		    	var url = "inserir.action?"+dados;
		    	
		    	$.ajax({
		    	      url: url,
		    	      data: null,
		    	      type: 'post',
		    	      traditional: true,
		    	      success: function(data) {
		    	    	  if (data.id==1){
		    	    		
		    	    		  	exibirMensagemSuccess(data.mensagem);
		  	    			
		    	    		  	setTimeout(function(){
			  	    				url = "${pageContext.request.contextPath}/guias-odontologica/listar";
					  	    		window.location.replace(url);
				  	    		}, 1000);		  	    			
		  	    		}else
		  	    			{
		  	    				exibirMensagemDanger(data.mensagem);
		  	    			}
		    	      },
		    	      error: function() {
		    	    	  exibirMensagemDanger(data.mensagem);
		    	      }
		    	    }).done(function() {
		    			 closeLoading();   
		    		 }).fail(function(jqXHR) {
		    			 closeLoading();
		    			 toRedirectLogin(urlBase);
		    		 });
		}
	  });
	
	
	
		$("#btnEditar" ).click(function() {

			if (form.valid() && validaProcedimentos() && validaAnexo()) {
				openLoading();
				
				$('#procedimentos').val(JSON.stringify(listaProcedimentoDTO));		    	
				
				var dados = $('#frmGuia').serialize();		    	
		    	var url = "editar.action";
		    	
		    	$.ajax({
		    	      url: url,
		    	      data: dados,
		    	      type: 'post',
		    	      traditional: true,
		    	      success: function(data) {
		    	    	  if (data.id==1){
		    	    		  exibirMensagemSuccess(data.mensagem);
		  	    				  	    			
		  	    			} else {
		  	    			 exibirMensagemDanger(data.mensagem);
		  	    			}
		    	      },
		    	      error: function() {
		    	    	  exibirMensagemDanger(data.mensagem);
		    	      }
		    	    }).done(function() {
		    	    	setTimeout(function(){ 
		    	    		closeLoading();
		    	    	}, 1000);
		    		 }).fail(function(jqXHR) {
		    			 setTimeout(function(){
		    				 closeLoading();
		    				 toRedirectLogin(urlBase);
		    			 }, 1000);
		    		 });
		}
		});
		
		
});
</script>	


<jsp:include page = "/mainfooter.inc.jsp" />