<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
	        <div id="breadcrumbs">
	        	<!-- Principal / Seccion / Subseccion -->
	        	<span style="margin-left: 640px">
		        	<logic:present name="operador"> <bean:write name="operador"/></logic:present>
	        	</span>

	        </div>