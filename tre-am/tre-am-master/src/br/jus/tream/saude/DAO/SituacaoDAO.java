package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Situacao;

public interface SituacaoDAO {

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Situacao> findAll();


	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Situacao findById(Short id);


	

}
