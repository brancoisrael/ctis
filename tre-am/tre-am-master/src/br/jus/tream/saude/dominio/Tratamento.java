package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "TRATAMENTO_SERIADO")
public class Tratamento implements Serializable {

	private static final long serialVersionUID = 6137136831850549608L;
	@Id
	@Column(name = "NUM_TRATAMENTO")
	private Long id;
	@Column(name = "DAT_EMISSAO")
	private LocalDate dataEmissao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SIT_TRATAMENTO")
	private SituacaoTratamento situacaoTratamento;
	@Column(name = "MAT_SERVIDOR")
	private String matricularServidor;
	@Column(name = "COD_DEPEND")
	private Long codigoDependente;
	@Column(name = "DAT_INICIO")
	private LocalDate dataInicio;
	@Column(name = "DAT_FIM")
	private LocalDate dataFim;
	@MapsId("procedimentoPK")
	@JoinColumns({ @JoinColumn(name = "COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO"),
			@JoinColumn(name = "COD_TABELA", referencedColumnName = "COD_TABELA",nullable = true) })
	@ManyToOne
	@Fetch(FetchMode.SELECT)
	private Procedimento procedimento;
	@Column(name = "MAT_MEDICO_PERITO")
	private String matriculaMedicoPerito;
	@Column(name = "QTD_SESSOES_MES")
	private Integer quantidadeSessoesNoMes;
	@Column(name = "OBSERVACAO")
	private String observacao;
	@Column(name = "DAT_ULT_ATUAL")
	private LocalDateTime dataAtualizacao;
	@Column(name = "USR_ULT_ATUAL")
	private String usuarioAtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public SituacaoTratamento getSituacaoTratamento() {
		return situacaoTratamento;
	}

	public void setSituacaoTratamento(SituacaoTratamento situacaoTratamento) {
		this.situacaoTratamento = situacaoTratamento;
	}

	public String getMatricularServidor() {
		return matricularServidor;
	}

	public void setMatricularServidor(String matricularServidor) {
		this.matricularServidor = matricularServidor;
	}

	public Long getCodigoDependente() {
		return codigoDependente;
	}

	public void setCodigoDependente(Long codigoDependente) {
		this.codigoDependente = codigoDependente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public String getMatriculaMedicoPerito() {
		return matriculaMedicoPerito;
	}

	public void setMatriculaMedicoPerito(String matriculaMedicoPerito) {
		this.matriculaMedicoPerito = matriculaMedicoPerito;
	}

	public Integer getQuantidadeSessoesNoMes() {
		return quantidadeSessoesNoMes;
	}

	public void setQuantidadeSessoesNoMes(Integer quantidadeSessoesNoMes) {
		this.quantidadeSessoesNoMes = quantidadeSessoesNoMes;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getUsuarioAtual() {
		return usuarioAtual;
	}

	public void setUsuarioAtual(String usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDependente == null) ? 0 : codigoDependente.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matriculaMedicoPerito == null) ? 0 : matriculaMedicoPerito.hashCode());
		result = prime * result + ((matricularServidor == null) ? 0 : matricularServidor.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
		result = prime * result + ((quantidadeSessoesNoMes == null) ? 0 : quantidadeSessoesNoMes.hashCode());
		result = prime * result + ((situacaoTratamento == null) ? 0 : situacaoTratamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioAtual == null) ? 0 : usuarioAtual.hashCode());
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
		Tratamento other = (Tratamento) obj;
		if (codigoDependente == null) {
			if (other.codigoDependente != null)
				return false;
		} else if (!codigoDependente.equals(other.codigoDependente))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matriculaMedicoPerito == null) {
			if (other.matriculaMedicoPerito != null)
				return false;
		} else if (!matriculaMedicoPerito.equals(other.matriculaMedicoPerito))
			return false;
		if (matricularServidor == null) {
			if (other.matricularServidor != null)
				return false;
		} else if (!matricularServidor.equals(other.matricularServidor))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		if (quantidadeSessoesNoMes == null) {
			if (other.quantidadeSessoesNoMes != null)
				return false;
		} else if (!quantidadeSessoesNoMes.equals(other.quantidadeSessoesNoMes))
			return false;
		if (situacaoTratamento == null) {
			if (other.situacaoTratamento != null)
				return false;
		} else if (!situacaoTratamento.equals(other.situacaoTratamento))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioAtual == null) {
			if (other.usuarioAtual != null)
				return false;
		} else if (!usuarioAtual.equals(other.usuarioAtual))
			return false;
		return true;
	}

}
