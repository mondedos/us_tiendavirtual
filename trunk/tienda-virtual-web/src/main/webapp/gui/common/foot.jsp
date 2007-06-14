<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
		<div id="foot">
			<h6>
				<strong><bean:message key="app.foot"/></strong>
				<bean:message key="app.foot.direccion"/>.
				<bean:message key="app.foot.telefono"/>
				<a href="mailto:<bean:message key="app.foot.email"/>"><bean:message key="app.foot.email"/></a>
			</h6>
		</div>