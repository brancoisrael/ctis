function dateToBr(date)
{	
	var d = new Date(date);
	return d.toLocaleDateString();
}
function formatarMoeda(valor) {
	if (valor) {
		return valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
	}
	return 0;
}
function formatarMoedaSemCifrao(valor) {
	if (valor) {
		return valor.toLocaleString('pt-BR', { currency: 'BRL' });
	}
	return 0;
}
function retornaDataFormatadaByCalendar(objeto) {
	return ("00" + objeto.dayOfMonth).slice(-2) + "/" + ("00" + objeto.monthValue).slice(-2) + "/" + objeto.year;
}

function geraPagination(pag, pageNumber) {	
	var maxinoExibicao = 10;
	var intervalo = '<li class="page-item" style="margin-left: 10px; margin-right: 10px;"> ... </li>';
	var html = '';
	html += '<div class="col-12">';
	html += '<nav aria-label="Page navigation example">';
	html += '<ul class="pagination justify-content-center">';
	if (pag > 1) {
		var paginaAnterior = parseInt(pag) - parseInt(1);
		html += '    <li class="page-item">';
	    html += '    	<a class="page-link" onclick="pesquisar(' + paginaAnterior + ')"  aria-label="Previous">';
	    html += '			<span aria-hidden="true">&laquo;</span>';
	    html += '		</a>';
	    html += '	</li>';
	}
	
	//pagina 1
	var active = '';
	if (pag == 1) {
		 active = 'active';
	}
    html += '<li class="page-item ' + active + '">';
    html += '<a class="page-link" onclick="pesquisar(1)">1</a>';
    html += '</li>';
    //pagina 1 
    
    if (pag > (parseInt(maxinoExibicao) + 2)) {
    	html += intervalo;
    }
    
    var number = parseInt(pag) + parseInt(maxinoExibicao); 
    if (number > pageNumber) {
    	number = pageNumber;
    }
    for (var i = 2; i < number; i++) {
    	active = '';
    	if (pag == i) {
    		 active = 'active';
    	}
    	
    	if ( (parseInt(i) + parseInt(maxinoExibicao) + 1) > parseInt(pag)) {
		    html += '<li class="page-item ' + active + '">';
		    html += '<a class="page-link" onclick="pesquisar('+i+')">';
		    html += i;
		    html += ' </a>';
		    html += '</li>';
    	}
    }
    
    if (pageNumber > maxinoExibicao && (parseInt(pag) + parseInt(maxinoExibicao)) < parseInt(pageNumber)) {
    	html += intervalo;
    }
    
    //ultima pagina
    if (pageNumber > 1) {
    	active = '';
    	if (pag == pageNumber) {
   		 	active = 'active';
    	}
       html += '<li class="page-item ' + active + '">';
       html += '<a class="page-link" onclick="pesquisar('+pageNumber+')">';
       html += pageNumber;
       html += ' </a>';
       html += '</li>';
    }
    //ultima pagina
    
    if (pag != pageNumber && pageNumber > 0) {
    	var paginaPosterior = parseInt(pag) + parseInt(1);
	    html += '<li class="page-item">';
	    html += '	<a class="page-link" onclick="pesquisar(' + paginaPosterior + ')"  aria-label="Next">';
	    html += '   	<span aria-hidden="true">&raquo;</span>';
	    html += '    </a>';
	    html += '</li>';
    }
    html += '</ul>';
    html += '</div>';
    $("#pagination").html(html);
}

function geraPaginationBkp(pag, pageNumber) {	
	var html = '';
	html += '<div class="col-12">';
	html += '<nav aria-label="Page navigation example">';
	html += '<ul class="pagination justify-content-center">';
	if (pag > 1) {
		var paginaAnterior = parseInt(pag) - parseInt(1);
		html += '    <li class="page-item">';
	    html += '    	<a class="page-link" onclick="pesquisar(' + paginaAnterior + ')"  aria-label="Previous">';
	    html += '			<span aria-hidden="true">&laquo;</span>';
	    html += '		</a>';
	    html += '	</li>';
	}      
    for (var i = 1; i <= pageNumber; i++) {
    	var active = '';
    	if (pag == i) {
    		 active = 'active';
    	}
	    html += '<li class="page-item ' + active + '">';
	    html += '<a class="page-link" onclick="pesquisar('+i+')">';
	    html += i;
	    html += ' </a>';
	    html += '</li>';
    }
    if (pag != pageNumber && pageNumber > 0) {
    	var paginaPosterior = parseInt(pag) + parseInt(1);
	    html += '<li class="page-item">';
	    html += '	<a class="page-link" onclick="pesquisar(' + paginaPosterior + ')"  aria-label="Next">';
	    html += '   	<span aria-hidden="true">&raquo;</span>';
	    html += '    </a>';
	    html += '</li>';
    }
    html += '</ul>';
    html += '</div>';
    $("#pagination").html(html);
}

function exibirMensagemSuccess(mensagem) {
	$.notify({
			title: '<strong>Mensagem </strong>',
		message: mensagem
	},{
		type: 'success'
	});
}
function exibirMensagemDanger(mensagem) {
	$.notify({
			title: '<strong>Ocorreu um erro</strong>',
		message: mensagem
	},{
		type: 'danger'
	});
}

function toRedirectLogin(urlBase) {
	url = urlBase + "/login/logout";
	window.location.replace(url);
}

/**
 *  exemplo mask
 * $('.date').mask('00/00/0000');
  $('.time').mask('00:00:00');
  $('.date_time').mask('00/00/0000 00:00:00');
  $('.cep').mask('00000-000');
  $('.phone').mask('0000-0000');
  $('.phone_with_ddd').mask('(00) 0000-0000');
  $('.phone_us').mask('(000) 000-0000');
  $('.mixed').mask('AAA 000-S0S');
  $('.ip_address').mask('099.099.099.099');
  $('.percent').mask('##0,00%', {reverse: true});
  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
  $('.fallback').mask("00r00r0000", {
    translation: {
      'r': {
        pattern: /[\/]/,
        fallback: '/'
      },
      placeholder: "__/__/____"
    }
  });

  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});

  $('.cep_with_callback').mask('00000-000', {onComplete: function(cep) {
      console.log('Mask is done!:', cep);
    },
     onKeyPress: function(cep, event, currentField, options){
      console.log('An key was pressed!:', cep, ' event: ', event, 'currentField: ', currentField.attr('class'), ' options: ', options);
    },
    onInvalid: function(val, e, field, invalid, options){
      var error = invalid[0];
      console.log ("Digit: ", error.v, " is invalid for the position: ", error.p, ". We expect something like: ", error.e);
    }
  });

  $('.crazy_cep').mask('00000-000', {onKeyPress: function(cep, e, field, options){
    var masks = ['00000-000', '0-00-00-00'];
      mask = (cep.length>7) ? masks[1] : masks[0];
    $('.crazy_cep').mask(mask, options);
  }});

  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
  $('.cpf').mask('000.000.000-00', {reverse: true});
  $('.money').mask('#.##0,00', {reverse: true});
 */
