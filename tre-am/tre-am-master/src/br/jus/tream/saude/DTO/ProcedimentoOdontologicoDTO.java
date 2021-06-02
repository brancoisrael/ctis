package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoOdonto;

/**
 * Representa os dados de um {@link ProcedimentoOdonto}.
 * 
 * @author vinicius
 *
 */
public class ProcedimentoOdontologicoDTO implements Serializable {

	private static final long serialVersionUID = 1031247405803933849L;
	private String codigoProcedimento;
	private TabelaCredenciadoDTO tabela;
	private String nome;
	private BigDecimal valor;
	private GrupoProcedimentoDTO grupo;
	private LocalDateTime dataAtualizacao;
	private Integer ativo;
	private Integer prazoCarenciaMinima;

	public ProcedimentoOdontologicoDTO() {
	}

	public ProcedimentoOdontologicoDTO(String codigoProcedimento, Long codTabela, String desc) {
		this.tabela = new TabelaCredenciadoDTO(codTabela);
		this.codigoProcedimento = codigoProcedimento;
		this.nome = desc;
	}

	/**
	 * Responsável por converter um {@link Procedimento} para seu respectivo Dto.
	 * 
	 * @param procedimento que será convertido.
	 */
	public ProcedimentoOdontologicoDTO(ProcedimentoOdonto procedimento) {
		this.codigoProcedimento = procedimento.getProcedimentoPK().getCodigoProcedimento();
		this.tabela = new TabelaCredenciadoDTO(procedimento.getProcedimentoPK().getTabela());
		this.nome = procedimento.getNome();
		this.valor = procedimento.getValor();
		this.grupo = new GrupoProcedimentoDTO(procedimento.getGrupo());
		this.dataAtualizacao = procedimento.getDataAtualizacao();
		this.ativo = procedimento.getProcedimentoAtivo();
		this.prazoCarenciaMinima = procedimento.getPrazoCarencia();

	}

	public String getCodigoProcedimento() {
		return codigoProcedimento;
	}

	public void setCodigoProcedimento(String codigoProcedimento) {
		this.codigoProcedimento = codigoProcedimento;
	}

	public TabelaCredenciadoDTO getTabela() {
		return tabela;
	}

	public void setTabela(TabelaCredenciadoDTO tabela) {
		this.tabela = tabela;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public GrupoProcedimentoDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoProcedimentoDTO grupo) {
		this.grupo = grupo;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getPrazoCarenciaMinima() {
		return prazoCarenciaMinima;
	}

	public void setPrazoCarenciaMinima(Integer prazoCarenciaMinima) {
		this.prazoCarenciaMinima = prazoCarenciaMinima;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((codigoProcedimento == null) ? 0 : codigoProcedimento.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prazoCarenciaMinima == null) ? 0 : prazoCarenciaMinima.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		ProcedimentoOdontologicoDTO other = (ProcedimentoOdontologicoDTO) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (codigoProcedimento == null) {
			if (other.codigoProcedimento != null)
				return false;
		} else if (!codigoProcedimento.equals(other.codigoProcedimento))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prazoCarenciaMinima == null) {
			if (other.prazoCarenciaMinima != null)
				return false;
		} else if (!prazoCarenciaMinima.equals(other.prazoCarenciaMinima))
			return false;
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
