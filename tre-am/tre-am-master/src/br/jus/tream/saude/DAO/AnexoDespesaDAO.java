package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.AnexoDespesa;

public interface AnexoDespesaDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	AnexoDespesa findById(Long id);

	/**
	 * Responsável por criar um {@link AnexoDespesa}
	 * 
	 * @param anexo que será criado
	 * @return
	 * @throws Exception
	 */
	int inserir(AnexoDespesa anexo) throws Exception;

	/**
	 * Responsável por alterar os dados do {@link AnexoDespesa}
	 * 
	 * @param anexo que será alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(AnexoDespesa anexo) throws Exception;

	/**
	 * Responsável por remover o anexo
	 * 
	 * @param anexo
	 * @return
	 * @throws Exception
	 */
	int remover(AnexoDespesa anexo) throws Exception;

	


}
