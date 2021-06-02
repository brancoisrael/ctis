package br.jus.tream.saude.business;

import java.util.List;

import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.dominio.Dominio;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Dominio}.
 * 
 * @author vinicius
 *
 */
public class DominioBusiness {

	private static DominioBusiness bo;

	public static DominioBusiness getInstance() {
		if (bo == null) {
			bo = new DominioBusiness();
		}
		return bo;
	}

	/**
	 * @see DominioDAOImpl#inserir(Dominio)
	 */
	public int inserir(Dominio dominio) throws Exception {
		return DominioDAOImpl.getInstance().inserir(dominio);
	}

	/**
	 * @see DominioDAOImpl#alterar(Dominio)
	 */
	public int alterar(Dominio dominio) throws Exception {
		return DominioDAOImpl.getInstance().alterar(dominio);
	}

	/**
	 * @see DominioDAOImpl#remover(Dominio)
	 */
	public int remover(Dominio dominio) throws Exception {
		return DominioDAOImpl.getInstance().remover(dominio);
	}

	/**
	 * @see DominioDAOImpl#findAll()
	 */
	public List<Dominio> findAll() {
		return DominioDAOImpl.getInstance().findAll();
	}

	/**
	 * @see DominioDAOImpl#findAll(Pagination)
	 */
	public List<Dominio> findPaginado(Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistros());
		return DominioDAOImpl.getInstance().findAll(pagination);
	}

	/**
	 * @see DominioDAOImpl#findByParams(DominioParamsDTO, Pagination)
	 */
	public List<Dominio> findByParams(DominioParamsDTO params, Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistrosByParams(params).intValue());
		return DominioDAOImpl.getInstance().findByParams(params, pagination);
	}

	/**
	 * @see DominioDAOImpl#count()
	 */
	public int getTotalRegistros() throws Exception {
		return DominioDAOImpl.getInstance().count();
	}

	/**
	 * @see DominioDAOImpl#countByParams(DominioParamsDTO)
	 */
	public Long getTotalRegistrosByParams(DominioParamsDTO params) throws Exception {
		return DominioDAOImpl.getInstance().countByParams(params);
	}

	/**
	 * @see DominioDAOImpl#findTiposDominio()
	 */
	public List<String> findTiposDominio() {
		return DominioDAOImpl.getInstance().findTiposDominio();
	}
	
	public boolean isDominioCadastrado(DominioParamsDTO params) throws Exception {
		return getTotalRegistrosByParams(params) > 0;
	}
	
	/**
	 * @see DominioDAOImpl#findById(Long)
	 */
	public Dominio getBean(Long idDominio) {
		return DominioDAOImpl.getInstance().findById(idDominio);
	}

}
