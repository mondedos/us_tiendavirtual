package struts;


import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.tiles.actions.TilesAction;

public abstract class MyTilesAction extends TilesAction {

	// Extendiendo de esta clase mapeamos directamente con el fichero tiles-defs.xml
	// Solo habría que retprnar en el método execute
	// el nombre de plantilla definida en tiles-defs.xml
	// Por ejemplo retornar .mainLayout para esta plantilla
	//
	//    <definition name=".mainLayout" path="/gui/layouts/mainLayout.jsp">
	//    	<put name="header" value="/gui/common/header.jsp"/>
	//    	<put name="breadcrumbs" value="/gui/common/breadcrumbs.jsp"/>
	//    	<put name="left" value="/gui/common/left.jsp"/>
	//    	<put name="right" value="/gui/common/right.jsp"/>
	//    	<put name="foot" value="/gui/common/foot.jsp"/>
	//    </definition>

	public static final String MAINPAGE = ".mainLayout";
	public static final String MENUPAGE = ".menuLayout";
	public static final String OPERADOR = ".adminLayout";
	public static final String PRODUCTO = ".detalleLayout";
	public static final String LOGIN 	= ".loginLayout";
	public static final String COMPRA 	= ".compraLayout";
	protected ResourceBundle bundle = ResourceBundle.getBundle("messages");

	private HttpSession obtenerSesion(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("SE HA TERMINADO LA SESSION - sesion nueva o nula");
			session.invalidate();
			session = null;
		}
		return session;
	}

	public final ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		HttpSession session = obtenerSesion(request);

		WebContext c =
			new WebContext(mapping, form, request, response, session);
		String resultado;

		if (session == null) {
			resultado = MAINPAGE;
		} else {
			resultado = execute(c);
		}

		ActionMessages e = c.getErrores();
		if (e != null) {
			saveErrors(request,e );
		}

        ActionForward res = null;
        if(request.getParameter("js") == null){
            res = new ActionForward(resultado);
        } else {
            res = mapping.findForward(resultado);
        }

		return res;
	}

	public abstract String execute(WebContext c) throws Exception;


	protected final void log(String mensaje) {
		if (mensaje != null && mensaje.length() > 0) {
			try {
				StringBuffer sb = new StringBuffer("[Clase: ");
				String clase = this.getClass().getName();
				clase = clase.substring(clase.lastIndexOf('.') + 1);
				sb.append(clase);
				sb.append("]: ");
				sb.append(mensaje);
				System.out.println(sb.toString());
			} catch (Exception e) {
                            e.printStackTrace();
			}
		}
	}

}
