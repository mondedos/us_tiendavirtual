<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
			<div id="categorias">
				<h3><bean:message key="app.categoria"/></h3>
				<div class="menu-container">
					<ul>
						<li><a href="categoria.do?idcat=0"><bean:message key="app.categoria.0"/></a> </li>
						<li><a href="categoria.do?idcat=1"><bean:message key="app.categoria.1"/></a> </li>
						<li><a href="categoria.do?idcat=2"><bean:message key="app.categoria.2"/></a> </li>
						<li><a href="categoria.do?idcat=3"><bean:message key="app.categoria.3"/></a> </li>
						<li><a href="categoria.do?idcat=4"><bean:message key="app.categoria.4"/></a> </li>
					</ul>
				</div>
			</div>
			
			<html:form action="busqueda.do">
				<div id="busqueda">
					<h3>Búsqueda</h3>
					<div class="menu-container">
						<div class="fila-buscador">
							<label for="categoria">Categoria</label><br/>
							<html:select property="categoria">
								<html:option value=""></html:option>
								<html:option value="0">Televisores</html:option>
								<html:option value="1">Lavadoras</html:option>
								<html:option value="2">Videos/DVD</html:option>
								<html:option value="3">Frigoríficos</html:option>
								<html:option value="4">Pequeños electrodomésticos</html:option>
							</html:select>
						</div>
						<div class="fila-buscador">
							<label for="marca">Marca</label>
							<html:text property="marca"></html:text>
						</div>
						<div class="fila-buscador">
							<label for="chk_avanzada" >
								<bean:message key="app.busqueda.2"/>
								<input class="checkbox" type="checkbox" id="chk_avanzada" name="chk_avanzada" onclick="div=document.getElementById('avanzada'); if(div.style.display=='block') div.style.display='none'; else div.style.display='block'"/>
							</label>
						</div>
						<div id="avanzada" class="fila-buscador nodisplay">
							<div style="text-align: left;">
							Buscar por precios <br><br>
							
							<label for="min">Precio mínimo</label>
								<html:text property="min"> &euro; </html:text><br>
							
							<label for="max">Precio máximo</label>
								<html:text property="max"> &euro; </html:text><br>
								
						</div></div>
						<br>
						<div class="fila-submit">
							<html:submit property="buscar" styleId="enviar">Buscar</html:submit>
						</div>
					</div>
				</html:form>
			</div>