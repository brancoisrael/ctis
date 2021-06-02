package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoReportDTO;
import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;

public interface GuiaProcedimentoDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	GuiaProcedimento findById(Long id);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimento> findAll();

	/**
	 * Responsável por criar um {@link GuiaProcedimento}
	 * 
	 * @param guiaProcedimento que será criado
	 * @return
	 * @throws Exception
	 */
	int inserir(GuiaProcedimento guiaProcedimento) throws Exception;

	/**
	 * Responsável por alterar os dados do {@link GuiaProcedimento}
	 * 
	 * @param guiaProcedimento que será alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(GuiaProcedimento guiaProcedimento) throws Exception;

	/**
	 * 
	 * @param guiaProcedimento
	 * @return
	 * @throws Exception
	 */
	int remover(GuiaProcedimento guiaProcedimento) throws Exception;

	/**
	 * Busca todos os registros com paginação
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimento> findAll(Pagination pagination);

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
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimento> findByParams(GuiaProcedimentoParamsDTO params, Pagination pagination) throws Exception;

	/**
	 * Recupera o total de registros de acordo com os filtros informados
	 * 
	 * @param params filtros utilizados
	 * @return total de registros encontrados
	 * @throws Exception.
	 */
	Long countByParams(GuiaProcedimentoParamsDTO params) throws Exception;
	
	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimento> findByGuia(GuiaPK guiapk) throws Exception;
	
	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoDashBoardDTO> findByParamsNative(GuiaProcedimentoParamsDTO params, Pagination pagination)
			throws Exception;
	
	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoReportDTO> findDadosRelatorioGuia(ReportParams params)
			throws Exception;

	/**
	 * Responsável por remover pelo id da {@link Guia}
	 * 
	 * @param params guiaPk identificador da {@link Guia}
	 */
	int removerByGuia(GuiaPK guiaPk) throws Exception;

	List<GuiaProcedimentoReportDTO> findDadosRelatorioGuiaOdonto(ReportParams params) throws Exception;

}
