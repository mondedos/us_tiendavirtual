<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
			<div id="categorias">
				<h3>Categorías</h3>
				<div class="menu-container">
					<ul>
						<li><a href="categoria.do?categoria=0">Televisores</a> </li>
						<li><a href="categoria.do?categoria=1">Lavadoras</a> </li>
						<li><a href="categoria.do?categoria=2">Videos/DVD</a> </li>
						<li><a href="categoria.do?categoria=3">Frigoríficos</a> </li>
						<li><a href="categoria.do?categoria=4">Pequeños electrodomésticos</a> </li>
					</ul>
				</div>
			</div>
			<div id="busqueda">
				<h3>Búsqueda</h3>
				<div class="menu-container">
					<div class="fila-buscador">
						<label for="sel_categoria">Categoria</label><br/>
						<select name="sel_categoria" id="sel_categoria">
							<option>Televisores</option>
							<option>Lavadoras</option>
							<option>Videos/DVD</option>
							<option>Frigoríficos</option>
							<option>Pequeños electrodomésticos</option>
						</select>
					</div>
					<div class="fila-buscador">
						<label for="txt_marca">Marca</label>
						<input type="text" id="txt_marca" name="txt_marca" />
					</div>
					<div class="fila-buscador">
						<label for="chk_avanzada" >
							Busq. avanzada
							<input class="checkbox" type="checkbox" id="chk_avanzada" name="chk_avanzada" onclick="div=document.getElementById('avanzada'); if(div.style.display=='block') div.style.display='none'; else div.style.display='block'"/>
						</label>
					</div>
					<div id="avanzada" class="fila-buscador nodisplay">
						<div style="text-align: left;">Buscar por precios</div>
						<label for="txt_min">Mínimo</label>
						<input type="text" id="txt_min" name="txt_min" /> &euro;
						<label for="txt_max">Máximo</label>
						<input type="text" id="txt_max" name="txt_max" /> &euro;
					</div>
					<noscript>
					<div id="avanzada" class="fila-buscador">
						<div style="text-align: left;">Buscar por precios</div>
						<label for="txt_min">Mínimo</label>
						<input type="text" id="txt_min" name="txt_min" /> &euro;
						<label for="txt_max">Máximo</label>
						<input type="text" id="txt_max" name="txt_max" /> &euro;
					</div>
					</noscript>

					<div class="fila-submit">
						<input class="boton" type="submit" name="Buscar" value="Buscar"/>
					</div>
				</div>
			</div>

			<div id="opciones">
				<h3>Opciones</h3>
				<div class="menu-container">
					<ul>
						<li><a href="login.do">Login</a></li>
						<li><a href="categoria.do?categoria=0">Añadir producto</a> </li>
						<li><a href="categoria.do?categoria=1">Crear Oferta</a> </li>
						<li><a href="categoria.do?categoria=2">Solicitar asignación de pedido</a> </li>
						<li><a href="categoria.do?categoria=3">Ver lista de pedidos</a> </li>
						<li><a href="categoria.do?categoria=4">Salir del sistema</a> </li>
					</ul>
				</div>
			</div>
