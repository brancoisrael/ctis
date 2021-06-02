package br.jus.tream.saude.business;

import java.util.List;

import br.jus.tream.saude.DAO.CredenciadoDAOImpl;
import br.jus.tream.saude.dominio.Credenciado;

/**
 * Classe respons�vel pelas tratativas de neg�cio da entidade
 * {@link Credenciado}.
 * 
 * @author vinicius
 *
 */
public class CredenciadoBusiness {

	private static CredenciadoBusiness bo;

	public static CredenciadoBusiness getInstance() {
		if (bo == null) {
			bo = new CredenciadoBusiness();
		}
		return bo;
	}

	/**
	 * @see CredenciadoDAOImpl#findAll()
	 */
	public List<Credenciado> findAll() {
		return CredenciadoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see CredenciadoDAOImpl#findById(Long)
	 */
	public Credenciado findById(Long id) {
		return CredenciadoDAOImpl.getInstance().findById(id);
	}

}
