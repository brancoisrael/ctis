package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Procedimento;

/**
 * Representa os dados de um {@link Procedimento}.
 * 
 * @author vinicius
 *
 */
public class ProcedimentoDTO implements Serializable {

	private static final long serialVersionUID = -5364599675224487446L;
	private String codigoProcedimento;
	private TabelaCredenciadoDTO tabela;
	private String nome;
	private BigDecimal valor;
	private EspecialidadeDTO especialidade;
	private PorteDTO porte;
	private Integer requerEspecialidade;
	private Integer requerAutorizacao;
	private Integer quantidade;
	private Integer detalhaProcedimento;
	private Integer procedimentoAtivo;
	private Integer indicaExcecao;
	private Integer tratamentoSeriado;
	private LocalDateTime dataAtualizacao;
	private String antCodigoProcedimento;
	private Integer prazoCarencia;
	private Integer consulta;

	public ProcedimentoDTO() {
	}
	
	public ProcedimentoDTO(String codigoProcedimento, Long codTabela, String desc) {
		this.tabela = new TabelaCredenciadoDTO(codTabela);
		this.codigoProcedimento = codigoProcedimento;
		this.nome = desc;
	}
	
	public ProcedimentoDTO(String codigoProcedimento, Long codTabela, String desc, Integer autorizacao) {
		this.tabela = new TabelaCredenciadoDTO(codTabela);
		this.codigoProcedimento = codigoProcedimento;
		this.nome = desc;
		this.requerAutorizacao = autorizacao;
	}

	/**
	 * Responsável por converter um {@link Procedimento} para seu respectivo Dto.
	 * 
	 * @param procedimento que será convertido.
	 */
	public ProcedimentoDTO(Procedimento procedimento) {
		this.codigoProcedimento = procedimento.getProcedimentoPK().getCodigoProcedimento();
		this.tabela = new TabelaCredenciadoDTO(procedimento.getProcedimentoPK().getTabela());
		this.nome = procedimento.getNome();
		this.valor = procedimento.getValor();
		this.especialidade = procedimento.getEspecialidade() != null
				? new EspecialidadeDTO(procedimento.getEspecialidade())
				: null;
		this.porte = procedimento.getPorte() != null ? new PorteDTO(procedimento.getPorte()) : null;
		this.requerEspecialidade = procedimento.getRequerAutorizacao();
		this.requerAutorizacao = procedimento.getRequerAutorizacao();
		this.quantidade = procedimento.getQuantidade();
		this.detalhaProcedimento = procedimento.getDetalhaProcedimento();
		this.procedimentoAtivo = procedimento.getProcedimentoAtivo();
		this.indicaExcecao = procedimento.getIndicaExcecao();
		this.tratamentoSeriado = procedimento.getTratamentoSeriado();
		this.dataAtualizacao = procedimento.getDataAtualizacao();
		this.antCodigoProcedimento = procedimento.getAntCodigoProcedimento();
		this.prazoCarencia = procedimento.getPrazoCarencia();
		this.consulta = procedimento.getConsulta();
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

	public EspecialidadeDTO getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeDTO especialidade) {
		this.especialidade = especialidade;
	}

	public PorteDTO getPorte() {
		return porte;
	}

	public void setPorte(PorteDTO porte) {
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

	public Integer getProcedimentoAtivo() {
		return procedimentoAtivo;
	}

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

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getAntCodigoProcedimento() {
		return antCodigoProcedimento;
	}

	public void setAntCodigoProcedimento(String antCodigoProcedimento) {
		this.antCodigoProcedimento = antCodigoProcedimento;
	}

	public Integer getPrazoCarencia() {
		return prazoCarencia;
	}

	public void setPrazoCarencia(Integer prazoCarencia) {
		this.prazoCarencia = prazoCarencia;
	}

	public Integer getConsulta() {
		return consulta;
	}

	public void setConsulta(Integer consulta) {
		this.consulta = consulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antCodigoProcedimento == null) ? 0 : antCodigoProcedimento.hashCode());
		result = prime * result + ((codigoProcedimento == null) ? 0 : codigoProcedimento.hashCode());
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((detalhaProcedimento == null) ? 0 : detalhaProcedimento.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((indicaExcecao == null) ? 0 : indicaExcecao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((porte == null) ? 0 : porte.hashCode());
		result = prime * result + ((prazoCarencia == null) ? 0 : prazoCarencia.hashCode());
		result = prime * result + ((procedimentoAtivo == null) ? 0 : procedimentoAtivo.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((requerAutorizacao == null) ? 0 : requerAutorizacao.hashCode());
		result = prime * result + ((requerEspecialidade == null) ? 0 : requerEspecialidade.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		ProcedimentoDTO other = (ProcedimentoDTO) obj;
		if (antCodigoProcedimento == null) {
			if (other.antCodigoProcedimento != null)
				return false;
		} else if (!antCodigoProcedimento.equals(other.antCodigoProcedimento))
			return false;
		if (codigoProcedimento == null) {
			if (other.codigoProcedimento != null)
				return false;
		} else if (!codigoProcedimento.equals(other.codigoProcedimento))
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
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
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
