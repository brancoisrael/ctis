package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.Credenciado;

public class CredenciadoDAOImpl implements CredenciadoDAO {
	
	private DAO<Credenciado> dao = new DAO<Credenciado>(Credenciado.class);

	static CredenciadoDAO db;

	public static CredenciadoDAO getInstance() {
		if (db == null) {
			db = new CredenciadoDAOImpl();
		}
		return db;
	}

	@Override
	public List<Credenciado> findAll() {
		List<Credenciado> lista = new ArrayList<Credenciado>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select b FROM Credenciado b left join fetch b.tabelaIdade ti "
					+ "join fetch b.tabela t "
					+ "join fetch b.instituicao i");
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
	public Credenciado findById(Long id) {
		return dao.getBean(id);
	}

}
