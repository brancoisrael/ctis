package br.jus.tream.saude.dominio;

import br.jus.tream.saude.DAO.XClienteDAO;
import br.jus.tream.saude.DAO.XClienteDAOImpl;
import br.jus.tream.saude.DAO.XProdutoDAO;
import br.jus.tream.saude.DAO.XProdutoDAOImpl;
import br.jus.tream.saude.DAO.UsuarioDAO;
import br.jus.tream.saude.DAO.UsuarioDAOImpl;

public class XDBTest {

//	public static void main(String[] args) throws Exception{
//		
//		ClienteDAO daoC = ClienteDAOImpl.getInstance();
//		XCliente c = new XCliente();
//		c.setNome("MESA 01");
//		c.setCpf("m1");
//		c.setEmail("m1@m1");
//		c.setAtivo(1);
//		daoC.inserir(c);
//		XCliente c1 = new XCliente();
//		c1.setNome("MESA 02");
//		c1.setCpf("m2");
//		c1.setEmail("m2@m2");
//		c1.setAtivo(1);
//		daoC.inserir(c1);
//		XCliente c2 = new XCliente();
//		c2.setNome("MESA 03");
//		c2.setCpf("m3");
//		c2.setEmail("m3@m3");
//		c2.setAtivo(1);
//		daoC.inserir(c2);
//		XCliente c3 = new XCliente();
//		c3.setNome("MESA 04");
//		c3.setCpf("m4");
//		c3.setEmail("m4@m4");
//		c3.setAtivo(1);
//		daoC.inserir(c3);
//		XCliente c4 = new XCliente();
//		c4.setNome("MESA 05");
//		c4.setCpf("m5");
//		c4.setEmail("m5@m5");
//		c4.setAtivo(1);
//		daoC.inserir(c4);
//				
//		// PRODUTOS
//		XProduto p1 = new XProduto();
//		p1.setDescricao("Frango Crispy");
//		p1.setValor(40.40);
//		p1.setTitulo("frango");
//		XProduto p2 = new XProduto();
//		p2.setDescricao("Vaca atolada 1 Pessoa");
//		p2.setValor(13.50);
//		p2.setTitulo("carne");
//		XProduto p3 = new XProduto();
//		p3.setDescricao("Picanha na Brasa 2 Pessoas");
//		p3.setValor(38.99);
//		p3.setTitulo("carne");
//		XProduto p4 = new XProduto();
//		p4.setDescricao("Tambaqui Assado 3 pessoas");
//		p4.setValor(75.99);
//		p4.setTitulo("peixe");
//		XProduto p5 = new XProduto();
//		p5.setDescricao("Agua 350ml");
//		p5.setValor(2.30);
//		p5.setTitulo("bebida");
//		XProduto p6 = new XProduto();
//		p6.setDescricao("Cerveja 600ml");
//		p6.setValor(7.30);
//		p6.setTitulo("bebida");
//		XProduto p7 = new XProduto();
//		p7.setDescricao("Suco Graviola Jarra 1L");
//		p7.setValor(12.50);
//		p7.setTitulo("bebida");
//		XProduto p8 = new XProduto();
//		p8.setDescricao("Creme de cupua�u com chocolate");
//		p8.setValor(6.30);
//		p8.setTitulo("sobremesa");
//		
//		ProdutoDAO daoP = ProdutoDAOImpl.getInstance();
//		daoP.inserir(p1);
//		daoP.inserir(p2);
//		daoP.inserir(p3);
//		daoP.inserir(p4);
//		daoP.inserir(p5);
//		daoP.inserir(p6); daoP.inserir(p7); daoP.inserir(p8);
//		
//		// USUARIO DO SISTEMA
//		UsuarioDAO daoUser = UsuarioDAOImpl.getInstance();
//		
//		Usuario u = new Usuario();
//		u.setNome("User 01");
//		u.setEmail("a@a");
//		u.setAdmin(0);
//		u.setSenha("1234");
//		daoUser.inserir(u);
//		
//		Usuario u1 = new Usuario();
//		u1.setNome("User 02");
//		u1.setEmail("b@b");
//		u1.setSenha("1234");
//		u1.setAdmin(0);
//		daoUser.inserir(u1);
//
//		Usuario adm = new Usuario();
//		adm.setNome("admin");
//		adm.setEmail("admin");
//		adm.setAdmin(1);
//		adm.setSenha("123456");
//		daoUser.inserir(adm);
//		
//		System.out.println("Done");
		
		/*
		Cliente c = new Cliente();
		c = ClienteDAOImpl.getInstance().getBean(2);
		Usuario u1 = new Usuario();
		u1 = UsuarioDAOImpl.getInstance().getBean(8);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Venda venda = new Venda();
		venda.setCliente(c);
		venda.setDatacad(sdf.parse("13/12/2018 12:25"));
		venda.setUsuario(u1);
		Produto p1 = new Produto();
		p1 = ProdutoDAOImpl.getInstance().getBean(4);
		Produto p2 = new Produto();
		p2 = ProdutoDAOImpl.getInstance().getBean(5);
		//venda.setDatacad(new Date(System.currentTimeMillis()));
		VendaItens it1 = new VendaItens(venda, p1, 1, 0.0, p1.getValor(), p1.getValor(), null);
		VendaItens it2 = new VendaItens(venda, p2, 2, 0.0, p2.getValor(), p2.getValor(), null);
		venda.getItens().addAll(Arrays.asList(it1, it2));
		venda.setTotal(venda.getValorTotal());
		venda.setStatus(0);
		VendaDAO daoV = VendaDAOImpl.getInstance();
		daoV.insert(venda);
		System.out.println("Done!!");
		*/
		
		/*
		VendaDAO daoV = VendaDAOImpl.getInstance();
		Venda venda = new Venda();
		venda = daoV.getBean(12);
		double soma = 0.0;
		System.out.println("Data " + venda.getCliente().getNome()+" Garcom: " + venda.getUsuario().getNome());
		
		for (VendaItens item : venda.getItens()) {
			soma += item.getValor();
			System.out.println("--- Item qtd "+ item.getQuantidade() + " " + item.getProduto().getDescricao() + 
					 " SubTotal = " + item.getSubTotal() + " Total " + item.getValor() );
		}
		
		System.out.println("Total " + venda.getTotal() + " (var soma = " + soma + ")");
		venda.setTotal(soma);
		venda.setObs("Teste altera��o ");
		daoV.alterar(venda);
		System.out.println("Done!!");
		*/
		
		//System.out.println(venda.toString()); 
		
		
//	}

}
