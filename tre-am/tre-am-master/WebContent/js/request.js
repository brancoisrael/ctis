function RequestAjax() {	
	
	var Url = "Sem Url";
	this.ShowUrl = DisplayUrl;
	this.SetUrl = SetUrl;
	
	function DisplayUrl(){
	    alert(URL);
	  }
	
	function SetUrl(_url) {
		Url = _url;
	}
}

/*
function Carro()
{
  var Marca = "Sem marca";
  var Modelo = "Sem modelo";
  this.SetMarca = SetMarca;
  this.SetModelo = SetModelo;
  this.ShowMarca = DisplayMarca;
  this.ShowModelo = DisplayModelo; 
    
  function DisplayMarca(){
    alert(Marca);
  }
    
  function DisplayModelo(){
    alert(Modelo);
  }
    
  function SetMarca(_marca) {
    Marca = _marca;
  }
    
  function SetModelo(_modelo) {
      Modelo = _modelo;
  }
    
  }*/