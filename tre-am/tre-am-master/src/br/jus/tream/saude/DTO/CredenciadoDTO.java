package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Credenciado;

/**
 * Representa os dados da {@link Credenciado}.
 * 
 * @author vinicius
 *
 */
public class CredenciadoDTO implements Serializable {

	private static final long serialVersionUID = 5190068935451993147L;

	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	private String cidade;
	private String uf;
	private String cep;
	private String fax;
	private String email;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private TabelaIdadeDTO tabelaIdade;
	private String cpf;
	private String numeroContrato;
	private String contaCorrente;
	private String tipoCredenciado;
	private TabelaCredenciadoDTO tabela;
	private LocalDate dataValidade;
	private InstituicaoDTO instituicao;
	private LocalDateTime dataAtualizacao;
	private Short contratoRevogado;
	private String numeroProcessoSei;
	private Integer numeroDocumentoSei;
	private Integer numeroDocSeiGestor;
	private LocalDate dataInicioValidade;
	private IsencaoFeedDTO isencaoFed;
	private Integer numeroDocSeiIsencaoFed;
	private InsencaoISSDTO isencaoIss;
	private Integer numeroDocSeiIsencaoIss;
	private BigDecimal aliquotaFed;
	private BigDecimal aliquotaIss;
	private BigDecimal aliquotaIR;
	private BigDecimal aliquotaCsll;
	private BigDecimal aliquotaCofins;
	private BigDecimal aliquitaPisPasep;
	private String usuarioUltimaAtualizacao;
	private String codigoImpostosFederais;
	private String codigoISS;
	private BigDecimal aliquotaIR2;
	private String codigoImpostosFederais2;

	public CredenciadoDTO() {
	}

	/**
	 * Responsável por converter um {@link Credenciado} para seu respectivo Dto.
	 * 
	 * @param credenciado que será convertido.
	 */
	public CredenciadoDTO(Credenciado credenciado) {
		this.id = credenciado.getId();
		this.nome = credenciado.getNome();
		this.endereco = credenciado.getEndereco();
		this.telefone = credenciado.getTelefone();
		this.cidade = credenciado.getCidade();
		this.uf = credenciado.getUf();
		this.cep = credenciado.getCep();
		this.fax = credenciado.getFax();
		this.email = credenciado.getEmail();
		this.dataEntrada = credenciado.getDataEntrada();
		this.dataSaida = credenciado.getDataSaida();
		this.tabelaIdade = credenciado.getTabelaIdade() != null ? new TabelaIdadeDTO(credenciado.getTabelaIdade())
				: null;
		this.cpf = credenciado.getCpf();
		this.numeroContrato = credenciado.getNumeroContrato();
		this.contaCorrente = credenciado.getContaCorrente();
		this.tipoCredenciado = credenciado.getTipoCredenciado();
		this.tabela = credenciado.getTabela() != null ? new TabelaCredenciadoDTO(credenciado.getTabela()) : null;
		this.dataValidade = credenciado.getDataValidade();
		this.instituicao = credenciado.getInstituicao() != null ? new InstituicaoDTO(credenciado.getInstituicao())
				: null;
		this.dataAtualizacao = credenciado.getDataAtualizacao();
		this.contratoRevogado = credenciado.getContratoRevogado();
		this.numeroProcessoSei = credenciado.getNumeroProcessoSei();
		this.numeroDocumentoSei = credenciado.getNumeroDocumentoSei();
		this.numeroDocSeiGestor = credenciado.getNumeroDocSeiGestor();
		this.dataInicioValidade = credenciado.getDataInicioValidade();
		this.isencaoFed = credenciado.getIsencaoFed() != null ? new IsencaoFeedDTO(credenciado.getIsencaoFed()) : null;
		this.numeroDocSeiIsencaoFed = credenciado.getNumeroDocSeiIsencaoFed();
		this.isencaoIss = credenciado.getIsencaoIss() != null ? new InsencaoISSDTO(credenciado.getIsencaoIss()) : null;
		this.numeroDocSeiIsencaoIss = credenciado.getNumeroDocSeiIsencaoIss();
		this.aliquotaFed = credenciado.getAliquotaFed();
		this.aliquotaIss = credenciado.getAliquotaIss();
		this.aliquotaIR = credenciado.getAliquotaIR();
		this.aliquotaCsll = credenciado.getAliquotaCsll();
		this.aliquotaCofins = credenciado.getAliquotaCofins();
		this.aliquitaPisPasep = credenciado.getAliquitaPisPasep();
		this.usuarioUltimaAtualizacao = credenciado.getUsuarioUltimaAtualizacao();
		this.codigoImpostosFederais = credenciado.getCodigoImpostosFederais();
		this.codigoISS = credenciado.getCodigoISS();
		this.aliquotaIR2 = credenciado.getAliquotaIR2();
		this.codigoImpostosFederais2 = credenciado.getCodigoImpostosFederais2();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public TabelaIdadeDTO getTabelaIdade() {
		return tabelaIdade;
	}

	public void setTabelaIdade(TabelaIdadeDTO tabelaIdade) {
		this.tabelaIdade = tabelaIdade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getTipoCredenciado() {
		return tipoCredenciado;
	}

	public void setTipoCredenciado(String tipoCredenciado) {
		this.tipoCredenciado = tipoCredenciado;
	}

	public TabelaCredenciadoDTO getTabela() {
		return tabela;
	}

	public void setTabela(TabelaCredenciadoDTO tabela) {
		this.tabela = tabela;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public InstituicaoDTO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoDTO instituicao) {
		this.instituicao = instituicao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Short getContratoRevogado() {
		return contratoRevogado;
	}

	public void setContratoRevogado(Short contratoRevogado) {
		this.contratoRevogado = contratoRevogado;
	}

	public String getNumeroProcessoSei() {
		return numeroProcessoSei;
	}

	public void setNumeroProcessoSei(String numeroProcessoSei) {
		this.numeroProcessoSei = numeroProcessoSei;
	}

	public Integer getNumeroDocumentoSei() {
		return numeroDocumentoSei;
	}

	public void setNumeroDocumentoSei(Integer numeroDocumentoSei) {
		this.numeroDocumentoSei = numeroDocumentoSei;
	}

	public Integer getNumeroDocSeiGestor() {
		return numeroDocSeiGestor;
	}

	public void setNumeroDocSeiGestor(Integer numeroDocSeiGestor) {
		this.numeroDocSeiGestor = numeroDocSeiGestor;
	}

	public LocalDate getDataInicioValidade() {
		return dataInicioValidade;
	}

	public void setDataInicioValidade(LocalDate dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}

	public IsencaoFeedDTO getIsencaoFed() {
		return isencaoFed;
	}

	public void setIsencaoFed(IsencaoFeedDTO isencaoFed) {
		this.isencaoFed = isencaoFed;
	}

	public Integer getNumeroDocSeiIsencaoFed() {
		return numeroDocSeiIsencaoFed;
	}

	public void setNumeroDocSeiIsencaoFed(Integer numeroDocSeiIsencaoFed) {
		this.numeroDocSeiIsencaoFed = numeroDocSeiIsencaoFed;
	}

	public InsencaoISSDTO getIsencaoIss() {
		return isencaoIss;
	}

	public void setIsencaoIss(InsencaoISSDTO isencaoIss) {
		this.isencaoIss = isencaoIss;
	}

	public Integer getNumeroDocSeiIsencaoIss() {
		return numeroDocSeiIsencaoIss;
	}

	public void setNumeroDocSeiIsencaoIss(Integer numeroDocSeiIsencaoIss) {
		this.numeroDocSeiIsencaoIss = numeroDocSeiIsencaoIss;
	}

	public BigDecimal getAliquotaFed() {
		return aliquotaFed;
	}

	public void setAliquotaFed(BigDecimal aliquotaFed) {
		this.aliquotaFed = aliquotaFed;
	}

	public BigDecimal getAliquotaIss() {
		return aliquotaIss;
	}

	public void setAliquotaIss(BigDecimal aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public BigDecimal getAliquotaIR() {
		return aliquotaIR;
	}

	public void setAliquotaIR(BigDecimal aliquotaIR) {
		this.aliquotaIR = aliquotaIR;
	}

	public BigDecimal getAliquotaCsll() {
		return aliquotaCsll;
	}

	public void setAliquotaCsll(BigDecimal aliquotaCsll) {
		this.aliquotaCsll = aliquotaCsll;
	}

	public BigDecimal getAliquotaCofins() {
		return aliquotaCofins;
	}

	public void setAliquotaCofins(BigDecimal aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}

	public BigDecimal getAliquitaPisPasep() {
		return aliquitaPisPasep;
	}

	public void setAliquitaPisPasep(BigDecimal aliquitaPisPasep) {
		this.aliquitaPisPasep = aliquitaPisPasep;
	}

	public String getUsuarioUltimaAtualizacao() {
		return usuarioUltimaAtualizacao;
	}

	public void setUsuarioUltimaAtualizacao(String usuarioUltimaAtualizacao) {
		this.usuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
	}

	public String getCodigoImpostosFederais() {
		return codigoImpostosFederais;
	}

	public void setCodigoImpostosFederais(String codigoImpostosFederais) {
		this.codigoImpostosFederais = codigoImpostosFederais;
	}

	public String getCodigoISS() {
		return codigoISS;
	}

	public void setCodigoISS(String codigoISS) {
		this.codigoISS = codigoISS;
	}

	public BigDecimal getAliquotaIR2() {
		return aliquotaIR2;
	}

	public void setAliquotaIR2(BigDecimal aliquotaIR2) {
		this.aliquotaIR2 = aliquotaIR2;
	}

	public String getCodigoImpostosFederais2() {
		return codigoImpostosFederais2;
	}

	public void setCodigoImpostosFederais2(String codigoImpostosFederais2) {
		this.codigoImpostosFederais2 = codigoImpostosFederais2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aliquitaPisPasep == null) ? 0 : aliquitaPisPasep.hashCode());
		result = prime * result + ((aliquotaCofins == null) ? 0 : aliquotaCofins.hashCode());
		result = prime * result + ((aliquotaCsll == null) ? 0 : aliquotaCsll.hashCode());
		result = prime * result + ((aliquotaFed == null) ? 0 : aliquotaFed.hashCode());
		result = prime * result + ((aliquotaIR == null) ? 0 : aliquotaIR.hashCode());
		result = prime * result + ((aliquotaIR2 == null) ? 0 : aliquotaIR2.hashCode());
		result = prime * result + ((aliquotaIss == null) ? 0 : aliquotaIss.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((codigoISS == null) ? 0 : codigoISS.hashCode());
		result = prime * result + ((codigoImpostosFederais == null) ? 0 : codigoImpostosFederais.hashCode());
		result = prime * result + ((codigoImpostosFederais2 == null) ? 0 : codigoImpostosFederais2.hashCode());
		result = prime * result + ((contaCorrente == null) ? 0 : contaCorrente.hashCode());
		result = prime * result + ((contratoRevogado == null) ? 0 : contratoRevogado.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result + ((dataInicioValidade == null) ? 0 : dataInicioValidade.hashCode());
		result = prime * result + ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((isencaoFed == null) ? 0 : isencaoFed.hashCode());
		result = prime * result + ((isencaoIss == null) ? 0 : isencaoIss.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroContrato == null) ? 0 : numeroContrato.hashCode());
		result = prime * result + ((numeroDocSeiGestor == null) ? 0 : numeroDocSeiGestor.hashCode());
		result = prime * result + ((numeroDocSeiIsencaoFed == null) ? 0 : numeroDocSeiIsencaoFed.hashCode());
		result = prime * result + ((numeroDocSeiIsencaoIss == null) ? 0 : numeroDocSeiIsencaoIss.hashCode());
		result = prime * result + ((numeroDocumentoSei == null) ? 0 : numeroDocumentoSei.hashCode());
		result = prime * result + ((numeroProcessoSei == null) ? 0 : numeroProcessoSei.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
		result = prime * result + ((tabelaIdade == null) ? 0 : tabelaIdade.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipoCredenciado == null) ? 0 : tipoCredenciado.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((usuarioUltimaAtualizacao == null) ? 0 : usuarioUltimaAtualizacao.hashCode());
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
		CredenciadoDTO other = (CredenciadoDTO) obj;
		if (aliquitaPisPasep == null) {
			if (other.aliquitaPisPasep != null)
				return false;
		} else if (!aliquitaPisPasep.equals(other.aliquitaPisPasep))
			return false;
		if (aliquotaCofins == null) {
			if (other.aliquotaCofins != null)
				return false;
		} else if (!aliquotaCofins.equals(other.aliquotaCofins))
			return false;
		if (aliquotaCsll == null) {
			if (other.aliquotaCsll != null)
				return false;
		} else if (!aliquotaCsll.equals(other.aliquotaCsll))
			return false;
		if (aliquotaFed == null) {
			if (other.aliquotaFed != null)
				return false;
		} else if (!aliquotaFed.equals(other.aliquotaFed))
			return false;
		if (aliquotaIR == null) {
			if (other.aliquotaIR != null)
				return false;
		} else if (!aliquotaIR.equals(other.aliquotaIR))
			return false;
		if (aliquotaIR2 == null) {
			if (other.aliquotaIR2 != null)
				return false;
		} else if (!aliquotaIR2.equals(other.aliquotaIR2))
			return false;
		if (aliquotaIss == null) {
			if (other.aliquotaIss != null)
				return false;
		} else if (!aliquotaIss.equals(other.aliquotaIss))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codigoISS == null) {
			if (other.codigoISS != null)
				return false;
		} else if (!codigoISS.equals(other.codigoISS))
			return false;
		if (codigoImpostosFederais == null) {
			if (other.codigoImpostosFederais != null)
				return false;
		} else if (!codigoImpostosFederais.equals(other.codigoImpostosFederais))
			return false;
		if (codigoImpostosFederais2 == null) {
			if (other.codigoImpostosFederais2 != null)
				return false;
		} else if (!codigoImpostosFederais2.equals(other.codigoImpostosFederais2))
			return false;
		if (contaCorrente == null) {
			if (other.contaCorrente != null)
				return false;
		} else if (!contaCorrente.equals(other.contaCorrente))
			return false;
		if (contratoRevogado == null) {
			if (other.contratoRevogado != null)
				return false;
		} else if (!contratoRevogado.equals(other.contratoRevogado))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataInicioValidade == null) {
			if (other.dataInicioValidade != null)
				return false;
		} else if (!dataInicioValidade.equals(other.dataInicioValidade))
			return false;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (dataValidade == null) {
			if (other.dataValidade != null)
				return false;
		} else if (!dataValidade.equals(other.dataValidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (isencaoFed == null) {
			if (other.isencaoFed != null)
				return false;
		} else if (!isencaoFed.equals(other.isencaoFed))
			return false;
		if (isencaoIss == null) {
			if (other.isencaoIss != null)
				return false;
		} else if (!isencaoIss.equals(other.isencaoIss))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroContrato == null) {
			if (other.numeroContrato != null)
				return false;
		} else if (!numeroContrato.equals(other.numeroContrato))
			return false;
		if (numeroDocSeiGestor == null) {
			if (other.numeroDocSeiGestor != null)
				return false;
		} else if (!numeroDocSeiGestor.equals(other.numeroDocSeiGestor))
			return false;
		if (numeroDocSeiIsencaoFed == null) {
			if (other.numeroDocSeiIsencaoFed != null)
				return false;
		} else if (!numeroDocSeiIsencaoFed.equals(other.numeroDocSeiIsencaoFed))
			return false;
		if (numeroDocSeiIsencaoIss == null) {
			if (other.numeroDocSeiIsencaoIss != null)
				return false;
		} else if (!numeroDocSeiIsencaoIss.equals(other.numeroDocSeiIsencaoIss))
			return false;
		if (numeroDocumentoSei == null) {
			if (other.numeroDocumentoSei != null)
				return false;
		} else if (!numeroDocumentoSei.equals(other.numeroDocumentoSei))
			return false;
		if (numeroProcessoSei == null) {
			if (other.numeroProcessoSei != null)
				return false;
		} else if (!numeroProcessoSei.equals(other.numeroProcessoSei))
			return false;
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		if (tabelaIdade == null) {
			if (other.tabelaIdade != null)
				return false;
		} else if (!tabelaIdade.equals(other.tabelaIdade))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoCredenciado == null) {
			if (other.tipoCredenciado != null)
				return false;
		} else if (!tipoCredenciado.equals(other.tipoCredenciado))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (usuarioUltimaAtualizacao == null) {
			if (other.usuarioUltimaAtualizacao != null)
				return false;
		} else if (!usuarioUltimaAtualizacao.equals(other.usuarioUltimaAtualizacao))
			return false;
		return true;
	}

}
