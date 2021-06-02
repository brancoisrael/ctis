package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Fatura;

public class FaturaDAOImpl implements FaturaDAO {
	
	private DAO<Fatura> dao = new DAO<Fatura>(Fatura.class);

	static FaturaDAO db;

	public static FaturaDAO getInstance() {
		if (db == null) {
			db = new FaturaDAOImpl();
		}
		return db;
	}

	@Override
	public List<Fatura> findAll() {
		List<Fatura> lista = new ArrayList<Fatura>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select f FROM Fatura f "
					+ "join fetch f.faturaPK.credenciado b left join fetch b.tabelaIdade ti "
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

}
