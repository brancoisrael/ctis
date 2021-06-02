package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.ProcedimentoDAOImpl;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.DTO.ProcedimentoFormDTO;
import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoPK;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Procedimento}.
 * 
 * @author vinicius
 *
 */
public class ProcedimentoBusiness {

	private static ProcedimentoBusiness bo;
	
	private static String PROCEDIMENTO_DESPESA = "PROCEDIMENTO_DESPESA";

	public static ProcedimentoBusiness getInstance() {
		if (bo == null) {
			bo = new ProcedimentoBusiness();
		}
		return bo;
	}

	/**
	 * @see ProcedimentoDAOImpl#findAll()
	 */
	public List<Procedimento> findAll() {
		return ProcedimentoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see ProcedimentoDAOImpl#findById(ProcedimentoPK)
	 */
	public Procedimento findById(ProcedimentoPK id) {
		return ProcedimentoDAOImpl.getInstance().findById(id);
	}
	
	/**
	 * @see ProcedimentoDAOImpl#findByParams(ProcedimentoParamsDTO)
	 */
	public List<Procedimento> findByParams(ProcedimentoParamsDTO params) {
		return ProcedimentoDAOImpl.getInstance().findByParams(params);
	}

	public List<GuiaProcedimento> builListaProcedimento(List<ProcedimentoFormDTO> listaProcedimento, Credenciado credenciado, GuiaPK guiaPK) {
		
		List<GuiaProcedimento> guiasProcedimentos = new ArrayList<GuiaProcedimento>();
		
		for(ProcedimentoFormDTO p: listaProcedimento) {
			ProcedimentoPK pk = new ProcedimentoPK();
			pk.setCodigoProcedimento(p.getCodigoProcedimento());
			pk.setTabela(credenciado.getTabela());
			Procedimento procedimento = ProcedimentoBusiness.getInstance().findById(pk);
			
			GuiaProcedimento guiaProcedimento = GuiaProcedimentoBusiness.getInstance().buildProcedimento(guiaPK, procedimento, p);
			
			guiasProcedimentos.add(guiaProcedimento);
		}
		return guiasProcedimentos;
	}

	public int salvarProcedimentoDespesa(Guia guia,
			FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) throws Exception {
		int ret = 0;
		if (frmGuiaClinicaLaboratorialDTO.isGravarDespesa()) {
			Procedimento proced = findProcedimentoDespesa(guia);
			if (proced != null) {
				proced.setValor(new BigDecimal(frmGuiaClinicaLaboratorialDTO.getValorLimpo()));
				proced.setQuantidade(1);
				
				GuiaProcedimento gpDespesa = GuiaProcedimentoBusiness.getInstance().buildProcedimento(guia.getGuiaPK(), proced, null);
				ret = GuiaProcedimentoBusiness.getInstance().inserir(gpDespesa);
			}
		}
		return ret;
	}
	
	public Procedimento findProcedimentoDespesa(Guia guia) {
		
		Dominio dominio = DominioDAOImpl.getInstance().findByDomino(PROCEDIMENTO_DESPESA);
		ProcedimentoPK procedimentoPK = new ProcedimentoPK();
		procedimentoPK.setCodigoProcedimento(dominio.getValor());
		procedimentoPK.setTabela(guia.getCredenciado().getTabela());
		
		return ProcedimentoDAOImpl.getInstance().findById(procedimentoPK);
	}

	public BigDecimal calculaValorTotalGuia(BigDecimal valorTotalGuia, List<GuiaProcedimento> guiasProcedimentos, boolean gravarDespesa, Guia guia) {
		for(GuiaProcedimento gp: guiasProcedimentos) {	
			valorTotalGuia = valorTotalGuia.add(gp.getValorCalculado());
		}
		if (gravarDespesa) {
			Procedimento procedimentoDespesa = ProcedimentoBusiness.getInstance().findProcedimentoDespesa(guia);
			valorTotalGuia = valorTotalGuia.add(procedimentoDespesa.getValor());
		}
		
		return valorTotalGuia;
	}

}
