package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.TipoGuia;

public class TipoGuiaDAOImpl implements TipoGuiaDAO {

	private DAO<TipoGuia> dao = new DAO<TipoGuia>(TipoGuia.class);

	static TipoGuiaDAO db;

	public static TipoGuiaDAO getInstance() {
		if (db == null) {
			db = new TipoGuiaDAOImpl();
		}
		return db;
	}

	@Override
	public TipoGuia findById(Long id) {
		return dao.getBean(new Long(id));
	}

}
