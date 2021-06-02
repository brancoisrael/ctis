package br.jus.tream.saude.business;

import br.jus.tream.saude.DAO.UsuarioCredenciadaDAO;
import br.jus.tream.saude.DAO.UsuarioCredenciadaDAOImpl;
import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;
import br.jus.tream.saude.util.FuncsUtils;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link UsuarioCredenciadaVW}.
 * 
 * @author vinicius
 *
 */
public class UsuarioCredenciadaBusiness {

	private static UsuarioCredenciadaBusiness bo;

	public static UsuarioCredenciadaBusiness getInstance() {
		if (bo == null) {
			bo = new UsuarioCredenciadaBusiness();
		}
		return bo;
	}
	
	/**
	 * @throws Exception 
	 * @see {@link UsuarioCredenciadaDAO#findByLoginSenha(String, String)}
	 */
	public UsuarioCredenciadaVW findByLoginSenha(String login, String senha) throws Exception {
		String senhaEncriptada = FuncsUtils.getInstance().encriptar(senha);
		return UsuarioCredenciadaDAOImpl.getInstance().findByLoginSenha(login, senhaEncriptada);
	}


	/**
	 * @throws Exception 
	 * @see {@link UsuarioCredenciadaDAO#getBean(Long)}
	 */
	public UsuarioCredenciadaVW findById(Long id) throws Exception {		
		return UsuarioCredenciadaDAOImpl.getInstance().getBean(id);
	}
}
