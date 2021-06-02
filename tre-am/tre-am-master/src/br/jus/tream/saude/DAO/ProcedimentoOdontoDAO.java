package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.ProcedimentoOdonto;
import br.jus.tream.saude.dominio.ProcedimentoPK;

public interface ProcedimentoOdontoDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	ProcedimentoOdonto findById(ProcedimentoPK id);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<ProcedimentoOdonto> findAll();

	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da paginação
	 * @return lista de registros encontrados
	 */
	List<ProcedimentoOdonto> findByParams(ProcedimentoParamsDTO params);

}
