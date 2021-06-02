package br.jus.tream.saude.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;

public class UsuarioCredenciadaDAOImpl implements UsuarioCredenciadaDAO {

	private DAO<UsuarioCredenciadaVW> dao = new DAO<UsuarioCredenciadaVW>(UsuarioCredenciadaVW.class);

	static UsuarioCredenciadaDAO db;

	public static UsuarioCredenciadaDAO getInstance() {
		if (db == null) {
			db = new UsuarioCredenciadaDAOImpl();
		}
		return db;
	}

	@Override
	public UsuarioCredenciadaVW getBean(Long id) throws Exception {
		UsuarioCredenciadaVW usuario = new UsuarioCredenciadaVW();
		usuario = dao.getBean(id);
		return usuario;
	}

	@Override
	public UsuarioCredenciadaVW findByLoginSenha(String login, String senha) throws Exception {
		UsuarioCredenciadaVW usuario = new UsuarioCredenciadaVW();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			TypedQuery<UsuarioCredenciadaVW> query = em.createQuery(
					"SELECT c FROM UsuarioCredenciadaVW c WHERE c.usuario = :usuario and c.senha = :senha", UsuarioCredenciadaVW.class);
			usuario = query.setParameter("usuario", login)
					.setParameter("senha", senha).getSingleResult();
		} finally {
			em.close();
		}
		return usuario;
	}

	@Override
	public List<UsuarioCredenciadaVW> listar() throws Exception {
		List<UsuarioCredenciadaVW> lista = null;
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
