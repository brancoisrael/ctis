package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name = "venda")
public class XVenda implements Serializable {
	private static final long serialVersionUID = 5099599755067507613L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
//	@GenericGenerator(name = "native", strategy = "native")
//	private Integer id;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "datacad")
//	private Date datacad;
//
//	@ManyToOne
//	@JoinColumn(name = "id_cliente")
//	private XCliente cliente;
//
//	@ManyToOne
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;
//
//	private Double total;
//
//	@Column(name = "obs", length = 400)
//	private String obs;
//	
//	@Column(name = "status")
//	private Integer status;
//
//	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.venda", fetch =  FetchType.EAGER, orphanRemoval = true)
//	@OneToMany(cascade = {CascadeType.REFRESH,CascadeType.REMOVE}, mappedBy = "id.venda", fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	private List<XVendaItens> itens = new ArrayList<XVendaItens>();
//
//	//@OneToMany(mappedBy = "id.venda")
//	//private List<VendaItens> itens;
//	//private Set<VendaItens> itens = new HashSet<>(); // Classe Set não permite itens repetidos
//
//	public XVenda() {
//	}
//
//	public XVenda(Integer id, Date datacad, XCliente cliente, Usuario usuario, Double total, String obs, Integer status) {
//		super();
//		this.id = id;
//		this.datacad = datacad;
//		this.cliente = cliente;
//		this.usuario = usuario;
//		this.total = total;
//		this.obs = obs;
//		this.status = status;
//	}
//	
//	public XVenda(Integer id, Date datacad, XCliente cliente, Usuario usuario, Integer status) {
//		this.id = id;
//		this.datacad = datacad;
//		this.cliente = cliente;
//		this.usuario = usuario;
//		this.status = status;
//	}
//
//	public double getValorTotal() {
//		double soma = 0.0;
//		for (XVendaItens item : this.itens) {
//			soma += item.getSubTotal();
//		}
//		return soma;
//	}
//
//	public List<XVendaItens> getItens() {
//		return itens;
//	}
//
//	public void setItens(List<XVendaItens> itens) {
//		this.itens = itens;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Date getDatacad() {
//		return datacad;
//	}
//
//	public void setDatacad(Date datacad) {
//		this.datacad = datacad;
//	}
//
//	public XCliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(XCliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public Double getTotal() {
//		return total;
//	}
//
//	public void setTotal(Double total) {
//		this.total = total;
//	}
//
//	public String getObs() {
//		return obs;
//	}
//
//	public void setObs(String obs) {
//		this.obs = obs;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	
//	
//	public Integer getStatus() {
//		return status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		Integer result = 1;
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		XVenda other = (XVenda) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		StringBuilder builder = new StringBuilder();
//		builder.append("Venda número: ");
//		builder.append(getId());
//		builder.append(", Instante: ");
//		builder.append(sdf.format(getDatacad()));
//		builder.append(", Cliente: ");
//		builder.append(getCliente().getNome());
//		builder.append("\nDetalhes:\n");
//		
//		for (XVendaItens ip : getItens()) {
//			builder.append(ip.toString());
//		}
//		builder.append("Valor total: ");
//		builder.append(nf.format(getValorTotal()));
//		return builder.toString();
//	}

}
