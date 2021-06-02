package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.util.List;

import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.GuiaProcedimentoDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.CustoGuiaDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.ProcedimentoFormDTO;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.TipoGuia;
import br.jus.tream.saude.util.ValidaHorarioUrgenciaUtil;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link GuiaProcedimento}.
 * 
 * @author vinicius
 *
 */
public class GuiaProcedimentoBusiness {

	private static GuiaProcedimentoBusiness bo;
	private static String PERCENTUAL_URGENCIA = "PERCENTUAL_URGENCIA";

	public static GuiaProcedimentoBusiness getInstance() {
		if (bo == null) {
			bo = new GuiaProcedimentoBusiness();
		}
		return bo;
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#inserir(GuiaProcedimento)
	 */
	public int inserir(GuiaProcedimento guiaProcedimento) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().inserir(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#alterar(GuiaProcedimento)
	 */
	public int alterar(GuiaProcedimento guiaProcedimento) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().alterar(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#remover(GuiaProcedimento)
	 */
	public int remover(GuiaProcedimento guiaProcedimento) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().remover(guiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#findAll()
	 */
	public List<GuiaProcedimento> findAll() {
		return GuiaProcedimentoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#findAll(Pagination)
	 */
	public List<GuiaProcedimento> findPaginado(Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistros());
		return GuiaProcedimentoDAOImpl.getInstance().findAll(pagination);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#findByParams(GuiaProcedimentoParamsDTO,
	 *      Pagination)
	 */
	public List<GuiaProcedimento> findByParams(GuiaProcedimentoParamsDTO params, Pagination pagination)
			throws Exception {
		pagination.setProperties(getTotalRegistrosByParams(params).intValue());
		return GuiaProcedimentoDAOImpl.getInstance().findByParams(params, pagination);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#count()
	 */
	public int getTotalRegistros() throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().count();
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#countByParams(GuiaProcedimentoParamsDTO)
	 */
	public Long getTotalRegistrosByParams(GuiaProcedimentoParamsDTO params) throws Exception {
		return GuiaProcedimentoDAOImpl.getInstance().countByParams(params);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#findById(Long)
	 */
	public GuiaProcedimento getBean(Long idGuiaProcedimento) {
		return GuiaProcedimentoDAOImpl.getInstance().findById(idGuiaProcedimento);
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#findByParamsNative(GuiaProcedimentoParamsDTO,
	 *      Pagination)
	 */
	public List<GuiaProcedimentoDashBoardDTO> findByParamsNative(GuiaProcedimentoParamsDTO params,
			Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistrosByParams(params).intValue());
		return GuiaProcedimentoDAOImpl.getInstance().findByParamsNative(params, pagination);
	}

	
	public CustoGuiaDTO getCustosGuia(Guia guia) {
		return processaCustosGuia(guia.getProcedimentos(), guia.getCusteio());
	}
	
	/**
	 * Responsável por calcular os custos da guia
	 * @param guia que terá seus custos calculados
	 * @return 
	 */
	public CustoGuiaDTO processaCustosGuia(List<GuiaProcedimento> procedimentos, BigDecimal custeio) {
		BigDecimal total = BigDecimal.ZERO;
		BigDecimal totalAcrescimo = BigDecimal.ZERO;
		for (GuiaProcedimento gp : procedimentos) {
			BigDecimal totalProceimento = gp.getValor().multiply(new BigDecimal(gp.getQuantidade()));
			total = total.add(totalProceimento);
			if (gp.getGuia().getUrgencia() && gp.getProcedimento().getConsulta() == 1) {
				total = total.add(gp.getValor().multiply(new BigDecimal(gp.getQuantidade())));
				BigDecimal acrescimoCalculado =  calculaAcrescimo(total);
				totalAcrescimo = totalAcrescimo.add(acrescimoCalculado);
				total = total.add(totalAcrescimo);
			}
		}
		BigDecimal parcelaServidor = total.multiply(custeio).divide(new BigDecimal(100));
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
	
	public GuiaProcedimento buildProcedimento(GuiaPK guiaPK, Procedimento pro, ProcedimentoFormDTO procedimentoForm) {
		boolean periodoUrgencia = ValidaHorarioUrgenciaUtil.validaHorarioPermitidoUrgencia();
		
		GuiaProcedimento gp = new GuiaProcedimento();
		
		gp.setAnoExercicio(guiaPK.getAnoExercicio());
		gp.setNumeroGuia(guiaPK.getNumeroGuia());
		gp.setTipoGuia(guiaPK.getTipoGuia());
		
		gp.setCodTabela(pro.getProcedimentoPK().getTabela().getId());
		gp.setCodigoProcedimento(pro.getProcedimentoPK().getCodigoProcedimento());
		gp.setViaAcesso(0);
		gp.setVideo(0);
		
		if (procedimentoForm != null) {
			gp.setQuantidade(procedimentoForm.getQuantidade());				
			gp.setValor(new BigDecimal(procedimentoForm.getValor()));
		} else {
			gp.setQuantidade(1);
			gp.setValor(pro.getValor());
		}
		
		BigDecimal valorCalculado =  gp.getValor().multiply(new BigDecimal(gp.getQuantidade()));
		
		if (periodoUrgencia && pro.isConsulta()) {
			BigDecimal acrescimoCalculado = GuiaProcedimentoBusiness.getInstance().calculaAcrescimo(valorCalculado);
			valorCalculado = valorCalculado.add(acrescimoCalculado);
		}
				
		gp.setValorCalculado(valorCalculado);
		return gp;
	}

	/**
	 * @see GuiaProcedimentoDAOImpl#removerByGuia(GuiaPK)
	 */
	public int removeProcedimentoByGuia(GuiaPK guiaPk) throws Exception {
		 return GuiaProcedimentoDAOImpl.getInstance().removerByGuia(guiaPk);
	}

	public int inserirGuiaProcedimento(List<GuiaProcedimento> guiasProcedimentos) throws Exception {
		int ret = 0;
		for(GuiaProcedimento gp: guiasProcedimentos) {
			ret = GuiaProcedimentoBusiness.getInstance().inserir(gp);
		}
		return ret;
	}

}
