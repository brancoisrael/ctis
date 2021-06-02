package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Especialidade;

public interface EspecialidadeDAO {

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Especialidade> findAll();


	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	Especialidade findById(Long id);

	

}
