package br.jus.tream.saude.business;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.jus.tream.saude.DAO.AnexoDespesaDAOImpl;
import br.jus.tream.saude.DAO.DespesaDAOImpl;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.dominio.AnexoDespesa;
import br.jus.tream.saude.dominio.Despesa;
import br.jus.tream.saude.dominio.Guia;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Despesa}.
 * 
 * @author vinicius
 *
 */
public class DespesaBusiness {

	private static DespesaBusiness bo;

	public static DespesaBusiness getInstance() {
		if (bo == null) {
			bo = new DespesaBusiness();
		}
		return bo;
	}

	/**
	 * @see DespesaDAOImpl#inserir(Despesa)
	 */
	public int inserir(Despesa despesa) throws Exception {
		return DespesaDAOImpl.getInstance().inserir(despesa);
	}

	/**
	 * @see DespesaDAOImpl#alterar(Despesa)
	 */
	public int alterar(Despesa despesa) throws Exception {
		return DespesaDAOImpl.getInstance().alterar(despesa);
	}

	/**
	 * @see DespesaDAOImpl#remover(Despesa)
	 */
	public int remover(Despesa despesa) throws Exception {
		return DespesaDAOImpl.getInstance().remover(despesa);
	}
	
	/**
	 * @see DespesaDAOImpl#findById(Long)
	 */
	public Despesa getBean(Long idAnexo) {
		return DespesaDAOImpl.getInstance().findById(idAnexo);
	}

	public Despesa buildDespesa(Guia guia, FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO) {
		Despesa despesa = null;
		if (frmGuiaClinicaLaboratorialDTO.isGravarDespesa()) {
			if (guia.getDespesa() != null) {
				despesa = guia.getDespesa();
			} else {
				despesa = new Despesa();
				despesa.setDataCadastro(LocalDate.now());
				despesa.setAnoExercicio(guia.getGuiaPK().getAnoExercicio());
				despesa.setNumeroGuia(guia.getGuiaPK().getNumeroGuia());
				despesa.setTipoGuia(guia.getGuiaPK().getTipoGuia());
			}
			despesa.setObservacao(frmGuiaClinicaLaboratorialDTO.getObservacao());
			if (frmGuiaClinicaLaboratorialDTO.getValor() != null && frmGuiaClinicaLaboratorialDTO.getValor().length() > 0) {
				despesa.setValor(new BigDecimal(frmGuiaClinicaLaboratorialDTO.getValorLimpo()));
			}
		}	
		return despesa;
	}

	public int salvarDespesaAnexo(Guia guia, FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO, String fileUpload, String fileName) throws Exception {
		int ret = 0;
		Despesa despesa = DespesaBusiness.getInstance().buildDespesa(guia, frmGuiaClinicaLaboratorialDTO);
		if (despesa != null) {
			if (despesa.getId() == null) {
				ret = DespesaDAOImpl.getInstance().inserir(despesa);
			} else {
				ret = DespesaDAOImpl.getInstance().alterar(despesa);
			}
			if (ret == 1) {
				ret = AnexoDespesaBusiness.getInstance().salvarAnexo(despesa, fileUpload, fileName);
			}
			
		}
		return ret;
		
	}

}
