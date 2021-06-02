<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.jsp" />


<div class="container" style="text-align: center;">
	<h3>BEM VINDO</h3>
	<div class="card-group">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Módulo do Administrador</h5>
				<p class="card-text">
					<a href="${pageContext.request.contextPath}/administrador/listar" role="button">Ir para guias</a>
				</p>
			</div>
		</div>
	</div>

</div>
<script type="text/javascript">
	if ("${loginCredenciada}" == true) {
	  url = "${pageContext.request.contextPath}/credenciado/listar";
	  window.location.replace(url);
	}
</script>
<!-- /.container -->

<jsp:include page="/javascripts.jsp" />

<jsp:include page="/mainfooter.inc.jsp" />