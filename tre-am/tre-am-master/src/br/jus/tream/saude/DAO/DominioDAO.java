package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.DominioParamsDTO;
import br.jus.tream.saude.dominio.Dominio;

public interface DominioDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Dominio findById(Long id);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Dominio> findAll();

	/**
	 * Respons�vel por criar um {@link Dominio}
	 * 
	 * @param dominio que ser� criado
	 * @return
	 * @throws Exception
	 */
	int inserir(Dominio dominio) throws Exception;

	/**
	 * Respons�vel por alterar os dados do {@link Dominio}
	 * 
	 * @param dominio que ser� alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(Dominio dominio) throws Exception;

	/**
	 * 
	 * @param dominio
	 * @return
	 * @throws Exception
	 */
	int remover(Dominio dominio) throws Exception;

	/**
	 * Busca todos os registros com pagina��o
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Dominio> findAll(Pagination pagination);

	/**
	 * Total de registros
	 * 
	 * @return
	 * @throws Exception
	 */
	int count() throws Exception;

	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Dominio> findByParams(DominioParamsDTO params, Pagination pagination);

	/**
	 * Recupera o total de registros de acordo com os filtros informados
	 * 
	 * @param params filtros utilizados
	 * @return total de registros encontrados
	 * @throws Exception.
	 */
	Long countByParams(DominioParamsDTO params) throws Exception;
	
	/**
	 * Recupera todos os tipos de dom�nios cadastrados
	 * @return lista de tipos
	 */
	List<String> findTiposDominio();

	Dominio findByDomino(String dominio);

}
