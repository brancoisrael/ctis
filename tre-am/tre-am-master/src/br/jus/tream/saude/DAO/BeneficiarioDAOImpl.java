package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.Beneficiario;

public class BeneficiarioDAOImpl implements BeneficiarioDAO {

	private DAO<Beneficiario> dao = new DAO<Beneficiario>(Beneficiario.class);

	static BeneficiarioDAO db;

	public static BeneficiarioDAO getInstance() {
		if (db == null) {
			db = new BeneficiarioDAOImpl();
		}
		return db;
	}

	@Override
	public Beneficiario findTitular(String matricula) {
		Beneficiario beneficiario = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			beneficiario = em
					.createQuery("Select b FROM Beneficiario b WHERE b.matricula = :matricula and b.codigoDependente is null", Beneficiario.class)
					.setParameter("matricula", matricula).getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return beneficiario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficiario> findAll() {
		List<Beneficiario> lista = new ArrayList<Beneficiario>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select b FROM Beneficiario b");
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
	public int alterar(Beneficiario beneficiario) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(beneficiario);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficiario> findAll(Pagination pagination) {
		List<Beneficiario> lista = new ArrayList<Beneficiario>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select b FROM Beneficiario b").setFirstResult(pagination.getStart())
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
		int total = 0;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select count(b.id) FROM Beneficiario b");
			Query query = em.createQuery(sqlString.toString(), Long.class);
			total = (int) query.getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return total;
	}

	@Override
	public Beneficiario findDependente(String matricula, Integer codigoDependente) throws Exception {
		Beneficiario beneficiario = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			beneficiario = em
					.createQuery("Select b FROM Beneficiario b WHERE b.matricula = :matricula "
							+ " and b.codigoDependente = :codigoDependente", Beneficiario.class)
					.setParameter("matricula", matricula)
					.setParameter("codigoDependente", codigoDependente)
					.getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return beneficiario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficiario> findBenenficiariosByMatricula(String matricula) throws Exception {
		List<Beneficiario> lista = new ArrayList<Beneficiario>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select b FROM Beneficiario b WHERE b.matricula = :matricula order by b.codigoDependente DESC, b.nome ASC")
					.setParameter("matricula", matricula);
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
