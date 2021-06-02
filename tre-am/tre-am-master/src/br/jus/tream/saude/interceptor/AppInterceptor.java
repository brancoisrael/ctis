package br.jus.tream.saude.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import br.jus.tream.saude.action.LoginAction;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;

@SuppressWarnings("serial")
public class AppInterceptor implements Interceptor {

	public void destroy() {
	}

	// called during interceptor initialization
	public void init() {
	}

	// put interceptor code here
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "success";

		/* VERIFICANDO A SESS�O */
		try {
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("loginTRE");
			UsuarioCredenciadaVW credenciada = (UsuarioCredenciadaVW) session.getAttribute("loginCredenciada");
			Usuario usuarioAdm = (Usuario) session.getAttribute("loginAdmTRE");

			if (usuario != null || credenciada != null || usuarioAdm != null) {
				return invocation.invoke();
			}

			Object action = invocation.getAction();

	        // sb: if this request does require login and the current action is
	        // not the login action, then redirect the user
	        if (!(action instanceof LoginAction)) {
	            return "loginNecessario";
	        }

	        // sb: they either requested the login page or are submitting their
	        // login now, let it through
	        return invocation.invoke();

		} catch (Exception e) {
			result = "error";
		}

		return result;
	}

}