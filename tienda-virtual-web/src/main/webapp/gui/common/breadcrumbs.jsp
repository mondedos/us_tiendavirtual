<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
	        <div id="breadcrumbs">
	        	Principal / Seccion / Subseccion
	        	<logic:present name="idOperator"><bean:write name="idOperador" /></logic:present>
	        	<logic:notPresent name="idOperator">No hay usuario</logic:notPresent>
	        </div>