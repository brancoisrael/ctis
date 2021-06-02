package br.jus.tream.saude.business;

import java.util.List;

import br.jus.tream.saude.DAO.EspecialidadeDAOImpl;
import br.jus.tream.saude.dominio.Especialidade;

/**
 * Classe responsável pelas tratativas de negócio da entidade {@link Especialidade}.
 * 
 * @author vinicius
 *
 */
public class EspecialidadeBusiness {

	private static EspecialidadeBusiness bo;

	public static EspecialidadeBusiness getInstance() {
		if (bo == null) {
			bo = new EspecialidadeBusiness();
		}
		return bo;
	}

	/**
	 * @see EspecialidadeDAOImpl#findAll()
	 */
	public List<Especialidade> findAll() {
		return EspecialidadeDAOImpl.getInstance().findAll();
	}

	/**
	 * @see EspecialidadeDAOImpl#findById(Long)
	 */
	public Especialidade findById(Long id) {
		return EspecialidadeDAOImpl.getInstance().findById(id);
	}

}
