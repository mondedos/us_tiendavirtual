<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
			<div id="categorias">
				<h3><bean:message key="app.categoria"/></h3>
				<div class="menu-container">
					<ul>
						<li><a href="categoria.do?categoria=0"><bean:message key="app.categoria.0"/></a> </li>
						<li><a href="categoria.do?categoria=1"><bean:message key="app.categoria.1"/></a> </li>
						<li><a href="categoria.do?categoria=2"><bean:message key="app.categoria.2"/></a> </li>
						<li><a href="categoria.do?categoria=3"><bean:message key="app.categoria.3"/></a> </li>
						<li><a href="categoria.do?categoria=4"><bean:message key="app.categoria.4"/></a> </li>
					</ul>
				</div>
			</div>
			<div id="busqueda">
				<h3><bean:message key="app.categoria.0"/></h3>
				<div class="menu-container">
					<div class="fila-buscador">
						<label for="sel_categoria"><bean:message key="app.busqueda.0"/></label><br/>
						<select name="sel_categoria" id="sel_categoria">
							<option>Televisores</option>
							<option>Lavadoras</option>
							<option>Videos/DVD</option>
							<option>Frigoríficos</option>
							<option>Pequeños electrodomésticos</option>
						</select>
					</div>
					<div class="fila-buscador">
						<label for="txt_marca"><bean:message key="app.busqueda.1"/></label>
						<input type="text" id="txt_marca" name="txt_marca" />
					</div>
					<div class="fila-buscador">
						<label for="chk_avanzada" >
							<bean:message key="app.busqueda.2"/>
							<input class="checkbox" type="checkbox" id="chk_avanzada" name="chk_avanzada" onclick="div=document.getElementById('avanzada'); if(div.style.display=='block') div.style.display='none'; else div.style.display='block'"/>
						</label>
					</div>
					<div id="avanzada" class="fila-buscador nodisplay">
						<div style="text-align: left;"><bean:message key="app.busqueda.3"/></div>
						<label for="txt_min"><bean:message key="app.busqueda.4"/></label>
						<input type="text" id="txt_min" name="txt_min" /> &euro;
						<label for="txt_max"><bean:message key="app.busqueda.5"/></label>
						<input type="text" id="txt_max" name="txt_max" /> &euro;
					</div>
					<noscript>
					<div id="avanzada" class="fila-buscador">
						<div style="text-align: left;"><bean:message key="app.busqueda.3"/></div>
						<label for="txt_min"><bean:message key="app.busqueda.4"/></label>
						<input type="text" id="txt_min" name="txt_min" /> &euro;
						<label for="txt_max"><bean:message key="app.busqueda.5"/></label>
						<input type="text" id="txt_max" name="txt_max" /> &euro;
					</div>
					</noscript>

					<div class="fila-submit">
						<input class="boton" type="submit" name="Buscar" value="Buscar"/>
					</div>
				</div>
			</div>
