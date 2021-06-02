package br.jus.tream.saude.DAO;

import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.apache.commons.lang3.StringUtils;

import br.jus.tream.saude.dominio.BeanLogin;
import br.jus.tream.saude.dominio.SRHServidor;

public class LoginAD {

	private static LoginAD loginAD;

	public static LoginAD getInstance() throws Exception {
		if (loginAD == null) {
			loginAD = new LoginAD();
		}
		return loginAD;
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public boolean loginActiveDirectory(String usuario, String senha) throws Exception {
		LdapContext ctx = null;
		String loginAD = String.format("%s@tre-am.gov.br", usuario);
		String enderecoAD = "10.22.1.180";
		String portaAD = "389"; // Geralmente  a 389
		try {
			if (!senha.equals("")) {
				Hashtable environment = new Hashtable();
				environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
				environment.put(Context.PROVIDER_URL, String.format("ldap://%s:%s", enderecoAD, portaAD));
				environment.put(Context.SECURITY_AUTHENTICATION, "simple");
				environment.put(Context.SECURITY_PRINCIPAL, loginAD);
				environment.put(Context.SECURITY_CREDENTIALS, senha);
				ctx = new InitialLdapContext(environment, null);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAmbienteProducao() {
		boolean ret = false; 
		try {
			//TODO verificar essa lógica com Moacir
//			ret = EntityManagerProvider.getInstance().isAmbienteProducao();
		} catch (Exception e) {
			ret = false; // ocorreu um erro			
		} 
	  return ret;
	}
	
	public BeanLogin getSGRH(String tituloEleitor) throws Exception {
		SRHServidorDAO dao = SRHServidorDAOImpl.getInstance();
		BeanLogin login = new BeanLogin();
		try {
			SRHServidor servidor  = new SRHServidor();
			servidor = dao.getBeanByTitulo(tituloEleitor);
			if (servidor.getNome().length()>0) {
				login.setNome(servidor.getNome());
				login.setTitulo(servidor.getTituloEleitor());
//				if (StringUtils.isNumeric(servidor.getZona())) {
//					login.setZona(Integer.parseInt(servidor.getZona()));
//				}else
//					login.setZona(0);
			   login.setIsAmbienteProducao(this.isAmbienteProducao());
			}
		} finally {
		 //
		}
		return login;
	}

	public BeanLogin getLogin(String titulo, String senha) throws SQLException, Exception {
		BeanLogin l = new BeanLogin();
		try {
			l = getSGRH(titulo);
			l.setLogou(loginActiveDirectory(l.getTitulo(), senha));
			return l;
		} catch (Exception e) {
			return l;
		}
	}

	public static void main(String[] args) throws SQLException, Exception {
		BeanLogin s = new BeanLogin();
		LoginAD l = LoginAD.getInstance();
		s = l.getLogin("15697172275", "123123");
		System.out.println("login " + s.getLogou());
		if (s.getLogou())
			System.out.println("logou " + s.getNome() + " / " +  " admin " + s.getAdmin());
		else
			System.out.println("Nao Logou");
		
		
		
		
	}
}
