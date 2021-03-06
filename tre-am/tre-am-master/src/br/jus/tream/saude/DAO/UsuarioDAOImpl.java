package br.jus.tream.saude.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.jus.tream.saude.dominio.Usuario;
import br.jus.tream.saude.util.FuncsUtils;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
	
    static UsuarioDAO db;
	
	public static UsuarioDAO getInstance(){
		if (db == null){
			db = new UsuarioDAOImpl();
		}
		return db;
	}
	
	@Override
	public Usuario getBean(Long id) throws Exception{
		Usuario usuario = new Usuario();
		try {
			usuario = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Usuario getBean(String login) throws Exception{
		Usuario usuario = new Usuario();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {						
			 TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c WHERE c.login = :login", Usuario.class);
			 usuario = query.setParameter("login", login).getSingleResult();
		} catch (Exception e) {
			// e.printStackTrace();
		}finally {
			em.close();
		}
		return usuario;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarCbx() throws Exception{
		List<Usuario> lista = new ArrayList<Usuario>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
	   try {	  
			   // HOUVE A NECESSIDADE DE CRIAR UM CONSTRUTOR (ID,NOME) PARA REALIZAR ESSA OPERA��O  
		      Query query = em.createQuery("SELECT NEW Usuario(c.id, c.nome) from Usuario c");
			  lista = query.getResultList();
		  }
		  catch (Exception e) {
			     em.close();
				e.printStackTrace();
		  }	finally {
				em.close();
		  }
		return lista;	
	} 
	
	@Override
	public int inserir (Usuario usuario) throws Exception{
		int ret = 0;
		try {
			usuario.setSenha(FuncsUtils.getInstance().encriptar(usuario.getSenha()));
			dao.adicionar(usuario);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int alterar (Usuario usuario) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(usuario);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public int remover (Usuario usuario) throws Exception{
		int ret = 0;
		try {
			dao.remover(usuario);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Usuario> listar() throws Exception {
		List<Usuario> lista = null;
		  try {
			  lista = dao.listarTodos();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		return lista;	
	}
	
	    
	public static void main(String[] args) throws Exception{
		UsuarioDAO dao = UsuarioDAOImpl.getInstance();
		/*
		Usuario u0 = new Usuario();
		u0.setNome("User 01");
		u0.setEmail("a@a");
		u0.setSenha("123");
		u0.setAdmin(0);
		dao.inserir(u0);
		
		
		Usuario u1 = new Usuario();
		u1.setNome("User 02");
		u1.setEmail("b@b");
		u1.setSenha("123");
		u0.setAdmin(0);
		dao.inserir(u1);

		Usuario adm = new Usuario();
		adm.setNome("admin");
		adm.setEmail("admin");
		adm.setSenha("123456");
		u0.setAdmin(1);
		dao.inserir(adm);
		*/
		
		
//		 for (Usuario z : dao.listar()) {
//				System.out.println("id/Nome " + z.getId() +"/"+ z.getNome() + " admin=" + z.getAdmin()); 
//		 } 
		
		/*
		Usuario u = new Usuario();
		u = dao.getBean("admin");
		System.out.println("GetBean pelo ID Nome " + u.getNome() + " SENHA  " + u.getSenha());
		System.out.println("Senha crip " + FuncsUtils.getInstance().encriptar("123456"));
		System.out.println("Permiss�o -> " + u.getSenha().equals(FuncsUtils.getInstance().encriptar("123456")));
		
		System.out.println("Done!");
		u = dao.getBean("b@b");
		System.out.println("GETBean Pelo email Nome " + u.getNome() );
	*/	
	}
}
