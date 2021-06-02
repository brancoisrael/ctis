package br.jus.tream.saude.util;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.jus.tream.saude.exception.MapeamentoDTOException;

/**
 * Respons�vel por realizar o mapeamento entre entidades e Dtos
 * 
 * @author Vinicius
 *
 */
public class Mapeador {

	/**
	 * Respons�vel por converter uma lista de objetos para os dtos respondentes do
	 * contrato do servi�o
	 * 
	 * @param listaParaConverter cont�m os dados que ser�o transformados em dtos.
	 * @param classeTo           classe de destino da convers�o.
	 * @return lista de dtos.
	 */
	@SuppressWarnings("unchecked")
	public <J, L> List<J> paraListaDto(List<L> listaParaConverter, Class<J> classeTo) {

		if (listaParaConverter == null || listaParaConverter.isEmpty()) {
			return (List<J>) new ArrayList<L>();
		}
		try {
			List<J> dtos = new ArrayList<J>();
			Constructor<?> cons = classeTo.getConstructor(listaParaConverter.get(0).getClass());
			for (L objeto : listaParaConverter) {
				dtos.add((J) cons.newInstance(objeto));
			}
			return dtos;
		} catch (Exception e) {
			throw new MapeamentoDTOException("Erro ao converter lista de entidades para lista de dtos", e);
		}
	}

	/**
	 * Respons�vel por converter o objeto informado para o dto correspondente.
	 * 
	 * @param objetoParaConverter objeto que ter�o suas infor��es transferidas para o
	 *                            dto correspondente.
	 * @param classeTo            classe de destino da convers�o.
	 * @return
	 * @return inst�ncia do dto correspondente ao objeto informado.
	 */
	@SuppressWarnings("unchecked")
	public <L, J> J paraDto(L objetoParaConverter, Class<J> classeTo) {
		try {
			Constructor<?> cons = classeTo.getConstructor(objetoParaConverter.getClass());
			return (J) cons.newInstance(objetoParaConverter);

		} catch (Exception e) {
			throw new MapeamentoDTOException("Erro ao converter entidade para dto", e);
		}
	}

	/**
	 * Respons�vel por converter um Map de objetos para os dtos correspondentes do
	 * contrato do servi�o
	 * 
	 * @param map cont�m os dados que ser�o transformados em dtos.
	 * @return lista de dtos.
	 * @throws Exception .
	 */
	@SuppressWarnings("unchecked")
	public <C, V, K> List<K> paraListaDto(Map<C, V> map, Class<K> classeTo) throws Exception {
		if (map == null) {
			return new ArrayList<K>();
		}
		try {
			List<K> dtos = new ArrayList<K>();
			Constructor<?> cons = classeTo.getConstructor(Map.Entry.class);
			for (Map.Entry<C, V> entry : map.entrySet()) {
				dtos.add((K) cons.newInstance(entry));
			}
			return dtos;
		} catch (Exception e) {
			throw new MapeamentoDTOException("Erro ao converter map de entidades para lista de dto", e);
		}
	}
	
	

}
