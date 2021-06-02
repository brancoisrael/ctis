package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoPK;

public class ProcedimentoDAOImpl implements ProcedimentoDAO {

	private DAO<Procedimento> dao = new DAO<Procedimento>(Procedimento.class);

	static ProcedimentoDAO db;

	public static ProcedimentoDAO getInstance() {
		if (db == null) {
			db = new ProcedimentoDAOImpl();
		}
		return db;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Procedimento> findAll() {
		List<Procedimento> lista = new ArrayList<Procedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select p FROM Procedimento p ");
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
	public Procedimento findById(ProcedimentoPK id) {
		Procedimento procedimento = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			procedimento = em
					.createQuery("Select p FROM Procedimento p "
							+ " where p.procedimentoPK.codigoProcedimento = :codigoProcedimento "
							+ " and p.procedimentoPK.tabela.id = :tabela ", Procedimento.class)
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
	public List<Procedimento> findByParams(ProcedimentoParamsDTO params) {
		List<Procedimento> lista = new ArrayList<Procedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select p FROM Procedimento p WHERE 1=1 ");
			if (params.getId() != null && !params.getId().isEmpty()) {
				sqlString.append(" AND p.procedimentoPK.codigoProcedimento LIKE :id ");
			}
			if (params.getIdTabela() != null) {
				sqlString.append(" AND p.procedimentoPK.tabela.id = :idTabela ");
			}
			if (params.getNome() != null && !params.getNome().isEmpty()) {
				sqlString.append(" AND  LOWER(p.nome) LIKE :nome ");
			}
			Query query = em.createQuery(sqlString.toString(), Procedimento.class);
			if (params.getId() != null && !params.getId().isEmpty()) {
				query.setParameter("id", "%"+params.getId()+"%");
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
