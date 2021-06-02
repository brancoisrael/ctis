package br.jus.tream.saude.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BENEFICIARIO")
public class Beneficiario {

	@Id
	@SequenceGenerator(name = "BENEFICIARIO_SEQ_GENERATION", sequenceName = "SEQ_BENEFICIARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BENEFICIARIO_SEQ_GENERATION")
	@Column(name = "ID_BENEFICIARIO")
	private Long id;
	@Column(name = "MAT_SERVIDOR")
	private String matricula;
	@Column(name = "COD_DEPEND")
	private Integer codigoDependente;
	@Column(name = "NOME", nullable = true, length = 60)
	private String nome;
	@Column(name = "FUNCAO", nullable = true, length = 15)
	private String funcao;
	@Column(name = "EXCLUIDO", nullable = true, length = 1)
	private String excluido;
	@Column(name = "CARENCIA", nullable = true, length = 1)
	private String carencia;
	@Column(name = "SUSPENSO", nullable = true, length = 1)
	private String suspenso;
	@Column(name = "DAT_INICIO")
	private LocalDate dataInicio;
	@Column(name = "DAT_FIM")
	private LocalDate dataFim;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO_DEPEND")
	private TipoDependente tipoDependente;
	@Column(name = "DAT_NASC")
	private LocalDate dataNascimento;
	@Column(name = "E_MAIL", nullable = true, length = 50)
	private String email;
	@Column(name = "DAT_ULT_ATUAL ")
	private LocalDate dataUltimaAtualizacao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SIT_FUNC")
	private SituacaoFuncional situacaoFuncional;
	@Column(name = "DAT_CARENCIA ")
	private LocalDate dataCarencia;
	@Column(name = "SEXO", nullable = false, length = 1)
	private String sexo;
	@Column(name = "UF", nullable = false, length = 2)
	private String uf;
	@Column(name = "SALDO")
	private BigDecimal saldo;
	@Column(name = "NOM_ORGAO_ORIGEM", nullable = true, length = 100)
	private String orgaoOrigem;
	@Column(name = "CD_NIVEL")
	private Short nivel;
	@Column(name = "BLOQUEIO", nullable = true, length = 1)
	private String bloqueio;
	@Column(name = "PRAZO_CARENCIA_EXTRA")
	private Short prazoCarencia;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getCodigoDependente() {
		return codigoDependente;
	}

	public void setCodigoDependente(Integer codigoDependente) {
		this.codigoDependente = codigoDependente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getExcluido() {
		return excluido;
	}

	public void setExcluido(String excluido) {
		this.excluido = excluido;
	}

	public String getCarencia() {
		return carencia;
	}

	public void setCarencia(String carencia) {
		this.carencia = carencia;
	}

	public String getSuspenso() {
		return suspenso;
	}

	public void setSuspenso(String suspenso) {
		this.suspenso = suspenso;
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

	public TipoDependente getTipoDependente() {
		return tipoDependente;
	}

	public void setTipoDependente(TipoDependente tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public SituacaoFuncional getSituacaoFuncional() {
		return situacaoFuncional;
	}

	public void setSituacaoFuncional(SituacaoFuncional situacaoFuncional) {
		this.situacaoFuncional = situacaoFuncional;
	}

	public LocalDate getDataCarencia() {
		return dataCarencia;
	}

	public void setDataCarencia(LocalDate dataCarencia) {
		this.dataCarencia = dataCarencia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getOrgaoOrigem() {
		return orgaoOrigem;
	}

	public void setOrgaoOrigem(String orgaoOrigem) {
		this.orgaoOrigem = orgaoOrigem;
	}

	public Short getNivel() {
		return nivel;
	}

	public void setNivel(Short nivel) {
		this.nivel = nivel;
	}

	public String getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}

	public Short getPrazoCarencia() {
		return prazoCarencia;
	}

	public void setPrazoCarencia(Short prazoCarencia) {
		this.prazoCarencia = prazoCarencia;
	}

}
