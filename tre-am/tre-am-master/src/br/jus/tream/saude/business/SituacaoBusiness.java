package br.jus.tream.saude.business;

import java.util.List;

import br.jus.tream.saude.DAO.SituacaoDAOImpl;
import br.jus.tream.saude.dominio.Situacao;

/**
 * Classe responsável pelas tratativas de negócio da entidade {@link Situacao}.
 * 
 * @author vinicius
 *
 */
public class SituacaoBusiness {

	private static SituacaoBusiness bo;

	public static SituacaoBusiness getInstance() {
		if (bo == null) {
			bo = new SituacaoBusiness();
		}
		return bo;
	}

	/**
	 * @see SituacaoDAOImpl#findAll()
	 */
	public List<Situacao> findAll() {
		return SituacaoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see SituacaoDAOImpl#findById(Short)
	 */
	public Situacao findById(Short id) {
		return SituacaoDAOImpl.getInstance().findById(id);
	}

	public Situacao retornaSituacao(boolean requerAutorizacao) {
		Situacao situacao = new Situacao();
		if (requerAutorizacao) {
			situacao.setId((short)3);
		} else {
			situacao.setId((short)7);
		}
		return situacao;
	}

}
