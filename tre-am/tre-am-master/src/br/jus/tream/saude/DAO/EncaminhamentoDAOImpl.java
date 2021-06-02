package br.jus.tream.saude.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.Encaminhamento;

public class EncaminhamentoDAOImpl implements EncaminhamentoDAO {
	
	private DAO<Encaminhamento> dao = new DAO<Encaminhamento>(Encaminhamento.class);

	static EncaminhamentoDAO db;

	public static EncaminhamentoDAO getInstance() {
		if (db == null) {
			db = new EncaminhamentoDAOImpl();
		}
		return db;
	}

	@Override
	public List<Encaminhamento> findAll() {
		List<Encaminhamento> lista = new ArrayList<Encaminhamento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select b FROM Encaminhamento b "
					+ "join fetch b.encaminhamentoPk.acompanhamentoGuia ag "
					+ "join fetch ag.acompanhamentoGuiaPK.credenciado c ");
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
