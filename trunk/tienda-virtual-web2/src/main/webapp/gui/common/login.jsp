<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3><bean:message key="app.login.title"/></h3>
				<div class="mini-container">
					<div class="campos">
						<html:form action="/login" method="post" styleId="entrada">
		                	<fieldset>
		                    	<div class="campo">
		                        	<div class=""><bean:message key="app.login.user"/></div>

									<label for="usuario">
										<html:text styleId="usuario" property="usuario" />
									</label>

		                        </div>
								<div class="campo">
		                            <div class=""><bean:message key="app.login.passwd" /></div>

		                            <label for="clave">
		                            	<html:password property="clave" styleId="clave" />
									</label>

								</div>
								<div class="boton">
		                             <html:submit property="enviar" styleId="enviar"><bean:message key="app.login.buttom"/></html:submit>
								</div>
		                    </fieldset>
		                </html:form>
		            </div>
				</div>
			</div>