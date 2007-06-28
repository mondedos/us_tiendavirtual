function validarPagina(objForm) {

	 var cadena = objForm.direccionUsuario;

	 if(cadena.value != ''){
	 	return true;
	 } else {
	 	window.alert("Por favor, introduzca la direccion a la que desea que le sea enviado el pedido.");
		return (false);
	 }

}