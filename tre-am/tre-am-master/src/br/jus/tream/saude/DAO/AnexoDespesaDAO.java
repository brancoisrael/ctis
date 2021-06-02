package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.AnexoDespesa;

public interface AnexoDespesaDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	AnexoDespesa findById(Long id);

	/**
	 * Respons�vel por criar um {@link AnexoDespesa}
	 * 
	 * @param anexo que ser� criado
	 * @return
	 * @throws Exception
	 */
	int inserir(AnexoDespesa anexo) throws Exception;

	/**
	 * Respons�vel por alterar os dados do {@link AnexoDespesa}
	 * 
	 * @param anexo que ser� alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(AnexoDespesa anexo) throws Exception;

	/**
	 * Respons�vel por remover o anexo
	 * 
	 * @param anexo
	 * @return
	 * @throws Exception
	 */
	int remover(AnexoDespesa anexo) throws Exception;

	


}
