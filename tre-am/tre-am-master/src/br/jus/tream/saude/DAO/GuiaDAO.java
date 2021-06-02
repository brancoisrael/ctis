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
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Guia> findAll(Pagination pagination);

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Guia findById(GuiaPK id);

	/**
	 * Respons�vel por criar um {@link Guia}
	 * 
	 * @param guia que ser� criado
	 * @return
	 * @throws Exception
	 */
	int inserir(Guia guia) throws Exception;

	/**
	 * Respons�vel por alterar os dados do {@link Guia}
	 * 
	 * @param guia que ser� alterado
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
	 * Retorna o total de registros no m�s informado
	 * 
	 * @return total de registros encontrados
	 */
	Long totalGuiasAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception;
	

	/**
	 * Gera o pr�ximo n�mero da sequence
	 * 
	 * @return pr�ximo n�mero da sequence
	 */
	Long getSequence();
	
	/**
	 * Retorna o total de registros de acordo com os par�metros informados
	 * 
	 * @param anoMes desejado
	 * @param idCredenciada identificador da credenciada
	 * @param ids identificadores das situa��es desejadas
	 * 
	 * @return total de registros encontrados
	 */
	Long findTotalGuiasPorSituacaoAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao, SituacaoGuia... ids) throws Exception;

}
