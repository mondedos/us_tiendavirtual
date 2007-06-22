<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
			
			<div id="top-ventas">
				<h3>Lo más vendido</h3>
				<div class="mini-container">
					<logic:iterate name="lista" id="producto">
						<bean:write name="producto" property="marca"/>
						<img src="<bean:write name="urlImg"/>/<bean:write name="producto" property="foto"/>" />
						</logic:iterate>
				</div>
			</div>