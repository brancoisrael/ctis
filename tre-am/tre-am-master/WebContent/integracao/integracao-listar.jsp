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
				<li class="breadcrumb-item">Carga XML</li>
			</ol>
		</nav>
		<!-- breadcrumb -->
	</div>
	<div class="container"
		style="background-color: white; margin-top: 0px; padding-top: 20px; padding-bottom: 20px;">
		
		<div class="row">
			<div class="col-12">
				<s:iterator value="sucessos" var="msg">
					<div class="alert alert-success" role="alert">
					 ${msg}
					</div>
				</s:iterator>
			</div>
		</div>
		
		<form name="frm" action="carregar" method="post" id="frm" class="needs-validation" enctype="multipart/form-data">
			<input type="hidden" name="fileName" id="fileName" value=""/>
			<textarea rows="4" cols="50" id="fileUploadHidden" name="fileUpload" style="display: none;"></textarea>
			
			<p style="font-weight: bold;">Envie o arquivo XML referente a prestadora UNIMED para que seja realizada a carga das Despesas e Procedimentos.</p>
			
			<div class="row">
				<div class="col-12">
			       	<div class="form-group row">
			               <div class="col-sm-10">
			                   <s:file name="upload" label="Anexo XML" accept="text/xml" id="arquivo" onchange="processaArquivoBase64()"  size="40" style="display:none;"/>	
			                 	<button type="button" id="btnLinkArquivo" class="btn btn-success">Arquivo</button>
			                 	<label style="margin-left: 5px;" id="lblArquivo"></label>
			               </div>
			       	</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-12">
					<s:iterator value="erros" var="erro">
						<div class="alert alert-danger" role="alert">
						 ${erro}
						</div>
					</s:iterator>
				</div>
			</div>			
			
			<div class="row">
				<div class="col-12">
					<div class="form-group row justify-content-center">
						<div class="col-sm-4">					
						   <button id="btnSalvar" type="submit" class="btn btn-success">Carregar arquivo XML</button>
					
							<a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/administrador/listar" role="button">Cancelar</a>
						</div>
					</div>
				</div>
			</div>
		
		</form>		
	</div>	
	
	
	<!-- Loading -->
	<jsp:include page="/pages/loading.jsp" />
	<!-- Loading -->

</div>
<!-- /.container -->
<jsp:include page="/javascripts.jsp" />
<script src="${pageContext.request.contextPath}/js/listagem.guias.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btnLinkArquivo").click(function() {
	    $("#arquivo").trigger('click');
	});

});
</script>
<jsp:include page="/mainfooter.inc.jsp" />