package br.jus.tream.saude.dominio;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento extends ProcedimentoBase implements Serializable {

	private static final long serialVersionUID = 2091830613774059095L;
	@EmbeddedId
	private ProcedimentoPK procedimentoPK;
//	@Column(name = "NOM_PROCEDIMENTO", nullable = false, length = 260)
//	private String nome;
//	@Column(name = "VALOR_PROCEDIMENTO")
//	private BigDecimal valor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESPECIALIDADE")
	private Especialidade especialidade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PORTE")
	private Porte porte;
	@Column(name = "REQUER_ESPECIALIDADE")
	private Integer requerEspecialidade;
	@Column(name = "REQUER_AUTORIZACAO")
	private Integer requerAutorizacao;
	@Column(name = "QTD_AUXILIAR")
	private Integer quantidade;
	@Column(name = "DETALHA_PROCED")
	private Integer detalhaProcedimento;
//	@Column(name = "PROCEDIMENTO_ATIVO")
//	private Integer procedimentoAtivo;
	@Column(name = "IND_EXCECAO")
	private Integer indicaExcecao;
	@Column(name = "TRATAMENTO_SERIADO")
	private Integer tratamentoSeriado;
//	@Column(name = "DAT_ULT_ATUAL")
//	private LocalDateTime dataAtualizacao;
	@Column(name = "ANT_COD_PROCEDIMENTO")
	private String antCodigoProcedimento;
//	@Column(name = "PRAZO_CARENCIA_MIN")
//	private Integer prazoCarencia;
	@Column(name = "CONSULTA")
	private Integer consulta;
	
	public Procedimento() {
			
	}
	
	public Procedimento(Procedimento p) {
		this.procedimentoPK = p.getProcedimentoPK();
		this.consulta = p.getConsulta();
	}

	public ProcedimentoPK getProcedimentoPK() {
		return procedimentoPK;
	}

	public void setProcedimentoPK(ProcedimentoPK procedimentoPK) {
		this.procedimentoPK = procedimentoPK;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public Integer getRequerEspecialidade() {
		return requerEspecialidade;
	}

	public void setRequerEspecialidade(Integer requerEspecialidade) {
		this.requerEspecialidade = requerEspecialidade;
	}

	public Integer getRequerAutorizacao() {
		return requerAutorizacao;
	}

	public void setRequerAutorizacao(Integer requerAutorizacao) {
		this.requerAutorizacao = requerAutorizacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getDetalhaProcedimento() {
		return detalhaProcedimento;
	}

	public void setDetalhaProcedimento(Integer detalhaProcedimento) {
		this.detalhaProcedimento = detalhaProcedimento;
	}

	@Override
	public Integer getProcedimentoAtivo() {
		return procedimentoAtivo;
	}

	@Override
	public void setProcedimentoAtivo(Integer procedimentoAtivo) {
		this.procedimentoAtivo = procedimentoAtivo;
	}

	public Integer getIndicaExcecao() {
		return indicaExcecao;
	}

	public void setIndicaExcecao(Integer indicaExcecao) {
		this.indicaExcecao = indicaExcecao;
	}

	public Integer getTratamentoSeriado() {
		return tratamentoSeriado;
	}

	public void setTratamentoSeriado(Integer tratamentoSeriado) {
		this.tratamentoSeriado = tratamentoSeriado;
	}

	@Override
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	@Override
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getAntCodigoProcedimento() {
		return antCodigoProcedimento;
	}

	public void setAntCodigoProcedimento(String antCodigoProcedimento) {
		this.antCodigoProcedimento = antCodigoProcedimento;
	}

	@Override
	public Integer getPrazoCarencia() {
		return prazoCarencia;
	}

	@Override
	public void setPrazoCarencia(Integer prazoCarencia) {
		this.prazoCarencia = prazoCarencia;
	}

	public Integer getConsulta() {
		return consulta;
	}

	public void setConsulta(Integer consulta) {
		this.consulta = consulta;
	}
	
	@Transient
	public boolean isConsulta() {
		return this.consulta == 1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antCodigoProcedimento == null) ? 0 : antCodigoProcedimento.hashCode());
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((detalhaProcedimento == null) ? 0 : detalhaProcedimento.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((indicaExcecao == null) ? 0 : indicaExcecao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((porte == null) ? 0 : porte.hashCode());
		result = prime * result + ((prazoCarencia == null) ? 0 : prazoCarencia.hashCode());
		result = prime * result + ((procedimentoAtivo == null) ? 0 : procedimentoAtivo.hashCode());
		result = prime * result + ((procedimentoPK == null) ? 0 : procedimentoPK.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((requerAutorizacao == null) ? 0 : requerAutorizacao.hashCode());
		result = prime * result + ((requerEspecialidade == null) ? 0 : requerEspecialidade.hashCode());
		result = prime * result + ((tratamentoSeriado == null) ? 0 : tratamentoSeriado.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Procedimento other = (Procedimento) obj;
		if (antCodigoProcedimento == null) {
			if (other.antCodigoProcedimento != null)
				return false;
		} else if (!antCodigoProcedimento.equals(other.antCodigoProcedimento))
			return false;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (detalhaProcedimento == null) {
			if (other.detalhaProcedimento != null)
				return false;
		} else if (!detalhaProcedimento.equals(other.detalhaProcedimento))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (indicaExcecao == null) {
			if (other.indicaExcecao != null)
				return false;
		} else if (!indicaExcecao.equals(other.indicaExcecao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (porte == null) {
			if (other.porte != null)
				return false;
		} else if (!porte.equals(other.porte))
			return false;
		if (prazoCarencia == null) {
			if (other.prazoCarencia != null)
				return false;
		} else if (!prazoCarencia.equals(other.prazoCarencia))
			return false;
		if (procedimentoAtivo == null) {
			if (other.procedimentoAtivo != null)
				return false;
		} else if (!procedimentoAtivo.equals(other.procedimentoAtivo))
			return false;
		if (procedimentoPK == null) {
			if (other.procedimentoPK != null)
				return false;
		} else if (!procedimentoPK.equals(other.procedimentoPK))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (requerAutorizacao == null) {
			if (other.requerAutorizacao != null)
				return false;
		} else if (!requerAutorizacao.equals(other.requerAutorizacao))
			return false;
		if (requerEspecialidade == null) {
			if (other.requerEspecialidade != null)
				return false;
		} else if (!requerEspecialidade.equals(other.requerEspecialidade))
			return false;
		if (tratamentoSeriado == null) {
			if (other.tratamentoSeriado != null)
				return false;
		} else if (!tratamentoSeriado.equals(other.tratamentoSeriado))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
