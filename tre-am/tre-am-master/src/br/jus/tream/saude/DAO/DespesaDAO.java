package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.Despesa;

public interface DespesaDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	Despesa findById(Long id);

	/**
	 * Responsável por criar um {@link Despesa}
	 * 
	 * @param despesa que será criada
	 * @return
	 * @throws Exception
	 */
	int inserir(Despesa despesa) throws Exception;

	/**
	 * Responsável por alterar os dados do {@link Despesa}
	 * 
	 * @param despesa que será alterada
	 * @return
	 * @throws Exception
	 */
	int alterar(Despesa despesa) throws Exception;

	/**
	 * Responsável por remover a despesa
	 * 
	 * @param despesa
	 * @return
	 * @throws Exception
	 */
	int remover(Despesa despesa) throws Exception;

	


}
