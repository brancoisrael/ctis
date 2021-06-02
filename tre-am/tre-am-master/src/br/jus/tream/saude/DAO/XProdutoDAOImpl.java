package br.jus.tream.saude.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.jus.tream.saude.dominio.XProduto;


public class XProdutoDAOImpl implements XProdutoDAO {
	private DAO<XProduto> dao = new DAO<XProduto>(XProduto.class);
	static XProdutoDAOImpl db;
	
	public static XProdutoDAO getInstance(){
		if (db == null){
			db = new XProdutoDAOImpl();
		}
		return db;
	}

	@Override
	public XProduto getBean(int id) throws Exception{
		XProduto Produto = new XProduto();
		try {
//			Produto = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Produto;
	}

	@Override
	public List<XProduto> listarLike(String vdesc) throws Exception{
		List<XProduto> produtos = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {						
			 TypedQuery<XProduto> query = em.createQuery("SELECT c FROM Produto c WHERE c.descricao LIKE ?1", XProduto.class);
			 produtos = query.setParameter(1, "%" + vdesc + "%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return produtos;
	}
	
	
	@Override
	public int inserir (XProduto Produto) throws Exception{
		int ret = 0;
		try {
			dao.adicionar(Produto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int alterar (XProduto Produto) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(Produto);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<XProduto> listar() throws Exception {
		List<XProduto> lista = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			  // lista = dao.listarTodos();
			  TypedQuery<XProduto> query = em.createQuery("SELECT c FROM Produto c ORDER BY c.descricao", 
					    XProduto.class);
			  lista = query.getResultList();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
			}
		return lista;	
	}
	
	public byte[] readBytes(File file) throws IOException {
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		try {
			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
			}
		} finally {
			try {
				if (ous != null)
					ous.close();
			} catch (IOException e) {
			}

			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
			}
		}
		return ous.toByteArray();
	}
	
    
	public static void main(String[] args) throws Exception{
//		XProdutoDAO dao = XProdutoDAOImpl.getInstance();
		//File fileUpload = new File("C://temp/galinha_molho_pardooo.jpg");
		
		//Produto p0 = new Produto();
		//int ret = 0;
		//p0 = dao.getBean(10);
		//p0.setDescricao("Lasanha de Carne para 2 pessoas");
		//p0.setTitulo("Lasanha de carne com molho bolonhesa");
		//p0.setValor(new BigDecimal("37.00"));
		//p0.setPicture(FuncsUtils.getInstance().readBytes(fileUpload));
		
		//ret = dao.alterar(p0);
		//System.out.println("atualizado  = " + ret );
		
		
//		for (XProduto p : dao.listar()) {
//			System.out.println("produto " + p.getDescricao() + " " + p.getValor());
//		}
		
				
	}
}
