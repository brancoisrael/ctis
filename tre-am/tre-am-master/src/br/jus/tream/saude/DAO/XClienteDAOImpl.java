package br.jus.tream.saude.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.jus.tream.saude.dominio.XCliente;

public class XClienteDAOImpl implements XClienteDAO {
	
//	private DAO<XCliente> dao = new DAO<XCliente>(XCliente.class);
//	
//    static XClienteDAO db;
//	
//	public static XClienteDAO getInstance(){
//		if (db == null){
//			db = new XClienteDAOImpl();
//		}
//		return db;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<XCliente> listarSemComanda() throws Exception{
//	  List<XCliente> lista = new ArrayList<XCliente>();
// 	  EntityManager em = EntityManagerProvider.getInstance().createManager();
//	   try {	  
//			   String sqlString = "SELECT id, email, nome, cpf, ativo FROM cliente WHERE id NOT IN (" + 
//			   		"SELECT c.id FROM venda v, cliente c WHERE v.id_cliente=c.id AND v.status in (0,1)" + 
//			   		") ORDER BY nome";  
//		      Query query = em.createNativeQuery(sqlString, XCliente.class);
//		     lista = query.getResultList();
//		  }
//		  catch (Exception e) {
//			     em.close();
//				e.printStackTrace();
//		  }	finally {
//				em.close();
//		  }
//		return lista;	
//	}
//	
//	@Override
//	public XCliente getBean(int id) throws Exception{
//		XCliente cliente = new XCliente();
//		try {
//			cliente = dao.getBean(id); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cliente;
//	}
//
//	@Override
//	public XCliente getBean(String email) throws Exception{
//		XCliente cliente = null;
//		EntityManager em = EntityManagerProvider.getInstance().createManager();
//		try {						
//			 TypedQuery<XCliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", XCliente.class);
//			 cliente = query.setParameter("email", email).getSingleResult();
//		} catch (Exception e) {
//			//e.printStackTrace();
//		}finally {
//			em.close();
//		}
//		return cliente;
//	}
//	
//	@Override
//	public XCliente getBeanByName(String nome) throws Exception{
//		XCliente cliente = new XCliente();
//		EntityManager em = EntityManagerProvider.getInstance().createManager();
//		try {
//			 TypedQuery<XCliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome", XCliente.class);
//			 cliente = query.setParameter("nome", nome.toUpperCase()).getSingleResult();
//		} catch (Exception e) {
//			// e.printStackTrace();
//		}finally {
//			em.close();
//		}
//		return cliente;
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<XCliente> listarCbx() throws Exception{
//		List<XCliente> lista = new ArrayList<XCliente>();
//		EntityManager em = EntityManagerProvider.getInstance().createManager();
//	   try {	  
//			   // HOUVE A NECESSIDADE DE CRIAR UM CONSTRUTOR (ID,NOME) PARA REALIZAR ESSA OPERAÇÃO  
//		      Query query = em.createQuery("SELECT NEW Cliente(c.id, c.nome) from Cliente c");
//			  lista = query.getResultList();
//		  }
//		  catch (Exception e) {
//			     em.close();
//				// e.printStackTrace();
//		  }	finally {
//				em.close();
//		  }
//		return lista;	
//	} 
//	
//	@Override
//	public int inserir (XCliente cliente) throws Exception{
//		int ret = 0;
////		try {
////			cliente.setNome(cliente.getNome().toUpperCase());
////			dao.adicionar(cliente);
////			ret =1;
////		} catch (Exception e) {
////			//e.printStackTrace();
////		}
//		return ret;
//	}
//	
//	@Override
//	public int alterar (XCliente cliente) throws Exception{
//		int ret = 0;
////		try {
////			cliente.setNome(cliente.getNome().toUpperCase());
////			dao.atualizar(cliente);
////			ret =1;
////		} catch (Exception e) {
////			//System.out.println("Ocorreu um ERRO " + e.getMessage());
////			//e.printStackTrace();
////		}
//		return ret;
//	}
//	
//	
//	public int remover (XCliente cliente) throws Exception{
//		int ret = 0;
//		try {
//			dao.remover(cliente);
//			ret =1;
//		} catch (Exception e) {
//			//System.out.println("Ocorreu um ERRO " + e.getMessage());
//			e.printStackTrace();
//		}
//		return ret;
//	}
//
//	@Override
//	public List<XCliente> listar() throws Exception {
//		List<XCliente> lista = null;
//		  try {
//			  lista = dao.listarTodos();
//		  }
//		  catch (Exception e) {
//				e.printStackTrace();
//			}
//		return lista;	
//	}
	
	    
//	public static void main(String[] args) throws Exception{
//		XClienteDAO dao = XClienteDAOImpl.getInstance();
//		
//		XCliente u = new XCliente();
//		u = dao.getBeanByName("MESA 10");
//		if (u.getNome()!=null){
//			 System.out.println("Tem valor");	
//		}else {
//			System.out.println("valor nulo");
//		}
		
		
		/*
		u.setNome("MESA 05");
		u.setSigla("MESA 05");
		//String senha = FuncsUtils.getInstance().encriptar("senha123");
		
		int ret = dao.inserir(u);
		System.out.println("atualizado  = " + ret );	*/	
		 /*
		 for (Cliente z : dao.listarSemComanda()) {
				System.out.println("Nome " + z.getNome()); 
		 }
		*/
		/*
		u = dao.getBean(4);
		System.out.println("GetBean pelo ID Nome " + u.getNome() + " CPF " + u.getCpf());
		 
		u = dao.getBean("vinicius.cavalcante@tre-am.jus.br");
		System.out.println("GETBean Pelo email Nome " + u.getNome() + " CPF " + u.getCpf() + " end " + u.getEndereco().getEndereco());
		*/
//	}
}
