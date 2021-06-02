package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.AnexoDespesa;

public class AnexoDespesaDAOImpl implements AnexoDespesaDAO {

	private DAO<AnexoDespesa> dao = new DAO<AnexoDespesa>(AnexoDespesa.class);

	static AnexoDespesaDAO db;

	public static AnexoDespesaDAO getInstance() {
		if (db == null) {
			db = new AnexoDespesaDAOImpl();
		}
		return db;
	}

	@Override
	public AnexoDespesa findById(Long id) {
		return dao.getBean(id);
	}

	@Override
	public int inserir(AnexoDespesa anexo) throws Exception {
		int ret = dao.adicionar(anexo);
		if (ret == 5) {
			throw new Exception("Erro ao cadastrar o anexo");
		}
		return ret;
	}

	@Override
	public int alterar(AnexoDespesa anexo) throws Exception {
		int ret = dao.atualizar(anexo);
		if (ret == 5) {
			throw new Exception("Erro ao atualizar o anexo");
		}
		return ret;
	}

	@Override
	public int remover(AnexoDespesa anexo) throws Exception {
		int ret = dao.remover(anexo);
		if (ret == 5) {
			throw new Exception("Erro ao remover o anexo");
		}
		return ret;
	}

	
	
	

}
