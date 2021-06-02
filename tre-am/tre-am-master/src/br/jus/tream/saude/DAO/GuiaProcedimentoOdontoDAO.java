package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoReportDTO;
import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.GuiaProcedimentoOdonto;

public interface GuiaProcedimentoOdontoDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	GuiaProcedimentoOdonto findById(Long id);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoOdonto> findAll();

	/**
	 * Respons�vel por criar um {@link GuiaProcedimento}
	 * 
	 * @param guiaProcedimento que ser� criado
	 * @return
	 * @throws Exception
	 */
	int inserir(GuiaProcedimentoOdonto guiaProcedimento) throws Exception;

	/**
	 * Respons�vel por alterar os dados do {@link GuiaProcedimento}
	 * 
	 * @param guiaProcedimento que ser� alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(GuiaProcedimentoOdonto guiaProcedimento) throws Exception;

	/**
	 * 
	 * @param guiaProcedimento
	 * @return
	 * @throws Exception
	 */
	int remover(GuiaProcedimentoOdonto guiaProcedimento) throws Exception;

	/**
	 * Busca todos os registros com pagina��o
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoOdonto> findAll(Pagination pagination);

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
	List<GuiaProcedimentoOdonto> findByParams(GuiaProcedimentoParamsDTO params, Pagination pagination) throws Exception;

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
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoOdonto> findByGuia(GuiaPK guiapk) throws Exception;
	
	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoDashBoardDTO> findByParamsNative(GuiaProcedimentoParamsDTO params, Pagination pagination)
			throws Exception;
	
	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<GuiaProcedimentoReportDTO> findDadosRelatorioGuia(ReportParams params)
			throws Exception;

	/**
	 * Respons�vel por remover pelo id da {@link Guia}
	 * 
	 * @param params guiaPk identificador da {@link Guia}
	 */
	int removerByGuia(GuiaPK guiaPk) throws Exception;

}
