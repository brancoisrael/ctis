package br.jus.tream.saude.business;

import java.util.List;

import br.jus.tream.saude.DAO.BeneficiarioDAO;
import br.jus.tream.saude.DAO.BeneficiarioDAOImpl;
import br.jus.tream.saude.DAO.Pagination;
import br.jus.tream.saude.DTO.FrmGuiaClinicaLaboratorialDTO;
import br.jus.tream.saude.dominio.Beneficiario;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link Beneficiario}.
 * 
 * @author vinicius
 *
 */
public class BeneficiarioBusiness {

	private static BeneficiarioBusiness bo;

	public static BeneficiarioBusiness getInstance() {
		if (bo == null) {
			bo = new BeneficiarioBusiness();
		}
		return bo;
	}

	/**
	 * @see BeneficiarioDAO#alterar(Beneficiario)
	 */
	public int alterar(Beneficiario beneficiario) throws Exception {
		return BeneficiarioDAOImpl.getInstance().alterar(beneficiario);
	}

	/**
	 * @see BeneficiarioDAO#findAll()
	 */
	public List<Beneficiario> findAll() {
		return BeneficiarioDAOImpl.getInstance().findAll();
	}

	/**
	 * @see BeneficiarioDAO#findAll(Pagination)
	 */
	public List<Beneficiario> findPaginado(Pagination pagination) throws Exception {
		pagination.setProperties(getTotalRegistros());
		return BeneficiarioDAOImpl.getInstance().findAll(pagination);
	}

	/**
	 * @see BeneficiarioDAO#count()
	 */
	public int getTotalRegistros() throws Exception {
		return BeneficiarioDAOImpl.getInstance().count();
	}

	/**
	 * @see BeneficiarioDAO#findTitular(String)
	 */
	public Beneficiario getTitular(String matricula) {
		return BeneficiarioDAOImpl.getInstance().findTitular(matricula);
	}
	
	/**
	 * @throws Exception 
	 * @see {@link BeneficiarioDAO#findDependente(String, Integer)}
	 */
	public Beneficiario findDependente(String matricula, Integer codDependente) throws Exception {
		return BeneficiarioDAOImpl.getInstance().findDependente(matricula, codDependente);
	}

	/**
	 * @throws Exception 
	 * @see {@link BeneficiarioDAO#findBenenficiariosByMatricula(String)}
	 */
	public List<Beneficiario> findBenenficiariosByMatricula(String matricula) throws Exception {		
		return BeneficiarioDAOImpl.getInstance().findBenenficiariosByMatricula(matricula);
	}

	public Beneficiario getDePendenteOuTitular(FrmGuiaClinicaLaboratorialDTO frmGuiaClinicaLaboratorialDTO)
			throws Exception {
		Beneficiario beneficiario = new Beneficiario();
		if (frmGuiaClinicaLaboratorialDTO.getCodigoDependente() == null) {
			beneficiario = BeneficiarioDAOImpl.getInstance()
					.findTitular(frmGuiaClinicaLaboratorialDTO.getMatriculaServidor());
		} else {
			beneficiario = BeneficiarioDAOImpl.getInstance().findDependente(
					frmGuiaClinicaLaboratorialDTO.getMatriculaServidor(),
					frmGuiaClinicaLaboratorialDTO.getCodigoDependente().intValue());
		}
		return beneficiario;
	}
}
