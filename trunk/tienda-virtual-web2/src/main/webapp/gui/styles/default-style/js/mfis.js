var defaultEmptyOK = false

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
	var categoria = objForm.categoria;
	var marca= objForm.marca;
	var avanzada = objForm.chk_avanzada;
	var maximo = objForm.max;
	var minimo = objForm.min;
	
	// Comprobamos que debe de existir al menos una propiedad seleccionada	
	if (categoria.value == "" && marca.value == "" && avanzada.checked == false){
		window.alert("Debe seleccionar al menos una opcion de busqueda");
		return (false);
	} if (categoria.value == "" && marca.value == "" && avanzada.checked == true && maximo.value == "" && minimo.value == "") {
		window.alert("Debe seleccionar al menos una opcion de busqueda.");
		return (false);
	} // Comprobamos el rango de valores.
	if (objForm.chk_avanzada.checked) {
		// Comprobamos que el rango de valores es numerico.
		var valorMinimo = minimo.value;
		var valorMaximo = maximo.value;
		if (isNumber(valorMinimo)) {
			if (isNumber(valorMaximo)) {
				res = true;
			} else if (valorMaximo == '') {
				res = true; 
			} else {
				window.alert("Por favor, introduzca un precio maximo correcto para la busqueda.");
				res = false;
			}
		} else if (valorMinimo == '') {
			if (isNumber(valorMaximo)) {
				res = true;
			} else {
				window.alert("Por favor, introduzca un precio maximo correcto para la busqueda.");
				res = false;
			}
		} else if (valorMaximo == '') {
			if (isNumber(valorMinimo)) {
				res = true;
			} else {
				window.alert("Por favor, introduzca un precio minimo correcto para la busqueda.");
				res = false;
			}
		} else {
				window.alert("Por favor, introduzca un precio minimo y un precio maximo correctos para la busqueda.");
				res = false;
		} 
	} else {
	 	res = true;
	}
	
	return (res);
}

function paypal() {	
    var formulario = document.getElementById("formulario");
    
    formulario.submit();
}

function isNumber (s)
{   var i;
    var dotAppeared;
    dotAppeared = false;
    if (isEmpty(s)) 
       if (isNumber.arguments.length == 1) return defaultEmptyOK;
       else return (isNumber.arguments[1] == true);
    
    for (i = 0; i < s.length; i++)
    {   
        var c = s.charAt(i);
        if( i != 0 ) {
            if ( c == "." ) {
                if( !dotAppeared )
                    dotAppeared = true;
                else
                    return false;
            } else     
                if (!isDigit(c)) return false;
        } else { 
            if ( c == "." ) {
                if( !dotAppeared )
                    dotAppeared = true;
                else
                    return false;
            } else     
                if (!isDigit(c) && (c != "-") || (c == "+")) return false;
        }
    }
    return true;
}

// s es vacio
function isEmpty(s)
{   return ((s == null) || (s.length == 0))
}

// c es un digito
function isDigit (c)
{   return ((c >= "0") && (c <= "9"))
}

// c es un formulario
function validarUnidades (c)
{  
	if(c.unidades.value <= 0){
		window.alert("Por favor introduzca una cantidad mayor que cero.");
		return false;
	}
	else
		return true;
}