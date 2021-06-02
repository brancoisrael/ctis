package br.jus.tream.saude.DAO;

import br.jus.tream.saude.dominio.TipoGuia;

/**
 * Define o contrato de acesso a dados da entidade {@link TipoGuia}.
 * @author vinicius
 *
 */
public interface TipoGuiaDAO {

	/**
	 * Busca um registro pelo seu identificador
	 * @param id identificador do registro
	 * @return Instância de encontrada ou null
	 */
	TipoGuia findById(Long id);


	

}
