package br.jus.tream.saude.business;

import br.jus.tream.saude.DAO.TipoGuiaDAOImpl;
import br.jus.tream.saude.dominio.TipoGuia;

/**
 * Classe respons�vel pelas tratativas de neg�cio da entidade {@link TipoGuia}.
 * 
 * @author vinicius
 *
 */
public class TipoGuiaBusiness {

	private static TipoGuiaBusiness bo;

	public static TipoGuiaBusiness getInstance() {
		if (bo == null) {
			bo = new TipoGuiaBusiness();
		}
		return bo;
	}

	/**
	 * @see TipoGuiaDAOImpl#findById(Short)
	 */
	public TipoGuia findById(Long id) {
		return TipoGuiaDAOImpl.getInstance().findById(id);
	}

}
