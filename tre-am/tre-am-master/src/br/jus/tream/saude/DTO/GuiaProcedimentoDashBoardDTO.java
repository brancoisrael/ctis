package br.jus.tream.saude.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.enumeration.TipoBeneficiario;
import br.jus.tream.saude.util.DateUtil;

/**
 * Representa os dados de um {@link GuiaProcedimento}.
 * 
 * @author vinicius
 *
 */
public class GuiaProcedimentoDashBoardDTO implements Serializable {

	private static final long serialVersionUID = 4370945257181600885L;

	private Long id;
	private List<ProcedimentoDTO> procedimentos = new ArrayList<ProcedimentoDTO>();
	private GuiaDTO guia;
	private Integer quantidade;
	private BigDecimal valor;
	private Integer viaAcesso;
	private Integer video;
	private BigDecimal valorCalculado;
	private TipoBeneficiario tipoBeneficiario;

	public GuiaProcedimentoDashBoardDTO() {
	}

	public GuiaProcedimentoDashBoardDTO(Object[] objeto) {
		Long numeroGuia = objeto[0] != null ? new Long(objeto[0].toString()) : null;
		String anoExercicio = objeto[1] != null ? objeto[1].toString() : null;
		Long idTipoGuia = objeto[2] != null ? new Long(objeto[2].toString()) : null;
		Short idSituacao = objeto[3] != null ? new Short(objeto[3].toString()) : null;
		String descSituacao = objeto[4] != null ? objeto[4].toString() : null;
		LocalDate dataEmissao = objeto[5] != null ? DateUtil.converteData(objeto[5].toString()) : null;
		SituacaoDTO situacao = new SituacaoDTO(idSituacao, descSituacao);
		this.guia = new GuiaDTO(numeroGuia, anoExercicio, dataEmissao, situacao, idTipoGuia);
		this.valor = objeto[6] != null ? new BigDecimal(objeto[6].toString()) : null;
		this.tipoBeneficiario = TipoBeneficiario.findByDescricao(objeto[7].toString());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<ProcedimentoDTO> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentoDTO> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public void addProcedimento(ProcedimentoDTO objeto) {
		this.getProcedimentos().add(objeto);
	}

	public TipoBeneficiario getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(TipoBeneficiario tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

}
