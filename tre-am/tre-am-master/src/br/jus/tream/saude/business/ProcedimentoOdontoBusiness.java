package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import br.jus.tream.saude.DAO.DominioDAOImpl;
import br.jus.tream.saude.DAO.ProcedimentoDAOImpl;
import br.jus.tream.saude.DAO.ProcedimentoOdontoDAOImpl;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.DTO.ProcedimentoFormDTO;
import br.jus.tream.saude.DTO.ProcedimentoParamsDTO;
import br.jus.tream.saude.dominio.Credenciado;
import br.jus.tream.saude.dominio.Dominio;
import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.dominio.GuiaProcedimentoOdonto;
import br.jus.tream.saude.dominio.Procedimento;
import br.jus.tream.saude.dominio.ProcedimentoOdonto;
import br.jus.tream.saude.dominio.ProcedimentoPK;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Procedimento}.
 * 
 * @author vinicius
 *
 */
public class ProcedimentoOdontoBusiness {

	private static ProcedimentoOdontoBusiness bo;
	
	private static String PROCEDIMENTO_DESPESA_ODONTO = "PROCEDIMENTO_DESPESA_ODONTO";

	public static ProcedimentoOdontoBusiness getInstance() {
		if (bo == null) {
			bo = new ProcedimentoOdontoBusiness();
		}
		return bo;
	}

	/**
	 * @see ProcedimentoDAOImpl#findAll()
	 */
	public List<ProcedimentoOdonto> findAll() {
		return ProcedimentoOdontoDAOImpl.getInstance().findAll();
	}

	/**
	 * @see ProcedimentoDAOImpl#findById(ProcedimentoPK)
	 */
	public ProcedimentoOdonto findById(ProcedimentoPK id) {
		return ProcedimentoOdontoDAOImpl.getInstance().findById(id);
	}
	
	/**
	 * @see ProcedimentoDAOImpl#findByParams(ProcedimentoParamsDTO)
	 */
	public List<ProcedimentoOdonto> findByParams(ProcedimentoParamsDTO params) {
		return ProcedimentoOdontoDAOImpl.getInstance().findByParams(params);
	}

	public List<GuiaProcedimentoOdonto> builListaProcedimento(List<ProcedimentoFormDTO> listaProcedimento, Credenciado credenciado, GuiaPK guiaPK) {
		
		List<GuiaProcedimentoOdonto> guiasProcedimentos = new ArrayList<GuiaProcedimentoOdonto>();
		
		for(ProcedimentoFormDTO p: listaProcedimento) {
			ProcedimentoPK pk = new ProcedimentoPK();
			pk.setCodigoProcedimento(p.getCodigoProcedimento());
			pk.setTabela(credenciado.getTabela());
			ProcedimentoOdonto procedimento = ProcedimentoOdontoBusiness.getInstance().findById(pk);
			
			GuiaProcedimentoOdonto guiaProcedimento = GuiaProcedimentoOdontoBusiness.getInstance().buildProcedimento(guiaPK, procedimento, p);
			guiaProcedimento.setDataAtualizacao(LocalDateTime.now());
			guiasProcedimentos.add(guiaProcedimento);
		}
		return guiasProcedimentos;
	}

	public int salvarProcedimentoDespesa(Guia guia,
			FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) throws Exception {
		int ret = 0;
		if (frmGuiaClinicaLaboratorialDTO.isGravarDespesa()) {
			ProcedimentoOdonto proced = findProcedimentoDespesa(guia.getCredenciado());
			if (proced != null) {
				proced.setValor(new BigDecimal(frmGuiaClinicaLaboratorialDTO.getValorLimpo()));
				
				GuiaProcedimentoOdonto gpDespesa = GuiaProcedimentoOdontoBusiness.getInstance().buildProcedimento(guia.getGuiaPK(), proced, null);
				ret = GuiaProcedimentoOdontoBusiness.getInstance().inserir(gpDespesa);
			}
		}
		return ret;
	}
	
	public ProcedimentoOdonto findProcedimentoDespesa(Credenciado credenciado) {
		
		Dominio dominio = DominioDAOImpl.getInstance().findByDomino(PROCEDIMENTO_DESPESA_ODONTO);
		ProcedimentoPK procedimentoPK = new ProcedimentoPK();
		procedimentoPK.setCodigoProcedimento(dominio.getValor());
		procedimentoPK.setTabela(credenciado.getTabela());
		
		return ProcedimentoOdontoDAOImpl.getInstance().findById(procedimentoPK);
	}

	public BigDecimal calculaValorTotalGuia(BigDecimal valorTotalGuia, List<GuiaProcedimentoOdonto> guiasProcedimentos, boolean gravarDespesa, Credenciado credenciado) {
		for(GuiaProcedimentoOdonto gp: guiasProcedimentos) {	
			valorTotalGuia = valorTotalGuia.add(gp.getValorTotal());
		}
		if (gravarDespesa) {
			ProcedimentoOdonto procedimentoDespesa = ProcedimentoOdontoBusiness.getInstance().findProcedimentoDespesa(credenciado);
			valorTotalGuia = valorTotalGuia.add(procedimentoDespesa.getValor());
		}
		
		return valorTotalGuia;
	}

	public List<ProcedimentoFormDTO> buildListaProcedimentoDTO(
			FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		return objectMapper.readValue(frmGuiaClinicaLaboratorialDTO.getProcedimentos(),
				typeFactory.constructCollectionType(List.class, ProcedimentoFormDTO.class));
	}

}
