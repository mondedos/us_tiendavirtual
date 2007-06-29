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
	window.alert("Hola.");
	var res = true;
	
	window.alert(objForm.min.value);
	
	/*
	if ((((objForm.min.value.matches("[0-9]+")) || (objForm.min.value.matches("[1-9](\.[0-9]{3})+"))) &&
	((objForm.max.value.matches("[0-9]+")) || (objForm.max.value.matches("[1-9](\.[0-9]{3})+")))) {
		res = (true);
		window.alert("Cierto.";
	} else {
		window.alert("Por favor, introduzca un precio minimo y un precio maximo correctos para la busqueda.");
		res = (false);
		window.alert("Falso.");
	}*/
	
	return (res);
}