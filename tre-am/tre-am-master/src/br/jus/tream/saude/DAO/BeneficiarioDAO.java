package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Beneficiario;

public interface BeneficiarioDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param matricula do registro
	 * @return Instância de encontrada ou null
	 */
	Beneficiario findTitular(String matricula);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Beneficiario> findAll();

	/**
	 * Responsável por alterar os dados do {@link Beneficiario}
	 * 
	 * @param beneficiario que será alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(Beneficiario beneficiario) throws Exception;

	/**
	 * Busca todos os registros com paginação
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Beneficiario> findAll(Pagination pagination);

	/**
	 * Total de registros
	 * 
	 * @return
	 * @throws Exception
	 */
	int count() throws Exception;
	
	/**
	 * Busca um registro pelo seu identificador
	 * @param matricula do registro
	 * @param codigoDependente
	 * @return Instância de encontrada ou null
	 */
	Beneficiario findDependente(String matricula, Integer codigoDependente) throws Exception;
	
	/**
	 * Busca os benefíciarios pela matricula
	 * @param matricula do registro
	 * @return lista de beneficiários
	 */
	List<Beneficiario> findBenenficiariosByMatricula(String matricula) throws Exception;

}
