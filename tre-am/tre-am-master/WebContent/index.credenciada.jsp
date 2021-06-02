<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.credenciada.jsp" />


<div class="container" style="text-align: center;">
	<h3>BEM VINDO</h3>
	<div class="card-group">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Módulo do Credenciado</h5>			
				<p class="card-text">
					<a href="${pageContext.request.contextPath}/credenciado/listar" role="button">Ir para guias</a>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- Loading -->
<jsp:include page="/pages/loading.jsp" />
<!-- Loading -->

<jsp:include page="/javascripts.jsp" />

<script type="text/javascript">
	  openLoading();
	  url = "${pageContext.request.contextPath}/credenciado/listar";
	  window.location.replace(url);
</script>
<!-- /.container -->

<jsp:include page="/mainfooter.inc.jsp" />