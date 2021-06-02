package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.XProduto;

public interface XProdutoDAO {
	
	public List<XProduto> listar() throws Exception;
	
	public List<XProduto> listarLike(String vdesc) throws Exception;
	
	public XProduto getBean(int id) throws Exception;
	
	public int inserir (XProduto produto) throws Exception;
	
	public int alterar (XProduto produto) throws Exception;
	
} 