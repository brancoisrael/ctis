package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.jus.tream.saude.dominio.Situacao;

public class SituacaoDAOImpl implements SituacaoDAO {

	private DAO<Situacao> dao = new DAO<Situacao>(Situacao.class);

	static SituacaoDAO db;

	public static SituacaoDAO getInstance() {
		if (db == null) {
			db = new SituacaoDAOImpl();
		}
		return db;
	}

	@Override
	public List<Situacao> findAll() {
		List<Situacao> lista = new ArrayList<Situacao>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			lista = em.createQuery("Select s FROM Situacao s ", Situacao.class).getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Situacao findById(Short id) {
		return dao.getBean(new Long(id));
	}

}
