<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces" prefix="af"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/html" prefix="afh"%>
<f:view>
  <afh:html>
    <afh:head title="Detalles del producto">
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
    </afh:head>
    <afh:body>
      <h:form>
        <af:panelPage title="Descripción #{productoDetallado.nombre}">
          <f:facet name="menu1"/>
          <f:facet name="menuGlobal"/>
          <f:facet name="branding"/>
          <f:facet name="brandingApp"/>
          <f:facet name="appCopyright"/>
          <f:facet name="appPrivacy"/>
          <f:facet name="appAbout"/>
          <f:facet name="menu3">
            <af:menuList>
              <af:commandMenuItem text="Volver" action="#{productoDetallado.paginaInicial}"/>
              <af:commandMenuItem text="Principal" action="/principal.jsp"/>
            </af:menuList>
          </f:facet>
          <af:panelBox>
            <af:panelForm>
              <af:panelHorizontal>
                <af:objectImage source="#{productoDetallado.foto}"/>
                <af:objectSpacer height="20" width="20"/>
                <af:outputFormatted styleUsage="pageStamp"
                                    value="Descripción: #{productoDetallado.descripcion}"/>
              </af:panelHorizontal>
            </af:panelForm>
          </af:panelBox>
          <af:objectSpacer height="10" width="20"/>
          <af:panelHorizontal>
            <af:commandButton text="Volver" action="#{productoDetallado.paginaInicial}"/>
            <af:objectSpacer height="20" width="20"/>
          </af:panelHorizontal>
        </af:panelPage>
      </h:form>
    </afh:body>
  </afh:html>
</f:view>