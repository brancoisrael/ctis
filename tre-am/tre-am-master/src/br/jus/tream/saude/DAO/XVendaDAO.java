package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.DTO.ProdutosMaisVendidos;
import br.jus.tream.saude.DTO.VendaSituacaoDTO;
import br.jus.tream.saude.dominio.XVenda;

public interface XVendaDAO {
	
	public List<XVenda> listar() throws Exception;
	
	public List<XVenda> listar(String dtini, String dtfim) throws Exception;
	
	public List<VendaSituacaoDTO> listarSituacao() throws Exception;
	
	public List<ProdutosMaisVendidos> ListarProdutosMaisVendidos() throws Exception;
	
	public XVenda getBean(int id) throws Exception;
	
	public Double total() throws Exception;
	
	public int inserir(XVenda venda) throws Exception;
	
	public int alterar(XVenda venda) throws Exception;
	
	public int remover(XVenda venda) throws Exception;


}
