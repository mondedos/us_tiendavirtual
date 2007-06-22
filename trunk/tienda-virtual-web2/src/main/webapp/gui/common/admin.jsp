<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
			<div id="opciones">
				<h3><bean:message key="app.opciones"/></h3>
				<div class="menu-container">
					<ul>
						<li><a href="opciones.do?opt=1"><bean:message key="app.opciones.1"/></a> </li>
						<li><a href="opciones.do?opt=2"><bean:message key="app.opciones.2"/></a> </li>
						<li><a href="opciones.do?opt=3"><bean:message key="app.opciones.3"/></a> </li>
						<li><a href="opciones.do?opt=4"><bean:message key="app.opciones.4"/></a> </li>
					</ul>
				</div>
			</div>