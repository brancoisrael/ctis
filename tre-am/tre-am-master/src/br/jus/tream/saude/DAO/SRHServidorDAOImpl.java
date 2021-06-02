package br.jus.tream.saude.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tream.saude.dominio.SRHServidor;

public class SRHServidorDAOImpl implements SRHServidorDAO {
	private DAO<SRHServidor> dao = new DAO<SRHServidor>(SRHServidor.class);
	
    static SRHServidorDAO db;
	
	public static SRHServidorDAO getInstance(){
		if (db == null){
			db = new SRHServidorDAOImpl();
		}
		return db;
	}
	
	@Override
	public List<SRHServidor> consultar(String hql, Object[] param){
		List<SRHServidor> lista = new ArrayList<SRHServidor>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
	   try {
		     TypedQuery<SRHServidor> query = em.createQuery(hql, SRHServidor.class);
		     System.out.println("Tamanho do param " + param.length);
		     if (param != null && param.length > 0) {
					for (int i = 0; i < param.length; i++) {
						query.setParameter(i, param[i]);
					}
				}	
			   lista = query.getResultList();
		  }
		  catch (Exception e) {
			  // e.printStackTrace();
		     em.close();
		  }	finally {
				em.close();
	    }
		return lista;	
	}
	
	
	@Override
	public List<SRHServidor> listar() throws Exception {
		List<SRHServidor> lista = null;
		  try {
			  lista = dao.listarTodos();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		return lista;	
	}
	

	
	@Override
	public SRHServidor getBean(String matricula) throws Exception{
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		SRHServidor servidor = new SRHServidor();
		try {
			TypedQuery<SRHServidor> query = em.createQuery("SELECT u FROM SRHServidor u WHERE u.matricula=?1", 
					SRHServidor.class);
			servidor = query.setParameter(1, matricula).getSingleResult(); 
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		}finally {
				em.close();
		  }
		return servidor;
	}
	
	@Override
	public SRHServidor getBeanByTitulo(String titulo) throws Exception{
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		SRHServidor servidor = new SRHServidor();
		try {
			TypedQuery<SRHServidor> query = em.createQuery("SELECT u FROM SRHServidor u WHERE lpad(u.tituloEleitor,12,0)=lpad(?1,12,0)", 
					SRHServidor.class);
			servidor = query.setParameter(1, titulo).getSingleResult(); 
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		}finally {
				em.close();
		  }
		return servidor;
	}
	
	
	@Override
	public List<SRHServidor> listarCbx() throws Exception{
		List<SRHServidor> lista = new ArrayList<SRHServidor>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
	   try {	  
		     TypedQuery<SRHServidor> query = em.createQuery("SELECT NEW SRHServidor(s.id, s.tituloEleitor, s.nome) FROM SRHServidor s ORDER BY s.nome", 
		    		 SRHServidor.class);
			  lista = query.getResultList();
		  }
		  catch (Exception e) {
			     em.close();
				// e.printStackTrace();
		  }	finally {
				em.close();
		  }
		return lista;	
	} 

	    
	public static void main(String[] args) throws Exception{
		SRHServidorDAO dao = SRHServidorDAOImpl.getInstance();

		//SRHServidor s = dao.getBeanByTitulo("15697172275");
		//System.out.println("Nome " + s.getNome());
		
		String jpql = "FROM SRHServidor s WHERE s.nome LIKE ?0 AND s.mat=?1";
		String nom = "%MOACIR%";
		Integer mat = 2301634;
		Object[] param = {nom, mat};
		for (SRHServidor se : dao.consultar(jpql, param)) {
			System.out.println("Nome " + se.getNome());
		}
		
		
		System.out.println("Done!!");
		
		
	}
}
