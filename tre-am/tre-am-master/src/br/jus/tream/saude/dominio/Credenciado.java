package br.jus.tream.saude.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.jus.tream.saude.enumeration.InsencaoISS;
import br.jus.tream.saude.enumeration.IsencaoFeed;

/**
 * 
 * @author vinicius
 *
 */
@Entity
@Table(name = "CREDENCIADO")
public class Credenciado implements Serializable {

	private static final long serialVersionUID = 1050496398261239009L;

	@Id
	@Column(name = "COD_CREDENCIADO")
	private Long id;
	@Column(name = "NOM_CREDENCIADO", nullable = true, length = 60)
	private String nome;
	@Column(name = "DES_ENDERECO", nullable = true, length = 70)
	private String endereco;
	@Column(name = "NUM_TEL", nullable = true, length = 12)
	private String telefone;
	@Column(name = "NOM_CIDADE", nullable = true, length = 50)
	private String cidade;
	@Column(name = "SGL_UF", nullable = true, length = 2)
	private String uf;
	@Column(name = "NUM_CEP", nullable = true, length = 9)
	private String cep;
	@Column(name = "NUM_FAX", nullable = true, length = 12)
	private String fax;
	@Column(name = "EMAIL", nullable = true, length = 70)
	private String email;
	@Column(name = "DAT_ENTRADA", nullable = true)
	private LocalDate dataEntrada;
	@Column(name = "DAT_SAIDA", nullable = true)
	private LocalDate dataSaida;
	@MapsId("tabelaIdadePK")
	@JoinColumns({ @JoinColumn(name = "CD", referencedColumnName = "CD", nullable = true),
			@JoinColumn(name = "CD_BCO", referencedColumnName = "CD_BCO", nullable = true) })
	@ManyToOne
	@Fetch(FetchMode.SELECT)
	private TabelaIdade tabelaIdade;
	@Column(name = "CGC_CPF", nullable = true, length = 14)
	private String cpf;
	@Column(name = "NUM_CONTRATO", nullable = true, length = 20)
	private String numeroContrato;
	@Column(name = "NUM_CONTA_CORRENTE", nullable = true, length = 12)
	private String contaCorrente;
	@Column(name = "TIP_CREDENCIADO", nullable = true, length = 1)
	private String tipoCredenciado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TABELA", nullable = false)
	private TabelaCredenciado tabela;
	@Column(name = "DAT_VALIDADE_CONTRATO", nullable = true)
	private LocalDate dataValidade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_INSTITUICAO", nullable = false)
	private Instituicao instituicao;
	@Column(name = "DAT_ULT_ATUAL", nullable = false)
	private LocalDateTime dataAtualizacao;
	@Column(name = "CONTRATO_REVOGADO", nullable = false)
	private Short contratoRevogado;
	@Column(name = "NUM_PROCESSO", nullable = true, length = 30)
	private String numeroProcessoSei;
	@Column(name = "NUM_DOC_SEI", nullable = true)
	private Integer numeroDocumentoSei;
	@Column(name = "NUM_DOC_SEI_GESTOR", nullable = true)
	private Integer numeroDocSeiGestor;
	@Column(name = "DAT_INICIO_VALIDADE", nullable = true)
	private LocalDate dataInicioValidade;
	@Enumerated(EnumType.STRING)
	@Column(name = "ISENCAO_FED", nullable = true, length = 1)
	private IsencaoFeed isencaoFed;
	@Column(name = "NUM_DOC_SEI_ISENCAO_FED", nullable = true)
	private Integer numeroDocSeiIsencaoFed;
	@Enumerated(EnumType.STRING)
	@Column(name = "ISENCAO_ISS")
	private InsencaoISS isencaoIss;
	@Column(name = "NUM_DOC_SEI_ISENCAO_ISS", nullable = true)
	private Integer numeroDocSeiIsencaoIss;
	@Column(name = "ALIQ_FED", nullable = true)
	private BigDecimal aliquotaFed;
	@Column(name = "ALIQ_ISS", nullable = true)
	private BigDecimal aliquotaIss;
	@Column(name = "ALIQ_IR", nullable = true)
	private BigDecimal aliquotaIR;
	@Column(name = "ALIQ_CSLL", nullable = true)
	private BigDecimal aliquotaCsll;
	@Column(name = "ALIQ_COFINS", nullable = true)
	private BigDecimal aliquotaCofins;
	@Column(name = "ALIQ_PIS_PASEP", nullable = true)
	private BigDecimal aliquitaPisPasep;
	@Column(name = "USR_ULT_ATUAL", nullable = true, length = 15)
	private String usuarioUltimaAtualizacao;
	@Column(name = "COD_IMPOSTOS_FEDERAIS", nullable = true, length = 6)
	private String codigoImpostosFederais;
	@Column(name = "COD_ISS", nullable = true, length = 6)
	private String codigoISS;
	@Column(name = "ALIQ_IR2", nullable = true)
	private BigDecimal aliquotaIR2;
	@Column(name = "COD_IMPOSTOS_FEDERAIS2", nullable = true, length = 6)
	private String codigoImpostosFederais2;

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

	public TabelaIdade getTabelaIdade() {
		return tabelaIdade;
	}

	public void setTabelaIdade(TabelaIdade tabelaIdade) {
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

	public TabelaCredenciado getTabela() {
		return tabela;
	}

	public void setTabela(TabelaCredenciado tabela) {
		this.tabela = tabela;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
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

	public IsencaoFeed getIsencaoFed() {
		return isencaoFed;
	}

	public void setIsencaoFed(IsencaoFeed isencaoFed) {
		this.isencaoFed = isencaoFed;
	}

	public Integer getNumeroDocSeiIsencaoFed() {
		return numeroDocSeiIsencaoFed;
	}

	public void setNumeroDocSeiIsencaoFed(Integer numeroDocSeiIsencaoFed) {
		this.numeroDocSeiIsencaoFed = numeroDocSeiIsencaoFed;
	}

	public InsencaoISS getIsencaoIss() {
		return isencaoIss;
	}

	public void setIsencaoIss(InsencaoISS isencaoIss) {
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
		Credenciado other = (Credenciado) obj;
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
		if (isencaoFed != other.isencaoFed)
			return false;
		if (isencaoIss != other.isencaoIss)
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
