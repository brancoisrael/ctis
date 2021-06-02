package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.jus.tream.saude.dominio.Instituicao;

/**
 * Representa os dados da {@link Instituicao}.
 * 
 * @author vinicius
 *
 */
public class InstituicaoDTO implements Serializable {

	private static final long serialVersionUID = 1707009715203521224L;

	private Long id;
	private String nome;
	private String sigla;
	private String endereco;
	private String cidade;
	private String uf;
	private String cep;
	private String telefone1;
	private String telefone2;
	private String fax;
	private String email;
	private String cpf;
	private TabelaIdadeDTO tabelaIdade;
	private String numeroContaCorrente;
	private Short tipoMedica;
	private Short tipoOdonto;
	private LocalDateTime dataAtualizacao;
	private Integer numeroDocumentoSeiBancario;

	public InstituicaoDTO() {
	}

	/**
	 * Responsável por converter uma {@link Instituicao} para seu respectivo Dto.
	 * 
	 * @param instituicao que será convertida.
	 */
	public InstituicaoDTO(Instituicao instituicao) {
		this.id = instituicao.getId();
		this.nome = instituicao.getNome();
		this.sigla = instituicao.getSigla();
		this.endereco = instituicao.getEndereco();
		this.cidade = instituicao.getCidade();
		this.uf = instituicao.getUf();
		this.cep = instituicao.getCep();
		this.telefone1 = instituicao.getTelefone1();
		this.telefone2 = instituicao.getTelefone2();
		this.fax = instituicao.getFax();
		this.email = instituicao.getEmail();
		this.cpf = instituicao.getCpf();
		this.tabelaIdade = instituicao.getTabelaIdade() != null ? new TabelaIdadeDTO(instituicao.getTabelaIdade())
				: null;
		this.numeroContaCorrente = instituicao.getNumeroContaCorrente();
		this.tipoMedica = instituicao.getTipoMedica();
		this.tipoOdonto = instituicao.getTipoOdonto();
		this.dataAtualizacao = instituicao.getDataAtualizacao();
		this.numeroDocumentoSeiBancario = instituicao.getNumeroDocumentoSeiBancario();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TabelaIdadeDTO getTabelaIdade() {
		return tabelaIdade;
	}

	public void setTabelaIdade(TabelaIdadeDTO tabelaIdade) {
		this.tabelaIdade = tabelaIdade;
	}

	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public Short getTipoMedica() {
		return tipoMedica;
	}

	public void setTipoMedica(Short tipoMedica) {
		this.tipoMedica = tipoMedica;
	}

	public Short getTipoOdonto() {
		return tipoOdonto;
	}

	public void setTipoOdonto(Short tipoOdonto) {
		this.tipoOdonto = tipoOdonto;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getNumeroDocumentoSeiBancario() {
		return numeroDocumentoSeiBancario;
	}

	public void setNumeroDocumentoSeiBancario(Integer numeroDocumentoSeiBancario) {
		this.numeroDocumentoSeiBancario = numeroDocumentoSeiBancario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroContaCorrente == null) ? 0 : numeroContaCorrente.hashCode());
		result = prime * result + ((numeroDocumentoSeiBancario == null) ? 0 : numeroDocumentoSeiBancario.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((tabelaIdade == null) ? 0 : tabelaIdade.hashCode());
		result = prime * result + ((telefone1 == null) ? 0 : telefone1.hashCode());
		result = prime * result + ((telefone2 == null) ? 0 : telefone2.hashCode());
		result = prime * result + ((tipoMedica == null) ? 0 : tipoMedica.hashCode());
		result = prime * result + ((tipoOdonto == null) ? 0 : tipoOdonto.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		InstituicaoDTO other = (InstituicaoDTO) obj;
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroContaCorrente == null) {
			if (other.numeroContaCorrente != null)
				return false;
		} else if (!numeroContaCorrente.equals(other.numeroContaCorrente))
			return false;
		if (numeroDocumentoSeiBancario == null) {
			if (other.numeroDocumentoSeiBancario != null)
				return false;
		} else if (!numeroDocumentoSeiBancario.equals(other.numeroDocumentoSeiBancario))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tabelaIdade == null) {
			if (other.tabelaIdade != null)
				return false;
		} else if (!tabelaIdade.equals(other.tabelaIdade))
			return false;
		if (telefone1 == null) {
			if (other.telefone1 != null)
				return false;
		} else if (!telefone1.equals(other.telefone1))
			return false;
		if (telefone2 == null) {
			if (other.telefone2 != null)
				return false;
		} else if (!telefone2.equals(other.telefone2))
			return false;
		if (tipoMedica == null) {
			if (other.tipoMedica != null)
				return false;
		} else if (!tipoMedica.equals(other.tipoMedica))
			return false;
		if (tipoOdonto == null) {
			if (other.tipoOdonto != null)
				return false;
		} else if (!tipoOdonto.equals(other.tipoOdonto))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

}
