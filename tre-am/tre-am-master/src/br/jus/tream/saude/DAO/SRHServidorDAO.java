package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.SRHServidor;

public interface SRHServidorDAO {
	
	public List<SRHServidor> consultar(String hql, Object[] param);
	
	public List<SRHServidor> listar() throws Exception;
	
	public List<SRHServidor> listarCbx() throws Exception; 
	
	public SRHServidor getBean(String matricula) throws Exception;
	
	public SRHServidor getBeanByTitulo(String titulo) throws Exception;
	
	
} 