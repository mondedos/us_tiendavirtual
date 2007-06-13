<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3><bean:write name="titulo"/></h3>
				<div class="mini-container">
					<ol>
<logic:iterate name="lista" id="producto">
						<li>
							<p><bean:write name="producto" property="marca"/></p>
							<p><bean:write name="producto" property="modelo"/></p>
							<p><bean:write name="producto" property="dimensiones"/></p>
						</li>
						<hr/>
</logic:iterate>
					</ol>
				</div>
			</div>