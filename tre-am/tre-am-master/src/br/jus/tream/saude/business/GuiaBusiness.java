package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import br.jus.tream.saude.DAO.BeneficiarioDAOImpl;
import br.jus.tream.saude.DAO.GuiaDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.dominio.Beneficiario;
import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.Situacao;
import br.jus.tream.saude.dominio.TipoGuia;
import br.jus.tream.saude.enumeration.ClassificacaoTipoGuia;
import br.jus.tream.saude.enumeration.SituacaoGuia;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Guia}.
 * 
 * @author vinicius
 *
 */
public class GuiaBusiness {

	private static GuiaBusiness bo;

	public static GuiaBusiness getInstance() {
		if (bo == null) {
			bo = new GuiaBusiness();
		}
		return bo;
	}

	/**
	 * @see GuiaDAOImpl#inserir(Guia)
	 */
	public int inserir(Guia guia) throws Exception {
		Long id = GuiaDAOImpl.getInstance().getSequence();
		guia.getGuiaPK().setNumeroGuia(id);
		return GuiaDAOImpl.getInstance().inserir(guia);
	}

	/**
	 * @see GuiaDAOImpl#inserir(Guia)
	 */
	public int alterar(Guia guia) throws Exception {
		return GuiaDAOImpl.getInstance().alterar(guia);
	}

	/**
	 * @see GuiaDAOImpl#remover(Guia)
	 */
	public int remover(Guia guia) throws Exception {
		return GuiaDAOImpl.getInstance().remover(guia);
	}

	/**
	 * @throws Exception 
	 * @see GuiaDAOImpl#findAll()
	 */
	public List<Guia> findAll(Pagination pagination) throws Exception {
		pagination.setProperties(getTotalGuias().intValue());
		return GuiaDAOImpl.getInstance().findAll(pagination);
	}

	/**
	 * @see GuiaDAOImpl#findById(GuiaPK)
	 */
	public Guia getBean(GuiaPK guia) {
		return GuiaDAOImpl.getInstance().findById(guia);
	}
	
	/**
	 * @throws Exception 
	 * @see GuiaDAOImpl#findGuiasDaCredenciada(Long)
	 */
	public List<Guia> findGuiasDaCredenciada(Long idCredenciada, Pagination pagination) throws Exception {
		pagination.setProperties(getTotalGuiasDaCredenciada(idCredenciada).intValue());
		return GuiaDAOImpl.getInstance().findGuiasDaCredenciada(idCredenciada, pagination);
	}
	
	/**
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#countGuiasDaCredenciada(Long)}
	 */
	public Long getTotalGuiasDaCredenciada(Long idCredenciada) throws Exception {
		return GuiaDAOImpl.getInstance().countGuiasDaCredenciada(idCredenciada);
	}
	
	/**
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#countGuias()}
	 */
	public Long getTotalGuias() throws Exception {
		return GuiaDAOImpl.getInstance().countGuias();
	}
	
	/**
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#totalGuiasAnoMes(YearMonth)}
	 */
	public Long getTotalGuiasAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception {
		return GuiaDAOImpl.getInstance().totalGuiasAnoMes(anoMes, idCredenciada, classificacao);
	}
	
	/**Recupera o total de {@link Guia}(s) autorizadas
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#findTotalGuiasPorSituacaoAnoMes(YearMonth, Long, SituacaoGuia...)
	 */
	public Long getTotalGuiasAutorizadas(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception {
		return GuiaDAOImpl.getInstance().findTotalGuiasPorSituacaoAnoMes(anoMes, idCredenciada, classificacao, SituacaoGuia.FATURADA,
				SituacaoGuia.ANALISADA, SituacaoGuia.PAGA, SituacaoGuia.AUTORIZADA);
	}

	/**Recupera o total de {@link Guia}(s) em autorização
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#findTotalGuiasPorSituacaoAnoMes(YearMonth, Long, SituacaoGuia...)
	 */
	public Long getTotalGuiasEmAutorizacao(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception {
		return GuiaDAOImpl.getInstance().findTotalGuiasPorSituacaoAnoMes(anoMes, idCredenciada, classificacao, SituacaoGuia.EM_ANALISE,
				SituacaoGuia.EM_ABERTO, SituacaoGuia.EM_AUTORIZACAO);
	}

	/**Recupera o total de {@link Guia}(s) canceladas
	 * @throws Exception 
	 * @see {@link GuiaDAOImpl#findTotalGuiasPorSituacaoAnoMes(YearMonth, Long, SituacaoGuia...)
	 */
	public Long getTotalGuiasCanceladas(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception {
		return GuiaDAOImpl.getInstance().findTotalGuiasPorSituacaoAnoMes(anoMes, idCredenciada, classificacao,
				SituacaoGuia.REJEITADA, SituacaoGuia.CANCELADA);
	}

	public Guia buildGuiaEditar(Guia guia, boolean requerAutorizacao, BigDecimal valorTotalGuia, FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) throws Exception {
		
		//verifica situacao
		Situacao situacao = SituacaoBusiness.getInstance().retornaSituacao(requerAutorizacao);
		//verifica situacao
		
		guia.setTotal(valorTotalGuia);
		guia.setSituacao(situacao);
		
		guia.setUrgencia(frmGuiaClinicaLaboratorialDTO.getUrgencia() == null ? false : frmGuiaClinicaLaboratorialDTO.getUrgencia());
		guia.setApartamento(frmGuiaClinicaLaboratorialDTO.getApartamento() == null ? false : frmGuiaClinicaLaboratorialDTO.getApartamento());
		guia.setInternacao(frmGuiaClinicaLaboratorialDTO.getInternacao() == null ? false : frmGuiaClinicaLaboratorialDTO.getInternacao());
		
		return guia;
	}
	public Situacao retornaSituacaoGuia(boolean requerAutorizacao, boolean guiaMedica) {
		Situacao situacao = new Situacao();
		if (guiaMedica) {
			if (requerAutorizacao) {
				situacao.setId((short)3);
			} else {
				situacao.setId((short)7);//EM AUTORIZACAO
			}
		} else {
			situacao.setId((short)8);
		}
		return situacao;
	}
	public Guia buildNovaGuia(Guia guia, BigDecimal valorTotalGuia,
			FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO, Long idTipoGuia, Credenciado credenciado, boolean requerAutorizacao, boolean guiaMedica) throws Exception {
		GuiaPK guiaPK = GuiaBusiness.getInstance().buildGuiaPK(idTipoGuia); 
		guia = new Guia();
		guia.setGuiaPK(guiaPK);
		
		//verifica situacao
		TipoGuia t = TipoGuiaBusiness.getInstance().findById(idTipoGuia);
		
		guia.setCredenciado(credenciado);
		guia.setDataEmissao(LocalDate.now());
		guia.setTotal(valorTotalGuia);
		guia.setMatriculaServidor(frmGuiaClinicaLaboratorialDTO.getMatriculaServidor());			
		guia.setUrgencia(frmGuiaClinicaLaboratorialDTO.getUrgencia() == null ? false : frmGuiaClinicaLaboratorialDTO.getUrgencia());
		guia.setApartamento(frmGuiaClinicaLaboratorialDTO.getApartamento() == null ? false : frmGuiaClinicaLaboratorialDTO.getApartamento());
		guia.setInternacao(frmGuiaClinicaLaboratorialDTO.getInternacao() == null ? false : frmGuiaClinicaLaboratorialDTO.getInternacao());
		guia.setApartamento(false);
		guia.setInternacao(false);
		guia.setDespesaHospitalar(false);
		guia.setCusteio(t.getCusteio());
		guia.setSituacao(retornaSituacaoGuia(requerAutorizacao, guiaMedica));
		
		Beneficiario beneficiarioServidor = BeneficiarioDAOImpl.getInstance().findTitular(frmGuiaClinicaLaboratorialDTO.getMatriculaServidor());
		Beneficiario beneficiario;
		if (frmGuiaClinicaLaboratorialDTO.getCodigoDependente() != null) {
			beneficiario = BeneficiarioDAOImpl.getInstance().findDependente(frmGuiaClinicaLaboratorialDTO.getMatriculaServidor(), frmGuiaClinicaLaboratorialDTO.getCodigoDependente().intValue());
			guia.setCodigoDependente(beneficiario.getCodigoDependente().longValue());
		}
		guia.setSituacaoFuncional(beneficiarioServidor.getSituacaoFuncional());
		guia.setFuncao(beneficiarioServidor.getFuncao());
		guia.setPagamentoAtendimento(false);
		
		return guia;
	}

	public GuiaPK buildGuiaPK(Long idTipoGuia) {
		GuiaPK guiaPK = new GuiaPK();
		guiaPK.setAnoExercicio(String.valueOf(YearMonth.from(LocalDate.now()).getYear()));
		TipoGuia t = TipoGuiaBusiness.getInstance().findById(idTipoGuia);
		guiaPK.setTipoGuia(t);			
		return guiaPK;
	}
}
