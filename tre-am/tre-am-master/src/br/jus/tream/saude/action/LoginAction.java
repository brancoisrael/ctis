package br.jus.tream.saude.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opensymphony.xwork2.ActionSupport;

import br.jus.tream.saude.DAO.LoginAD;
import br.jus.tream.saude.DAO.UsuarioDAOImpl;
import br.jus.tream.saude.business.UsuarioCredenciadaBusiness;
import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;
import br.jus.tream.saude.enumeration.PerfilUsuarioLogin;

@Namespace("/login")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	SessionMap<String, Object> sessionmap;
	private String username;
	private String userpass;
	private Usuario usuario;
	private Boolean verificaNoAd = true;
	private Boolean loginCredenciada = false;
	private List<PerfilUsuarioLogin> perfisUsuarioLogin = new ArrayList<PerfilUsuarioLogin>();
	private PerfilUsuarioLogin perfilUsuarioSelecionado;
	@Action(value = "frmSetup", results = { @Result(name = "success", location = "/frmLogin.jsp"),
			@Result(name = "error", location = "/pages/frmLogin.jsp") })
	public String setupLogin() {
		
		carregaPerfilTipoLogin();
		
		return "success";
	}
	
	
	@Action(value = "loginNecessario", results = {@Result(name = "redirect", type = "redirectAction",
	        location = "frmSetup",params = {"namespace", "/login"})})
	@SkipValidation
	public String login() {
		carregaPerfilTipoLogin();
		return "redirect";
	}
	


	public void carregaPerfilTipoLogin() {
		for (PerfilUsuarioLogin perfil : PerfilUsuarioLogin.values()) {
			perfisUsuarioLogin.add(perfil);
		}
	}
	
	@Action(value = "process", results = { @Result(name = "success", location = "/index.jsp"),
			@Result(name = "error", location = "/frmLogin.jsp") })
	public String doProcess() {
		try {
			
			carregaPerfilTipoLogin();
			
			Boolean usuarioLogou = false;
			
			usuarioLogou = isAdminLogou();
			if (usuarioLogou) {
				return SUCCESS;
			}
		
			addActionError(getText("error.login"));
			return ERROR;

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("error.login"));
			return ERROR;
		}

	}
	
	@Action(value = "login-servidor", results = { @Result(name = "success", location = "/index.servidor.jsp"),
			@Result(name = "error", location = "/frmLogin.jsp") })
	public String doLoginServidor() {
		try {
			
			carregaPerfilTipoLogin();
			
			Boolean usuarioLogou = false;
			if (verificaNoAd) {
				usuarioLogou = isUsuarioTRELogou();
				if (usuarioLogou) {
					return SUCCESS;
				}
			}
		
			addActionError(getText("error.login"));
			return ERROR;

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("error.login"));
			return ERROR;
		}

	}
	
	@Action(value = "login-credenciado", results = { @Result(name = "success", location = "/index.credenciada.jsp"),
			@Result(name = "error", location = "/frmLogin.jsp") })
	public String doLoginCredenciado() {
		try {
			
			carregaPerfilTipoLogin();
			
			Boolean	usuarioLogou = isCredenciadaLogou();
			if (usuarioLogou) {
				loginCredenciada = true;
				return SUCCESS;
			}

			addActionError(getText("error.login"));
			return ERROR;

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(getText("error.login"));
			return ERROR;
		}

	}

	private boolean isUsuarioTRELogou() throws Exception {
		if (LoginAD.getInstance().loginActiveDirectory(this.username, userpass)) {
			Usuario s = UsuarioDAOImpl.getInstance().getBean(this.username);
			if (s.getSenha().equals(userpass)) {
				sessionmap.put("loginTRE", s);
				addActionMessage(getText("login.sucesso"));
				return true;
			}
		}
		return false;
	}

	private boolean isCredenciadaLogou() throws Exception {
		UsuarioCredenciadaVW usuarioCredenciada = UsuarioCredenciadaBusiness.getInstance().findByLoginSenha(username,
				userpass);
		if (usuarioCredenciada != null) {
			sessionmap.put("loginCredenciada", usuarioCredenciada);
			addActionMessage(getText("login.sucesso"));
			return true;
		}
		return false;
	}
	
	private boolean isAdminLogou() throws Exception {
		Usuario s = UsuarioDAOImpl.getInstance().getBean(this.username);
		if (s.getSenha().equals(userpass)) {
			sessionmap.put("loginAdmTRE", s);
			addActionMessage(getText("login.sucesso"));
			return true;
		}
		return false;
	}

	@Action(value = "logout", results = { @Result(name = "success", location = "/frmLogin.jsp"),
			@Result(name = "error", location = "/login.jsp") })
	public String logout() {
		carregaPerfilTipoLogin();
		sessionmap.invalidate();
		return "success";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setSession(Map map) {
		sessionmap = (SessionMap) map;
		sessionmap.put("login", this.usuario);
	}

	public SessionMap<String, Object> getSessionmap() {
		return sessionmap;
	}

	public void setSessionmap(SessionMap<String, Object> sessionmap) {
		this.sessionmap = sessionmap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getVerificaNoAd() {
		return verificaNoAd;
	}

	public void setVerificaNoAd(Boolean verificaNoAd) {
		this.verificaNoAd = verificaNoAd;
	}

	public List<PerfilUsuarioLogin> getPerfisUsuarioLogin() {
		return perfisUsuarioLogin;
	}

	public void setPerfisUsuarioLogin(List<PerfilUsuarioLogin> perfisUsuarioLogin) {
		this.perfisUsuarioLogin = perfisUsuarioLogin;
	}

	public PerfilUsuarioLogin getPerfilUsuarioSelecionado() {
		return perfilUsuarioSelecionado;
	}

	public void setPerfilUsuarioSelecionado(PerfilUsuarioLogin perfilUsuarioSelecionado) {
		this.perfilUsuarioSelecionado = perfilUsuarioSelecionado;
	}

	public static void main(String[] args) throws Exception {

	}
}