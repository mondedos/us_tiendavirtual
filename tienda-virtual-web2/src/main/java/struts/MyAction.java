package struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


public abstract class MyAction extends Action {

	// Extendiendo de esta clase mapeamos directamente con el fichero struts-config.xml
	// Solo habría que retornar en el método execute
	// el nombre del forward definido en un <action>
	// Por ejemplo retornar success para el siguiente ejemplo de struts-config
	//
	// <action path="/login" scope="request" name="loginFrm" type="mfis.tiendavirtual.struts.actions.LoginAction">
	//   <forward name="success" path="index.jsp"/>
	// </action>

	public static final String F_ENTRADA = "mainpage";

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

		WebContext c = new WebContext(mapping, form, request, response, session);
		String resultado;

		if (session == null) {
			resultado = F_ENTRADA;
		} else {
			//System.out.println("MyAction: " + getClass().getName());
			// Llamada a nuestras acciones
			resultado = execute(c);
		}

		ActionMessages e = c.getErrores();
		if (e != null) {
			saveErrors(request, e);
		}

		ActionForward res = mapping.findForward(resultado);
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
			}
		}
	}

}
