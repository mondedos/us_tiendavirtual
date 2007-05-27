<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces" prefix="af"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/html" prefix="afh"%>
<f:view>
  <afh:html>
    <afh:head title="Consultar producto">
      <meta http-equiv="Content-Type"
            content="text/html; charset=windows-1252"/>
    </afh:head>
    <afh:body>
      <h:form>
        <af:panelBox text="Lista de artículos">
          <af:table emptyText="No hay elementos" rows="10" var="producto"
                    value="#{consultaProducto.listaProducto}" banding="row">
            <af:column sortable="false" headerText="Nombre">
              <af:commandLink actionListener="#{consultaProducto.verDetalles}"
              					action="/detalleProducto.jsp" 
              					text="#{producto.nombre}">
                <af:outputText value="#{producto.id}"/>
              </af:commandLink>
            </af:column>
            <af:column sortable="false" headerText="Precio">
              <af:outputText/>
            </af:column>
            <af:column sortable="false" headerText="Fecha">
              <af:outputText/>
            </af:column>
          </af:table>
        </af:panelBox>
      </h:form>
    </afh:body>
  </afh:html>
</f:view>