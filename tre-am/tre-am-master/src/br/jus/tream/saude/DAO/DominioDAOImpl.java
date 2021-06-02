package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.enumeration.SituacaoDominio;

public class DominioDAOImpl implements DominioDAO {

	private DAO<Dominio> dao = new DAO<Dominio>(Dominio.class);

	static DominioDAO db;

	public static DominioDAO getInstance() {
		if (db == null) {
			db = new DominioDAOImpl();
		}
		return db;
	}

	@Override
	public Dominio findById(Long id) {
		return dao.getBean(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dominio> findAll() {
		List<Dominio> lista = new ArrayList<Dominio>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select d FROM Dominio d");
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public int inserir(Dominio dominio) throws Exception {
		int ret = 0;
		try {
			dao.adicionar(dominio);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int alterar(Dominio dominio) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(dominio);
			ret = 1;
		} catch (Exception e) {
			// System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(Dominio dominio) throws Exception {
		int ret = 0;
		try {
			dao.remover(dominio);
			ret = 1;
		} catch (Exception e) {
			// System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * @param page
	 * @return
	 */
//	private int calculateOffset(int page, int limit) {
//	    return ((limit * page) - limit);
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dominio> findAll(Pagination pagination) {
		List<Dominio> lista = new ArrayList<Dominio>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select d FROM Dominio d order by d.id ASC").setFirstResult(pagination.getStart())
					.setMaxResults(pagination.getEnd());
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public int count() throws Exception {
		return dao.contaTodos();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dominio> findByParams(DominioParamsDTO params, Pagination pagination) {
		List<Dominio> lista = new ArrayList<Dominio>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select d FROM Dominio d WHERE 1=1 ");
			buildQuery(sqlString, params);
			Query query = em.createQuery(sqlString.toString(), Dominio.class).setFirstResult(pagination.getStart())
					.setMaxResults(pagination.getEnd());
			setParameters(params, query);
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Long countByParams(DominioParamsDTO params) throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select count(d) FROM Dominio d WHERE 1=1 ");
			buildQuery(sqlString, params);
			Query query = em.createQuery(sqlString.toString(), Long.class);
			setParameters(params, query);
			total = (Long) query.getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return total;
	}

	private void setParameters(DominioParamsDTO params, Query query) {
		if (params == null) {
			return;
		}

		if (params.getId() != null) {
			query.setParameter("id", params.getId());
		}

		if (params.getDescricao() != null && !params.getDescricao().isEmpty()) {
			query.setParameter("descricao", "%" + params.getDescricao() + "%");
		}

		if (params.getValor() != null && !params.getValor().isEmpty()) {
			query.setParameter("valor", "%" + params.getValor() + "%");
		}

		if (params.getSituacao() != null && !params.getSituacao().isEmpty()) {
			SituacaoDominio situacao = SituacaoDominio.getSituacaoByDescricao(params.getSituacao());
			query.setParameter("situacao", situacao);
		}

		if (params.getDominio() != null && !params.getDominio().isEmpty()) {
			query.setParameter("dominio", "%" + params.getDominio() + "%");
		}
	}

	private StringBuilder buildQuery(StringBuilder sqlString, DominioParamsDTO params) {
		if (params == null) {
			return sqlString;
		}
		if (params.getId() != null) {
			sqlString.append(" and d.id like :id ");
		}

		if (params.getDescricao() != null && !params.getDescricao().isEmpty()) {
			sqlString.append(" and d.descricao like :descricao ");
		}

		if (params.getValor() != null && !params.getValor().isEmpty()) {
			sqlString.append(" and d.valor like :valor ");
		}

		if (params.getSituacao() != null && !params.getSituacao().isEmpty()) {
			sqlString.append(" and d.situacao = :situacao ");
		}

		if (params.getDominio() != null && !params.getDominio().isEmpty()) {
			sqlString.append(" and d.dominio like :dominio ");
		}
		return sqlString;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findTiposDominio() {
		List<String> lista = new ArrayList<String>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select d.dominio FROM Dominio d group by d.dominio", String.class);
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Dominio findByDomino(String dominio) {
		Dominio dom = null;
		List<Dominio> lista = new ArrayList<Dominio>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select d FROM Dominio d WHERE d.dominio = '" + dominio + "'");
			
			lista = em.createQuery(sqlString.toString(), Dominio.class).getResultList();
			if (lista.size() > 0) {
				dom = lista.get(0);
			}
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return dom;
	}

}
