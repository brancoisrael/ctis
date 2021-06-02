package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.jus.tream.saude.dominio.Banco;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.util.DateUtil;

/**
 * Representa os dados de um {@link Banco}.
 * 
 * @author vinicius
 *
 */
public class GuiaProcedimentoDTO implements Serializable {

	private static final long serialVersionUID = 4370945257181600885L;

	private Long id;
	private ProcedimentoDTO procedimento;
	private GuiaDTO guia;
	private Integer quantidade;
	private BigDecimal valor;
	private Integer viaAcesso;
	private Integer video;
	private BigDecimal valorCalculado;

	public GuiaProcedimentoDTO() {
	}

	public GuiaProcedimentoDTO(GuiaProcedimento gp) throws Exception {
		this.id = gp.getId();
		this.procedimento = gp.getProcedimento() != null ? new ProcedimentoDTO(gp.getProcedimento()) : null;
		this.guia = gp.getGuia() != null ? new GuiaDTO(gp.getGuia()) : null;
		this.quantidade = gp.getQuantidade();
		this.valor = gp.getValor();
		this.viaAcesso = gp.getViaAcesso();
		this.video = gp.getVideo();
		this.valorCalculado = gp.getValorCalculado();
	}
	
	public GuiaProcedimentoDTO(GuiaProcedimento gp, Boolean origemNaGuia) {
		this.id = gp.getId();
		this.procedimento = gp.getProcedimento() != null ? new ProcedimentoDTO(gp.getProcedimento()) : null;		
		this.quantidade = gp.getQuantidade();
		this.valor = gp.getValor();
		this.viaAcesso = gp.getViaAcesso();
		this.video = gp.getVideo();
		this.valorCalculado = gp.getValorCalculado();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProcedimentoDTO getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoDTO procedimento) {
		this.procedimento = procedimento;
	}

	public GuiaDTO getGuia() {
		return guia;
	}

	public void setGuia(GuiaDTO guia) {
		this.guia = guia;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getViaAcesso() {
		return viaAcesso;
	}

	public void setViaAcesso(Integer viaAcesso) {
		this.viaAcesso = viaAcesso;
	}

	public Integer getVideo() {
		return video;
	}

	public void setVideo(Integer video) {
		this.video = video;
	}

	public BigDecimal getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(BigDecimal valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorCalculado == null) ? 0 : valorCalculado.hashCode());
		result = prime * result + ((viaAcesso == null) ? 0 : viaAcesso.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiaProcedimentoDTO other = (GuiaProcedimentoDTO) obj;
		if (guia == null) {
			if (other.guia != null)
				return false;
		} else if (!guia.equals(other.guia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorCalculado == null) {
			if (other.valorCalculado != null)
				return false;
		} else if (!valorCalculado.equals(other.valorCalculado))
			return false;
		if (viaAcesso == null) {
			if (other.viaAcesso != null)
				return false;
		} else if (!viaAcesso.equals(other.viaAcesso))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

}
