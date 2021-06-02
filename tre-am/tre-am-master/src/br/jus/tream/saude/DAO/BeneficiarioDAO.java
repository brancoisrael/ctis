package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.Beneficiario;

public interface BeneficiarioDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param matricula do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Beneficiario findTitular(String matricula);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Beneficiario> findAll();

	/**
	 * Respons�vel por alterar os dados do {@link Beneficiario}
	 * 
	 * @param beneficiario que ser� alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(Beneficiario beneficiario) throws Exception;

	/**
	 * Busca todos os registros com pagina��o
	 * 
	 * @param pagination dados da pagina��o
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
	 * @return Inst�ncia de encontrada ou null
	 */
	Beneficiario findDependente(String matricula, Integer codigoDependente) throws Exception;
	
	/**
	 * Busca os benef�ciarios pela matricula
	 * @param matricula do registro
	 * @return lista de benefici�rios
	 */
	List<Beneficiario> findBenenficiariosByMatricula(String matricula) throws Exception;

}
