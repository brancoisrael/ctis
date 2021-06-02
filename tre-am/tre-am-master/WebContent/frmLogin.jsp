<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/mainhead.inc.login.jsp" />

<div class="container">

	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					
					<div class="row justify-content-center">
						<div class="col-4">
							<img alt="" src="http://www.tse.jus.br/temas/imagens/logos/tre-am.png">
						</div>
					</div>
					
					<s:if test="hasActionErrors()">
							<div class="alert alert-danger" role="alert" id="success_message" style="margin-top: 10px; margin-bottom: 0px;">
								<s:actionerror />
							</div>
					</s:if>
					
					<form class="form-signin"
							action="${pageContext.request.contextPath}/login/login-credenciado"
							method="post" name="frmLogin" id="frmLogin">
						
						<div class="form-label-group">
							<label for="perfil">Perfil:</label>
							 <select class="form-control" id="perfil" name="perfilUsuarioSelecionado" onchange="processaLogin()">
							 <s:iterator value="perfisUsuarioLogin">
							 	<option value="${nome}">${descricao}</option>
							 </s:iterator>
			                 </select>
						</div>
						
						<div class="form-label-group">
							<label for="inputEmail">Usuário:</label>
							<input name="username" id="inputEmail" class="form-control"
								placeholder="Informe seu e-mail" required autofocus>
						</div>

						<div class="form-label-group">
							<label	for="inputPassword">Senha:</label>
							<input name="userpass" type="password" id="inputPassword" class="form-control"
								placeholder="Informe sua senha" required> 
						</div>

						<div class="row">
							<div class="col-6">
								<button class="btn btn-lg btn-primary btn-block"
								type="submit">Entrar</button>
							</div>
							<div class="col-6 align-self-center">
								<a href="" style="font-size: 14px;">Esqueci minha senha</a>
							</div>
						</div>
											
					</form>
				</div>
			</div>
		</div>
	</div>
	
</div>
<jsp:include page="/javascripts.jsp" />
<script type="text/javascript">
function processaLogin() {
var perfil = $("#perfil").val();
var url = "${pageContext.request.contextPath}/login/login-credenciado";
	if (perfil == "CREDENCIADO") {
		url = "${pageContext.request.contextPath}/login/login-credenciado";
	} else if (perfil == "SERVIDOR") {
		url = "${pageContext.request.contextPath}/login/login-servidor";
	} else if (perfil == "ADM") {
		url = "${pageContext.request.contextPath}/login/process";
	} 
	$('#frmLogin').attr('action',url);
}
</script>
<jsp:include page="/mainfooter.inc.jsp" />