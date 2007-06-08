<%@ page 
    contentType="text/html;charset=windows-1252"
    isELIgnored="true"
%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

    <div class="nav-paginado">
<%/*
<c:forEach begin="1" end="${paginado.numpaginas}" var="item">
  <c:choose>
    <c:when test="${item == paginado.pagina}">
      <span class="color<c:out value='${acron}'/>"><c:out value="${item}"/></span>
    </c:when>
    <c:when test="${item != paginado.pagina}">
      <a class="opciones" href="paginador.do?p=<c:out value="${item}" />"><c:out value="${item}"/></a>
    </c:when>
  </c:choose>  
</c:forEach>
      <br/>
*/%>
        <div class="num-reg"><c:out value="${paginado.firstPageElement+1}" />-<c:out value="${paginado.lastPageElement+1}" /> de <span class="numRegistros"><c:out value="${paginado.sizeCollection}" /></span> Registros</div>
<c:choose>
    <c:when test="${paginado.pagina <= 1}">
        <img src="recursos/img/pag-inicio.jpg" alt="<bean:message key="app.paginador.labelinicio"/>" title="<bean:message key="app.paginador.labelinicio"/>">
    </c:when>              
    <c:when test="${paginado.pagina > 1}">
        <a class="opciones" href="paginador.do?p=1"><img src="recursos/img/pag-inicio.jpg" alt="<bean:message key="app.paginador.labelfin"/>" title="<bean:message key="app.paginador.labelfin"/>"></a> 
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${paginado.pagina <= 1}">
        <img src="recursos/img/pag-anterior.jpg" alt="<bean:message key="app.paginador.labelanterior"/>" title="<bean:message key="app.paginador.labelanterior"/>">
    </c:when>              
    <c:when test="${paginado.pagina > 1}">
        <a class="opciones" href="paginador.do?p=<c:out value="${paginado.pagina-1}" />"><img src="recursos/img/pag-anterior.jpg" alt="<bean:message key="app.paginador.labelanterior"/>" title="<bean:message key="app.paginador.labelanterior"/>"></a> 
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${paginado.pagina < paginado.numpaginas}">
        <a class="opciones" href="paginador.do?p=<c:out value="${paginado.pagina+1}" />"><img src="recursos/img/pag-siguiente.jpg" alt="<bean:message key="app.paginador.labelsiguiente"/>" title="<bean:message key="app.paginador.labelsiguiente"/>"></a> 
    </c:when>
    <c:when test="${paginado.pagina >= paginado.numpaginas}">
        <img src="recursos/img/pag-siguiente.jpg" alt="<bean:message key="app.paginador.labelsiguiente"/>" title="<bean:message key="app.paginador.labelsiguiente"/>">        
    </c:when>  
</c:choose>
<c:choose>
    <c:when test="${paginado.pagina >= paginado.numpaginas}">
        <img src="recursos/img/pag-final.jpg" alt="<bean:message key="app.paginador.labelfin"/>" title="<bean:message key="app.paginador.labelfin"/>">
    </c:when>              
    <c:when test="${paginado.pagina < paginado.numpaginas}">
        <a class="opciones" href="paginador.do?p=<c:out value="${paginado.numpaginas}" />"><img src="recursos/img/pag-final.jpg" alt="<bean:message key="app.paginador.labelfin"/>" title="<bean:message key="app.paginador.labelfin"/>"></a> 
    </c:when>
</c:choose>
    <a class="opciones" href="paginador.do?p=0"><img src="recursos/img/pag-todos.jpg" alt="<bean:message key="app.paginador.labeltodos"/>" title="<bean:message key="app.paginador.labeltodos"/>"></a>
    <img src="recursos/img/pag-imprimir.jpg" alt="<bean:message key="app.paginador.labelimprimir"/>" title="<bean:message key="app.paginador.labelimprimir"/>">
    </div>