package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.Despesa;

public interface DespesaDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Despesa findById(Long id);

	/**
	 * Respons�vel por criar um {@link Despesa}
	 * 
	 * @param despesa que ser� criada
	 * @return
	 * @throws Exception
	 */
	int inserir(Despesa despesa) throws Exception;

	/**
	 * Respons�vel por alterar os dados do {@link Despesa}
	 * 
	 * @param despesa que ser� alterada
	 * @return
	 * @throws Exception
	 */
	int alterar(Despesa despesa) throws Exception;

	/**
	 * Respons�vel por remover a despesa
	 * 
	 * @param despesa
	 * @return
	 * @throws Exception
	 */
	int remover(Despesa despesa) throws Exception;

	


}
