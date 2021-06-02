<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/mainhead.inc.jsp" />
<jsp:include page = "/menu.top.inc.jsp" />

<div class="container" style="background-color: white; margin-top: 0px;">
     <!-- breadcrumb -->
    <nav aria-label="breadcrumb" style="margin-top: 0px;">
        <ol class="breadcrumb" style="background-color: white !important;">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dominios/listar">Inicio</a></li>
            <li class="breadcrumb-item active" aria-current="page">Domínios</li>
        </ol>
    </nav>
    <!-- breadcrumb -->
</div>

<div class="container" style="background-color: white; margin-top: 20px;">
  <div class="container-fluid">
     
   <!-- botão Listagem -->
   <div class="row justify-content-end" style="margin-bottom: 10px; padding-top: 20px;">
        <div class="col-2 align-self-end" style="text-align: end;">
            <!--<button class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Voltar para listagem">Listagem</button>-->
            <a class="btn btn-primary" href="listar" role="button">Listagem</a>
        </div>
    </div>
    <!--form -->
    <form action="${flag}" method="post" name="form1" id="frmDominio" class="needs-validation" novalidate>
   	 <s:if test="flag=='alterar'"><input type="hidden" name="dominio.id" value="${dominio.id}"></s:if>
	    <div class="row" style="min-height: 200px;">
	        <div class="col-12">           
	                <div class="form-group row">
	                    <label for="inputDominio" style="text-align: end;" class="col-sm-2 col-form-label">Dominio:*</label>
	                    <div class="col-sm-10">
	                        <input type="text" name="dominio.dominio" value="${dominio.dominio}"  class="form-control" id="dominio" placeholder="" required>
	                    </div>
	                </div>
	                <div class="form-group row">
	                    <label for="inputValor" style="text-align: end;" class="col-sm-2 col-form-label">Valor:*</label>
	                    <div class="col-sm-10">
	                        <input type="text" name="dominio.valor" class="form-control" value="${dominio.valor}"  id="valor" placeholder="" required>
	                    </div>
	                </div>
	                <div class="form-group row">
	                    <label for="inputSituacao" style="text-align: end;" class="col-sm-2 col-form-label">Situação:*</label>
	                    <div class="col-sm-10">
	                        <select class="form-control" name="dominio.situacao" id="situacao" required>
	                            <option></option>
	                            <option value="ATIVO">ATIVO</option>
	                            <option value="INATIVO" >INATIVO</option>
	                        </select>
	                    </div>
	                </div>
	                <div class="form-group row">
                        <label for="inputDescricao" style="text-align: end;" class="col-sm-2 col-form-label">Descrição:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="dominio.descricao" id="descricao" rows="3">${dominio.descricao}</textarea>
                        </div>
	                </div>
	                <div class="form-group row justify-content-center">
	                    <div class="col-sm-3">
	                        <button  id="btnEditar"  type="submit" class="btn btn-success">Salvar</button>
	                        <a class="btn btn-outline-secondary" href="listar" role="button">Cancelar</a>
	                    </div>
	                </div>              
	        </div>
	    </div>
    </form>
    <!-- form -->
   </div>  
</div>
     		

  
<jsp:include page = "/javascripts.jsp" />
<script type="text/javascript">
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

$(document).ready(function() {
	if ("${dominio.situacao}") {
		$('#situacao option[value=${dominio.situacao}]').attr('selected','selected');
	}	
	var form = $( "#frmDominio");
	form.validate({
		messages: {
			"dominio.dominio": "Campo obrigatório!",
			"dominio.valor": "Campo obrigatório!",			
			"dominio.situacao": "Campo obrigatório!"
		}
	});
	
	});
</script>	


<jsp:include page = "/mainfooter.inc.jsp" />