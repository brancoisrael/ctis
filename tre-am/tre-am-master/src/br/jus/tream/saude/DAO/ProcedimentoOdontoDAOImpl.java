package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.ProcedimentoOdonto;
import br.jus.tream.saude.dominio.ProcedimentoPK;

public class ProcedimentoOdontoDAOImpl implements ProcedimentoOdontoDAO {

	private DAO<ProcedimentoOdonto> dao = new DAO<ProcedimentoOdonto>(ProcedimentoOdonto.class);

	static ProcedimentoOdontoDAO db;

	public static ProcedimentoOdontoDAO getInstance() {
		if (db == null) {
			db = new ProcedimentoOdontoDAOImpl();
		}
		return db;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProcedimentoOdonto> findAll() {
		List<ProcedimentoOdonto> lista = new ArrayList<ProcedimentoOdonto>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select p FROM ProcedimentoOdonto p ");
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
	public ProcedimentoOdonto findById(ProcedimentoPK id) {
		ProcedimentoOdonto procedimento = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			procedimento = em
					.createQuery("Select p FROM ProcedimentoOdonto p "
							+ " where p.procedimentoPK.codigoProcedimento = :codigoProcedimento "
							+ " and p.procedimentoPK.tabela.id = :tabela ", ProcedimentoOdonto.class)
					.setParameter("codigoProcedimento", id.getCodigoProcedimento())
					.setParameter("tabela", id.getTabela().getId()).getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return procedimento;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProcedimentoOdonto> findByParams(ProcedimentoParamsDTO params) {
		List<ProcedimentoOdonto> lista = new ArrayList<ProcedimentoOdonto>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder(
					"Select p FROM ProcedimentoOdonto p " + " join fetch p.grupo g " + " WHERE 1=1 ");
			if (params.getId() != null && !params.getId().isEmpty()) {
				sqlString.append(" AND p.procedimentoPK.codigoProcedimento LIKE :id ");
			}

			if (params.getIdTabela() != null) {
				sqlString.append(" AND p.procedimentoPK.tabela.id = :idTabela ");
			}

			if (params.getNome() != null && !params.getNome().isEmpty()) {
				sqlString.append(" AND  LOWER(p.nome) LIKE :nome ");
			}
			Query query = em.createQuery(sqlString.toString(), ProcedimentoOdonto.class);
			if (params.getId() != null && !params.getId().isEmpty()) {
				query.setParameter("id", "%" + params.getId() + "%");
			}

			if (params.getIdTabela() != null) {
				query.setParameter("idTabela", params.getIdTabela());
			}

			if (params.getNome() != null && !params.getNome().isEmpty()) {
				query.setParameter("nome",  "%" + params.getNome().toLowerCase() + "%");
			}

			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

}
