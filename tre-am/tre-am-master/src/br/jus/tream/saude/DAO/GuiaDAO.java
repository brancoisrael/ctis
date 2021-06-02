package br.jus.tream.saude.DAO;

import java.time.YearMonth;
import java.util.List;

import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.enumeration.ClassificacaoTipoGuia;
import br.jus.tream.saude.enumeration.SituacaoGuia;

public interface GuiaDAO {

	/**
	 * Busca todos os registros
	 * 
	 * @return lista de registros encontrados
	 */
	List<Guia> findAll();
	
	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<Guia> findAll(Pagination pagination);

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	Guia findById(GuiaPK id);

	/**
	 * Responsável por criar um {@link Guia}
	 * 
	 * @param guia que será criado
	 * @return
	 * @throws Exception
	 */
	int inserir(Guia guia) throws Exception;

	/**
	 * Responsável por alterar os dados do {@link Guia}
	 * 
	 * @param guia que será alterado
	 * @return
	 * @throws Exception
	 */
	int alterar(Guia guia) throws Exception;

	/**
	 * 
	 * @param guia
	 * @return
	 * @throws Exception
	 */
	int remover(Guia guia) throws Exception;
	
	/**
	 * Busca todos os registros de um {@link Credenciado}
	 * 
	 * @param idCredenciada identificador da credenciada
	 * @param pagination
	 * @return lista de registros encontrados
	 */
	List<Guia> findGuiasDaCredenciada(Long idCredenciada, Pagination pagination) throws Exception;
	
	/**
	 * Retorna o total de registros de um {@link Credenciado}
	 * 
	 * @param idCredenciada identificador da credenciada
	 * @param pagination
	 * @return total de registros encontrados
	 */
	Long countGuiasDaCredenciada(Long idCredenciada) throws Exception;
	
	/**
	 * Retorna o total de registros
	 * 
	 * @return total de registros encontrados
	 */
	Long countGuias() throws Exception;
	
	/**
	 * Retorna o total de registros no mês informado
	 * 
	 * @return total de registros encontrados
	 */
	Long totalGuiasAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception;
	

	/**
	 * Gera o próximo número da sequence
	 * 
	 * @return próximo número da sequence
	 */
	Long getSequence();
	
	/**
	 * Retorna o total de registros de acordo com os parâmetros informados
	 * 
	 * @param anoMes desejado
	 * @param idCredenciada identificador da credenciada
	 * @param ids identificadores das situações desejadas
	 * 
	 * @return total de registros encontrados
	 */
	Long findTotalGuiasPorSituacaoAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao, SituacaoGuia... ids) throws Exception;

}
