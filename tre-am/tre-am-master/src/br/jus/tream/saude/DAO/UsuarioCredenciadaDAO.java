package br.jus.tream.saude.DAO;

import java.util.List;

import br.jus.tream.saude.dominio.UsuarioCredenciadaVW;

public interface UsuarioCredenciadaDAO {
	
	public List<UsuarioCredenciadaVW> listar() throws Exception;
	
	public UsuarioCredenciadaVW getBean(Long id) throws Exception;
	
	public UsuarioCredenciadaVW findByLoginSenha(String login, String senha) throws Exception;
	
	
} 