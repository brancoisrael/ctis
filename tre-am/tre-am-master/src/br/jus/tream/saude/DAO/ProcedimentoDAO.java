package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoPK;

public interface ProcedimentoDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Inst�ncia de encontrada ou null
	 */
	Procedimento findById(ProcedimentoPK id);

	/**
	 * Busca todos os registros
	 * 
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Procedimento> findAll();

	/**
	 * Pesquisa os registros de acordo com os filtros informados
	 * 
	 * @param params     filtros utilizados
	 * @param pagination dados da pagina��o
	 * @return lista de registros encontrados
	 */
	List<Procedimento> findByParams(ProcedimentoParamsDTO params);

}
