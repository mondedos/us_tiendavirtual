package struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/*
 * Clase que encapsula todo lo necesario
 * request, response, form, mapping, session y errors
 * */
public final class WebContext {

	private ActionMapping mapping;
	private ActionForm form;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ActionErrors errors;

	/**
	 * Construye el objeto.
	 */
	public WebContext(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session) {
		super();
		this.mapping = mapping;
		this.form = form;
		this.request = request;
		this.response = response;
		this.session = session;

		this.errors = new ActionErrors();
	}

	public ActionErrors getErrores() {
		return errors;
	}

  public void setErrors(ActionErrors errors) {
    this.errors = errors;
  }

	public final ActionForm getForm() {
		return form;
	}

	public final ActionMapping getMapping() {
		return mapping;
	}

	public final HttpServletRequest getRequest() {
		return request;
	}

	public final HttpServletResponse getResponse() {
		return response;
	}

	public final HttpSession getSession() {
		return session;
	}

	public Object getSession(String key) {
		return session.getAttribute(key);
	}

	public void setSession(String key, Object val) {
		session.setAttribute(key, val);
	}

	public void removeSession(String key) {
		session.removeAttribute(key);
	}

	public String getParameter(String key) {
		return request.getParameter(key);
	}

	public Object getRequest(String key) {
		return request.getAttribute(key);
	}

	public void setRequest(String key, Object val) {
		request.setAttribute(key, val);
	}

	public void removeRequest(String key) {
		request.removeAttribute(key);
	}



}
