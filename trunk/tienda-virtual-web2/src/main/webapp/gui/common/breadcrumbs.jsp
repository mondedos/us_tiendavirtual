<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
	        <div id="breadcrumbs">
	        	<!-- Principal / Seccion / Subseccion -->
			<logic:present name="migas">
	        	<logic:iterate name="migas"  id="migas">
	        		<logic:equal name="migas" property="value" value="">
		        		<span><bean:write name="migas" property="label"/></span> /
	        		</logic:equal>
	        		<logic:notEqual name="migas" property="value" value="">
		        		<span><a href="<bean:write name="migas" property="value"/>"><bean:write name="migas" property="label"/></a></span> /
	        		</logic:notEqual>
	        	</logic:iterate>
			</logic:present>
			<logic:present name="operador">
	        	<span style="margin-left: 600px">
		        	Operador: <bean:write name="operador"/>
	        	</span>
	        </logic:present>

	        </div>