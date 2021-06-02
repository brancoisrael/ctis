package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.Despesa;

public class DespesaDAOImpl implements DespesaDAO {

	private DAO<Despesa> dao = new DAO<Despesa>(Despesa.class);

	static DespesaDAO db;

	public static DespesaDAO getInstance() {
		if (db == null) {
			db = new DespesaDAOImpl();
		}
		return db;
	}

	@Override
	public Despesa findById(Long id) {
		return dao.getBean(id);
	}

	@Override
	public int inserir(Despesa despesa) throws Exception {
		int ret = dao.adicionar(despesa);
		if (ret == 5) {
			throw new Exception("Erro ao cadastrar o anexo");
		}
		return ret;
	}

	@Override
	public int alterar(Despesa despesa) throws Exception {
		int ret = dao.atualizar(despesa);
		if (ret == 5) {
			throw new Exception("Erro ao atualizar a despesa");
		}
		return ret;
	}

	@Override
	public int remover(Despesa despesa) throws Exception {
		int ret = dao.remover(despesa);
		if (ret == 5) {
			throw new Exception("Erro ao remover a despesa");
		}
		return ret;
	}

	
	
	

}
