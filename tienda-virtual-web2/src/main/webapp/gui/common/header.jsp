<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

		<div id="header">
			<logic:notPresent name="operador">
				<h1><a href="start.do"><img src="gui/images/logo.gif" alt="<bean:message key="app.header.title"/>" title="<bean:message key="app.header.title"/>"/></a><img src="gui/images/lema.jpg" alt="<bean:message key="app.header.subtitle"/>" title="<bean:message key="app.header.subtitle"/>"/></h1>
			</logic:notPresent>
			<logic:present name="operador">
				<img src="gui/images/logo.jpg" alt="<bean:message key="app.header.title"/>" title="<bean:message key="app.header.title"/>"/>
			</logic:present>
		</div>