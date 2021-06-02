function verificaTipoProcedimento(procedimentos) {
	var requerAutorizacao = 0;
	procedimentos.forEach(function(procedimento) {
		requerAutorizacao += procedimento.requerAutorizacao;
	});
	
	if (requerAutorizacao > 0) {
		return '<span class="badge badge-warning">Requer Autorização</span>';
	} else {
		return '<span class="badge badge-success">Pré-Autorizado</span>';
	}
}
function verificaSituacaoGuia(objeto) {
	var html = '<span class="badge ';
	
	if (objeto.guia.situacao.id == 8) {
		html+= 'badge-success">';
	} else if (objeto.guia.situacao.id == 3) {
		html+= 'badge-warning">';
	} else if (objeto.guia.situacao.id == 5) {
		html+= 'badge-primary">';
	} 
	else if (objeto.guia.situacao.id == 2) {
		html+= 'badge-danger">';
	} else {
		html+= 'badge-info">';
	}
	
	html+= objeto.guia.situacao.descricao;
	html+= '</span>';
		return html;
}
function getSituacoes() {
	var select = $('#cbxSituacao');	      
    select.find('option').remove();
    $('<option>').val("").text("Selecione").appendTo(select);		
	 $.getJSON('listaSituacaoJson',function(jsonResponse) {
		if (jsonResponse) {
			jsonResponse.forEach(function(item, index){
				$('<option>').val(item.id).text(item.descricao).appendTo(select);
	       	});
		}
  });	
}
function pesquisar(pagina) {
	openLoading();
	var dados = $('#frmPesquisa').serialize();
	var url = "listarJson?"+dados+"&pagination.page_number="+pagina;
	$.getJSON(url, function(data) {
		if (data) {
			geraTabelaDados(data.guiaProcedimentoDashBoardDTO);
			geraPagination(pagina, data.pagination.total_pages);
		}
	 }).done(function() {
		 setTimeout(function(){ closeLoading(); }, 1000);  
	 }).fail(function() {
		 setTimeout(function(){ closeLoading(); }, 1000);
	 });
}
function pesquisarAndRedirect(pagina, urlBase) {
	openLoading();
	var dados = $('#frmPesquisa').serialize();
	var url = "listarJson?"+dados+"&pagination.page_number="+pagina;
	$.getJSON(url, function(data) {
		if (data) {
			geraTabelaDados(data.guiaProcedimentoDashBoardDTO);
			geraPagination(pagina, data.pagination.total_pages);
		}
	 }).done(function() {
		 setTimeout(function(){ closeLoading(); }, 1000);  
	 }).fail(function(jqXHR) {
		 toRedirectLogin(urlBase);
	 });
}
var exibirDivDataAte = false;
function exibirOcultarDataAte() {
	if (exibirDivDataAte) {
		exibirDivDataAte = false;
	} else {
		exibirDivDataAte = true;
	}
	
	if (exibirDivDataAte) {
		$('#divDataAte').show('slow');
		$('#fasExibirDivDataAte').hide('slow');
		$('#fasOcultarDivDataAte').show('slow');
	} else {
		$('#divDataAte').hide('slow');
		$('#fasExibirDivDataAte').show('slow');
		$('#fasOcultarDivDataAte').hide('slow');
	}
}
function preparaModal(id, ano, tipoGuia, urlBase) {
	openLoading();
	$.getJSON( "infoGuiaJson?guiaPK.numeroGuia="+id+"&guiaPK.anoExercicio="+ano+"&guiaPK.tipoGuia.id="+tipoGuia, function(data) {
		var guia = data.guia;

		// link downalod despesa
		if (guia.despesa) {
			$('#downloadDespesa').attr('href',"despesa-json?idAnexoDespesa="+guia.despesa.anexo.id);
		} else {
			$("#downloadDespesa").addClass('disabled');
		}
		//link download guia
		$('#downloadGuia').attr('href',"imprimirJson?guiaPK.numeroGuia="+id+"&guiaPK.anoExercicio="+ano+"&guiaPK.tipoGuia.id="+tipoGuia);
		
		$('#infModNumeroGuia').html("<strong>Número da Guia: </strong>" + guia.numeroGuia);
		$('#infModTitular').html("<strong>Titular: </strong>" + data.titular);
		
		$('#infModEmissao').html("<strong>Emissão: </strong>" + retornaDataFormatadaByCalendar(guia.dataEmissao));
		$('#infModFuncao').html("<strong>Função: </strong>" + data.funcao);
		
		$('#infModValidade').html("<strong>Validade: </strong>" + retornaDataFormatadaByCalendar(guia.credenciado.dataValidade));
		$('#infModPaciente').html("<strong>Paciente: </strong>" + data.dependente);
		
		$('#infModCredenciado').html("<strong>Credenciado: </strong>" + guia.credenciado.nome);
		$('#infModParcelaServidor').html("<strong>Parcela Servidor: </strong>" + formatarMoeda(data.custoGuiaDTO.parcelaServidor));
		
		$('#infModAcrecimos').html("<strong>Acréscimos: </strong>" + formatarMoeda(data.custoGuiaDTO.totalAcrescimo));
		$('#infModParcelaTRE').html("<strong>Parcela TRE: </strong>" + formatarMoeda(data.custoGuiaDTO.parcelaTRE));
		
		$('#infModTotal').html("<strong>Total: </strong> " + formatarMoeda(data.custoGuiaDTO.total));		
		
		var htmlTrTableInfoGuiaModal = "";
		guia.procedimentos.forEach(function(procedimento){
			htmlTrTableInfoGuiaModal += "<tr>";
			htmlTrTableInfoGuiaModal += "	<td>" +  procedimento.procedimento.codigoProcedimento + " - " +  procedimento.procedimento.nome + " </td>";
			htmlTrTableInfoGuiaModal += "	<td>" + formatarMoeda(procedimento.valor) + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.viaAcesso + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.video + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.quantidade + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + formatarMoeda(procedimento.valorCalculado) + "</td>";
			htmlTrTableInfoGuiaModal += "</tr>";
		});
		$('#trTableInfoGuiaModal').html(htmlTrTableInfoGuiaModal);
		
		$('#infoGuiaModal').modal('show');
	 }).done(function() {
		 setTimeout(function(){
			 closeLoading();
		 }, 500);
	 }).fail(function(jqXHR) {
			 setTimeout(function(){
			 toRedirectLogin(urlBase);
		 }, 500);
	 });
}
function preparaModalOdonto(id, ano, tipoGuia, urlBase) {
	openLoading();
	$.getJSON( "infoGuiaJson?guiaPK.numeroGuia="+id+"&guiaPK.anoExercicio="+ano+"&guiaPK.tipoGuia.id="+tipoGuia, function(data) {
		var guia = data.guia;
		
		// link downalod despesa
		if (guia.despesa) {
			$('#downloadDespesa').attr('href',"despesa-json-odonto?idAnexoDespesa="+guia.despesa.anexo.id);
		} else {
			$("#downloadDespesa").addClass('disabled');
		}
		//link download guia
		$('#downloadGuia').attr('href',"imprimir-json-odonto?guiaPK.numeroGuia="+id+"&guiaPK.anoExercicio="+ano+"&guiaPK.tipoGuia.id="+tipoGuia);
		
		$('#infModNumeroGuia').html("<strong>Número da Guia: </strong>" + guia.numeroGuia);
		$('#infModTitular').html("<strong>Titular: </strong>" + data.titular);
		
		$('#infModEmissao').html("<strong>Emissão: </strong>" + retornaDataFormatadaByCalendar(guia.dataEmissao));
		$('#infModFuncao').html("<strong>Função: </strong>" + data.funcao);
		
		$('#infModValidade').html("<strong>Validade: </strong>" + retornaDataFormatadaByCalendar(guia.credenciado.dataValidade));
		$('#infModPaciente').html("<strong>Paciente: </strong>" + data.dependente);
		
		$('#infModCredenciado').html("<strong>Credenciado: </strong>" + guia.credenciado.nome);
		$('#infModParcelaServidor').html("<strong>Parcela Servidor: </strong>" + formatarMoeda(data.custoGuiaDTO.parcelaServidor));
		
		$('#infModAcrecimos').html("<strong>Acréscimos: </strong>" + formatarMoeda(data.custoGuiaDTO.totalAcrescimo));
		$('#infModParcelaTRE').html("<strong>Parcela TRE: </strong>" + formatarMoeda(data.custoGuiaDTO.parcelaTRE));
		
		$('#infModTotal').html("<strong>Total: </strong> " + formatarMoeda(data.custoGuiaDTO.total));		
		
		var htmlTrTableInfoGuiaModal = "";
		guia.procedimentosOdonto.forEach(function(procedimento){
			htmlTrTableInfoGuiaModal += "<tr>";
			htmlTrTableInfoGuiaModal += "	<td>" +  procedimento.procedimento.codigoProcedimento + " - " +  procedimento.procedimento.nome + " </td>";
			htmlTrTableInfoGuiaModal += "	<td>" + formatarMoeda(procedimento.valor) + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + procedimento.quantidade + "</td>";
			htmlTrTableInfoGuiaModal += "	<td>" + formatarMoeda(procedimento.valorCalculado) + "</td>";
			htmlTrTableInfoGuiaModal += "</tr>";
		});
		$('#trTableInfoGuiaModal').html(htmlTrTableInfoGuiaModal);
		
		$('#infoGuiaModal').modal('show');
	 }).done(function() {
		 setTimeout(function(){
			 closeLoading();
		 }, 500); 
	 }).fail(function(jqXHR) {
		 setTimeout(function(){
			 toRedirectLogin(urlBase);
		 }, 500);
	 });
}
