function validarPagina(objForm) {

	 var cadena = objForm.direccionUsuario;

	 if(cadena.value != ''){
	 	return (true);
	 } else {
	 	window.alert("Por favor, introduzca la direccion a la que desea que le sea enviado el pedido.");
		return (false);
	 }

}

function validarBusqueda(objForm) {
	var res = true;
	
	
	var categoria= objForm.categoria;
	var marca= objForm.marca;
	var avanzada= objForm.chk_avanzada;
	var maximo= objForm.max;
	var minimo= objForm.min;
	
	//comprobamos que debe de existir al menos una propiedad seleccionada
	
	if(categoria.value=="" && marca.value=="" && avanzada.checked==false){
		window.alert("Debe seleccionar al menos una opcion de busqueda");
		return false;
	}
	
	if(categoria.value=="" && marca.value=="" && avanzada.checked==true && maximo.value=="" && minimo.value==""){
		window.alert("Debe seleccionar al menos una opcion de busqueda");
		return false;
	}
	
	
	//comprobamos el rango de valores
		
	if (objForm.chk_avanzada.checked) {
	
		//comprobamos que el rango de valores es numerico
		var valorMinimo= minimo.value;
		var valorMaximo= maximo.value;
		
		//TODO este codigo falla, debe de comprobar que el rango es numerico
		if ((((objForm.min.value.match("^[0-9]+$")) || (objForm.min.value.match("^[1-9](\.[0-9]{3})+$")) || objForm.min.value == '') &&
			((objForm.max.value.match("^[0-9]+$")) || (objForm.max.value.match("^[1-9](\.[0-9]{3})+$"))) || objForm.max.value == '')) {
				res = true;
		} else {
				window.alert("Por favor, introduzca un precio minimo y un precio maximo correctos para la busqueda.");
				res = false;
		}
		
		
		//comprobamos que el rango de valores es correcto
		
		if(res && minimo.value!="" && maximo.value!="" && minimo.value>maximo.value){
			res= false;
			window.alert("El rango es incorrecto");
		}
		
	} else{
	 	res = true;
	}
	 	
	
	
	return (res);

function paypal(){
        	
    var formulario= document.getElementById("formulario");
    formulario.submit();
}