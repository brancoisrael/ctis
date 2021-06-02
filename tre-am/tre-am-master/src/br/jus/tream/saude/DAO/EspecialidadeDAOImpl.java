package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.jus.tream.saude.dominio.Especialidade;

public class EspecialidadeDAOImpl implements EspecialidadeDAO {

	private DAO<Especialidade> dao = new DAO<Especialidade>(Especialidade.class);

	static EspecialidadeDAO db;

	public static EspecialidadeDAO getInstance() {
		if (db == null) {
			db = new EspecialidadeDAOImpl();
		}
		return db;
	}

	@Override
	public List<Especialidade> findAll() {
		List<Especialidade> lista = new ArrayList<Especialidade>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			lista = em.createQuery("Select e FROM Especialidade e ", Especialidade.class).getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Especialidade findById(Long id) {
		return dao.getBean(id);
	}
}
