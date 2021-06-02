<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.jsp" />

<div class="container" style="background-color: white; margin-top: 0px;">
     <!-- breadcrumb -->
    <nav aria-label="breadcrumb" style="margin-top: 0px;">
        <ol class="breadcrumb" style="background-color: white !important;">
            <li class="breadcrumb-item active">Relatórios</li>
        </ol>
    </nav>
    <!-- breadcrumb -->
</div>

<div class="container" style="background-color: white; margin-top: 20px;">
  <div class="container-fluid">
  
  	<div class="row justify-content-end"  id="divMsg" style="margin-bottom: 10px; padding-top: 20px; display: none;">
        <!-- Mensagens-->
        <div class="col-12">
            <div class="alert alert-danger" role="alert">
                Mês e ano são filtros obrigatorios.
            </div>
        </div>
        <!-- Mensagens-->
    </div>
    
    <div class="row" style="min-height: 200px;">
        <div class="col-12">        
        	
        	<div class="card" style="margin-bottom: 30px; margin-top: 20px;">
				<div class="card-header">Relatórios Financeiro</div>
				<div class="card-body">
					<div class="form-group row">
						<div class="col-12">
							Preencha os filtros mês e ano de referência para gerar o relatório.
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<form name="frmRel" id="frmRel" enctype="multipart/form-data">
								<div class="form-row" style="margin-bottom: 30px;">
									<div class="col-4" style="display: flex;">
										<label for="mes" style="text-align: end;" class="col-sm-3 col-form-label">Mês:</label>
										<select class="form-control" name="mes" id="mes">
					                        <option value="">Selecione o mês</option>
					                        <option value="01">Janeiro</option>
					                        <option value="02">Fevereiro</option>
					                        <option value="03">Março</option>
					                        <option value="04">Abril</option>
					                        <option value="05">Maio</option>
					                        <option value="06">Junho</option>
					                        <option value="07">Julho</option>
					                        <option value="08">Agosto</option>
					                        <option value="09">Setembro</option>
					                        <option value="10">Outubro</option>
					                        <option value="11">Novembro</option>
					                        <option value="12">Dezembro</option>			                        
				                        </select>
									</div>								
									<div class="col-4" style="display: flex;">
										<label for="ano" style="text-align: end;" class="col-sm-3 col-form-label">Ano:</label>
										<input type="number" name="ano" class="form-control" id="ano" required>
									</div>
								</div>
								<div class="form-row" style="margin-bottom: 10px;">
									<div class="col-12">Relatórios:</div>
								</div>
								
								<s:iterator value="relatoriosFinanceiro">
									<div class="form-row" style="margin-bottom: 5px;">
										<div class="col-1">
											<a id="idLinkRel" href="" target="_blank"></a>
											<button type="button" onclick="gerarRelatorio('${nome}')"  class="btn btn-default"><i class="fas fa-file-pdf"></i> PDF</button>
										</div>
										<div class="col-10">
											${descricao}
										</div>
									</div>
								</s:iterator>
							</form>
						</div>
					</div>
									
				</div>
			</div>   
			  
        </div>
    </div>
    
   </div>  
</div>

     		
<jsp:include page = "/javascripts.jsp" />
<script type="text/javascript">
function gerarRelatorio(relatorio) {
	$("#divMsg").hide("slow");
	var ano = $("#ano").val();
	var mes = $("#mes").val();
	if (ano != null && ano != "" && mes != null && mes != "") {
		$('#idLinkRel').attr('href',"imprimir?relatorio="+relatorio+"&ano="+ano+"&mes="+mes).click();
		document.getElementById('idLinkRel').click();
	} else {
		$("#divMsg").show("slow");
	}
}

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();	
});

function ocultarMensagem() {
	setTimeout(function(){ 
		$("#divMsg").hide("slow"); 
	}, 5000);
}
</script>	


<jsp:include page = "/mainfooter.inc.jsp" />