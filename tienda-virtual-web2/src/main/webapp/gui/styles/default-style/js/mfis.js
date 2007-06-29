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
	
	if (objForm.chk_avanzada.checked) {
		if ((((objForm.min.value.match("^[0-9]+$")) || (objForm.min.value.match("^[1-9](\.[0-9]{3})+$"))) &&
			((objForm.max.value.match("^[0-9]+$")) || (objForm.max.value.match("^[1-9](\.[0-9]{3})+$"))))) {
				res = true;
		} else {
				window.alert("Por favor, introduzca un precio minimo y un precio maximo correctos para la busqueda.");
				res = false;
		}
	} else {
		res = true;
		// Reiniciamos el checkbox para que no se busque por precios.
		objForm.min.value = "";
		objForm.max.value = "";
	}
	
	return (res);
}