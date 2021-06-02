package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.GuiaProcedimentoDAOImpl;
import br.jus.tream.saude.DAO.GuiaProcedimentoOdontoDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DAO.ProcedimentoDAOImpl;
import br.jus.tream.saude.DAO.ProcedimentoOdontoDAOImpl;
import br.jus.tream.saude.DTO.CustoGuiaDTO;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.ProcedimentoFormDTO;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.GuiaProcedimentoOdonto;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoOdonto;
import br.jus.tream.saude.dominio.ProcedimentoPK;
import br.jus.tream.saude.util.ValidaHorarioUrgenciaUtil;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link GuiaProcedimento}.
 * 
 * @author vinicius
 *
 */
public class GuiaProcedimentoOdontoBusiness {

	private static GuiaProcedimentoOdontoBusiness bo;
	private static String PERCENTUAL_URGENCIA = "PERCENTUAL_URGENCIA";
	private static String PROCEDIMENTO_DESPESA_ODONTO = "PROCEDIMENTO_DESPESA_ODONTO";

	public static GuiaProcedimentoOdontoBusiness getInstance() {
		if (bo == null) {
			bo = new GuiaProcedimentoOdontoBusiness();
		}
		return bo;
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#inserir(GuiaProcedimento)
	 */
	public int inserir(GuiaProcedimentoOdonto guiaProcedimento) throws Exception {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().inserir(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#alterar(GuiaProcedimento)
	 */
	public int alterar(GuiaProcedimentoOdonto guiaProcedimento) throws Exception {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().alterar(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#remover(GuiaProcedimento)
	 */
	public int remover(GuiaProcedimentoOdonto guiaProcedimento) throws Exception {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().remover(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#findAll()
	 */
	public List<GuiaProcedimentoOdonto> findAll() {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#findAll(Pagination)
	 */
	public List<GuiaProcedimentoOdonto> findPaginado(Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistros());
		return GuiaProcedimentoOdontoDAOImpl.getInstance().findAll(pagination);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#findByParams(GuiaProcedimentoParamsDTO,
	 *      Pagination)
	 */
	public List<GuiaProcedimentoOdonto> findByParams(GuiaProcedimentoParamsDTO params, Pagination pagination)
			throws Exception {
		pagination.setProperties(getTotalRegistrosByParams(params).intValue());
		return GuiaProcedimentoOdontoDAOImpl.getInstance().findByParams(params, pagination);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#count()
	 */
	public int getTotalRegistros() throws Exception {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().count();
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#countByParams(GuiaProcedimentoParamsDTO)
	 */
	public Long getTotalRegistrosByParams(GuiaProcedimentoParamsDTO params) throws Exception {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().countByParams(params);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#findById(Long)
	 */
	public GuiaProcedimentoOdonto getBean(Long idGuiaProcedimento) {
		return GuiaProcedimentoOdontoDAOImpl.getInstance().findById(idGuiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#findByParamsNative(GuiaProcedimentoParamsDTO,
	 *      Pagination)
	 */
	public List<GuiaProcedimentoDashBoardDTO> findByParamsNative(GuiaProcedimentoParamsDTO params,
			Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistrosByParams(params).intValue());
		return GuiaProcedimentoOdontoDAOImpl.getInstance().findByParamsNative(params, pagination);
	}

	/**
	 * Responsável por calcular os custos da guia
	 * @param guia que terá seus custos calculados
	 * @return 
	 */
	public CustoGuiaDTO getCustosGuia(Guia guia) {
		List<GuiaProcedimentoOdonto> procedimentos = guia.getProcedimentosOdonto();
		BigDecimal total = BigDecimal.ZERO;
		BigDecimal totalAcrescimo = BigDecimal.ZERO;
		for (GuiaProcedimentoOdonto gp : procedimentos) {
			BigDecimal totalProceimento = gp.getValorProcedimento().multiply(new BigDecimal(gp.getQuantidade()));
			total = total.add(totalProceimento);
			if (gp.getGuia().getUrgencia()) {
				total = total.add(gp.getValorProcedimento().multiply(new BigDecimal(gp.getQuantidade())));
				BigDecimal acrescimoCalculado =  calculaAcrescimo(total);
				totalAcrescimo = totalAcrescimo.add(acrescimoCalculado);
				total = total.add(totalAcrescimo);
			}
		}
		BigDecimal parcelaServidor = total.multiply(guia.getCusteio()).divide(new BigDecimal(100));
		BigDecimal parcelaTRE = total.subtract(parcelaServidor);
		return new CustoGuiaDTO(parcelaServidor, parcelaTRE, total, totalAcrescimo);
	}
	
	public BigDecimal calculaAcrescimo(BigDecimal total) {
		BigDecimal percentualAcrescimentos = new BigDecimal(30);
		Dominio dominio = DominioDAOImpl.getInstance().findByDomino(PERCENTUAL_URGENCIA);
		if (dominio != null) {
			percentualAcrescimentos = new BigDecimal(dominio.getValor());
		}
		return total.multiply(percentualAcrescimentos).divide(new BigDecimal(100));
	}
	
	public GuiaProcedimentoOdonto buildProcedimento(GuiaPK guiaPK, ProcedimentoOdonto pro, ProcedimentoFormDTO procedimentoForm) {
		boolean periodoUrgencia = ValidaHorarioUrgenciaUtil.validaHorarioPermitidoUrgencia();
		
		
		GuiaProcedimentoOdonto gp = new GuiaProcedimentoOdonto();
		gp.setAnoExercicio(guiaPK.getAnoExercicio());
		gp.setNumeroGuia(guiaPK.getNumeroGuia());
		gp.setTipoGuia(guiaPK.getTipoGuia());
		
		gp.setCodTabela(pro.getProcedimentoPK().getTabela().getId());
		gp.setCodigoProcedimento(pro.getProcedimentoPK().getCodigoProcedimento());
		gp.setDataAtualizacao(LocalDateTime.now());
//		gp.setViaAcesso(0);
//		gp.setVideo(0);
		
		if (procedimentoForm != null) {
			gp.setQuantidade(procedimentoForm.getQuantidade());				
			gp.setValorProcedimento(new BigDecimal(procedimentoForm.getValor()));
		} else {
			gp.setQuantidade(1);
			gp.setValorProcedimento(pro.getValor());
		}
		
		BigDecimal valorCalculado =  gp.getValorProcedimento().multiply(new BigDecimal(gp.getQuantidade()));
		
//		if (periodoUrgencia && pro.isConsulta()) {
		if (periodoUrgencia) {	
			BigDecimal acrescimoCalculado = GuiaProcedimentoOdontoBusiness.getInstance().calculaAcrescimo(valorCalculado);
			valorCalculado = valorCalculado.add(acrescimoCalculado);
		}
				
		gp.setValorTotal(valorCalculado);
		return gp;
	}

	/**
	 * @see GuiaProcedimentoOdontoDAOImpl#removerByGuia(GuiaPK)
	 */
	public int removeProcedimentoByGuia(GuiaPK guiaPk) throws Exception {
		 return GuiaProcedimentoOdontoDAOImpl.getInstance().removerByGuia(guiaPk);
	}

	public int inserirGuiaProcedimento(List<GuiaProcedimentoOdonto> guiasProcedimentos, Guia guia) throws Exception {
		int ret = 0;
		for(GuiaProcedimentoOdonto gp: guiasProcedimentos) {
			gp.setNumeroGuia(guia.getGuiaPK().getNumeroGuia());
			gp.setAnoExercicio(guia.getGuiaPK().getAnoExercicio());
			gp.setTipoGuia(guia.getGuiaPK().getTipoGuia());
			
			ret = GuiaProcedimentoOdontoBusiness.getInstance().inserir(gp);
		}
		return ret;
	}

	public int salvarProcedimentoDespesa(Guia guia, FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) throws Exception {
		int ret = 0;
		if (frmGuiaClinicaLaboratorialDTO.isGravarDespesa()) {
			ProcedimentoOdonto proced = findProcedimentoDespesa(guia);
			if (proced != null) {
				proced.setValor(new BigDecimal(frmGuiaClinicaLaboratorialDTO.getValorLimpo()));
				GuiaProcedimentoOdonto gpDespesa = GuiaProcedimentoOdontoBusiness.getInstance().buildProcedimento(guia.getGuiaPK(), proced, null);
				ret = GuiaProcedimentoOdontoBusiness.getInstance().inserir(gpDespesa);
			}
		}
		return ret;
	}
	
public ProcedimentoOdonto findProcedimentoDespesa(Guia guia) {
		
		Dominio dominio = DominioDAOImpl.getInstance().findByDomino(PROCEDIMENTO_DESPESA_ODONTO);
		ProcedimentoPK procedimentoPK = new ProcedimentoPK();
		procedimentoPK.setCodigoProcedimento(dominio.getValor());
		procedimentoPK.setTabela(guia.getCredenciado().getTabela());
		
		return ProcedimentoOdontoDAOImpl.getInstance().findById(procedimentoPK);
	}

}
