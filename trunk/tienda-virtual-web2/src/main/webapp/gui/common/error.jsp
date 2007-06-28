<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<div class="menu-container">	
		<bean:write name="mensajeError"/>
		<br>
		<br>
		<bean:define id="mensaje" name="mensajeError"/>
		<bean:define id="opt" name="opt"/>	
		
<% String s = "listado.do?opt=" + (String) pageContext.findAttribute("opt");
		//+ "&lid=" + (String) pageContext.findAttribute("lid") + "&idcat=" + (String) pageContext.findAttribute("idcat") + "&idpr=" +
		//(String) pageContext.findAttribute("idpr");
	System.out.println(s);
%>
		<a href=<%=s%>>Volver a la página anterior</a>
</div>