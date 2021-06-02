package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.XVendaItens;

public interface XVendaItemDAO {

	public List<XVendaItens> listar() throws Exception;

	public XVendaItens getBean(int id) throws Exception;

	public Double total() throws Exception;

	public int insert(XVendaItens item) throws Exception;

	public int alterar(XVendaItens item) throws Exception;

	public int remover(XVendaItens item) throws Exception;

}
