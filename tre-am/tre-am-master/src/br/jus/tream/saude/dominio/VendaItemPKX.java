package br.jus.tream.saude.dominio;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VendaItemPKX implements  Serializable {
	   private static final long serialVersionUID = 1L;
	   
//	   @ManyToOne
//	   @JoinColumn(name="id_venda")
//	   private XVenda venda;
//	   
//	   @ManyToOne
//	   @JoinColumn(name="id_produto")
//	   private XProduto produto;
//	   
//		public XVenda getVenda() {
//			return this.venda;
//		}
//		public void setVenda(XVenda venda) {
//			this.venda = venda;
//		}
//		public XProduto getProduto() {
//			return this.produto;
//		}
//		public void setProduto(XProduto produto) {
//			this.produto = produto;
//		}
//		
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((venda == null) ? 0 : venda.hashCode());
//			result = prime * result + ((produto == null) ? 0 : produto.hashCode());
//			return result;
//		}
//		
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			VendaItemPKX other = (VendaItemPKX) obj;
//			if (venda == null) {
//				if (other.venda != null)
//					return false;
//			} else if (!venda.equals(other.venda))
//				return false;
//			if (produto == null) {
//				if (other.produto != null)
//					return false;
//			} else if (!produto.equals(other.produto))
//				return false;
//			return true;
//		 }

  }		