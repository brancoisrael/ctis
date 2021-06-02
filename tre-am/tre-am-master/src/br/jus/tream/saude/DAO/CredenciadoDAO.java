package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Credenciado;

public interface CredenciadoDAO {

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Credenciado> findAll();

	Credenciado findById(Long id);


	

}
