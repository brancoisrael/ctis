package br.jus.tream.saude.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.XVenda;
import br.jus.tream.saude.dominio.XVendaItens;


public class XVendaItemDAOImpl implements XVendaItemDAO {
	
	private DAO<XVendaItens> dao = new DAO<XVendaItens>(XVendaItens.class);
    static XVendaItemDAOImpl db;
	
	public static XVendaItemDAO getInstance(){
		if (db == null){
			db = new XVendaItemDAOImpl();
		}
		return db;
	}
	
	@Override
	public List<XVendaItens> listar() throws Exception {
		List<XVendaItens> lista = null;
		  try {			  
			  lista =dao.listarTodos(); 
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		return lista;	
	}

	
	@Override
	public Double total() throws Exception{
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		Query query = em.createNativeQuery("SELECT sum(total) FROM venda");
		Double total = null;
		try {
		   total = new Double(query.getSingleResult().toString());
	     } catch (Exception e) {
		    e.printStackTrace();
	    }finally {
			em.close();
		}
		return total;
	}
	

	@Override
	public XVendaItens getBean(int id) throws Exception{
		XVendaItens venda = null;
		try {
			// venda = dao.getBean(id);			
		   } catch (Exception e) {
			 e.printStackTrace();
		 }
		return venda;
	} 	

	
	@Override
   public int insert(XVendaItens item) throws Exception{
		int ret = 0;
		try {
		    dao.adicionar(item);
			ret=1;
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		
		return ret;
	}
	
	@Override
	public int alterar(XVendaItens item) throws Exception{
		int ret = 0;
		try {
			
			
			dao.atualizar(item);
			
			ret=1;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public int remover(XVendaItens item) throws Exception{
		int ret = 0;
		try {
			dao.remover(item);
			ret=1;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
    
	public static void main(String[] args) throws Exception{
		/* 
		VendaItemDAO daoItens = VendaItemDAOImpl.getInstance();
		 VendaDAO vendaDao = VendaDAOImpl.getInstance();
		 VendaItens i = new VendaItens();
		 Venda venda = new Venda();
		 venda = vendaDao.getBean(5);
		 */
		
	}
}
