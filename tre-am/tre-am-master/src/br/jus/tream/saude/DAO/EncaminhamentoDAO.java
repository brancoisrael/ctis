package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Encaminhamento;

public interface EncaminhamentoDAO {

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Encaminhamento> findAll();




	

}
