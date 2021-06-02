package br.jus.tream.saude.business;

import javax.xml.bind.DatatypeConverter;

import br.jus.tream.saude.DAO.AnexoDespesaDAOImpl;
import br.jus.tream.saude.dominio.AnexoDespesa;
import br.jus.tream.saude.dominio.Despesa;

/**
 * Classe responsável pelas tratativas de negócio da entidade
 * {@link AnexoDespesa}.
 * 
 * @author vinicius
 *
 */
public class AnexoDespesaBusiness {

	private static AnexoDespesaBusiness bo;

	public static AnexoDespesaBusiness getInstance() {
		if (bo == null) {
			bo = new AnexoDespesaBusiness();
		}
		return bo;
	}

	/**
	 * @see AnexoDespesaDAOImpl#inserir(AnexoDespesa)
	 */
	public int inserir(AnexoDespesa anexo) throws Exception {
		return AnexoDespesaDAOImpl.getInstance().inserir(anexo);
	}

	/**
	 * @see AnexoDespesaDAOImpl#alterar(AnexoDespesa)
	 */
	public int alterar(AnexoDespesa anexo) throws Exception {
		return AnexoDespesaDAOImpl.getInstance().alterar(anexo);
	}

	/**
	 * @see AnexoDespesaDAOImpl#remover(AnexoDespesa)
	 */
	public int remover(AnexoDespesa anexo) throws Exception {
		return AnexoDespesaDAOImpl.getInstance().remover(anexo);
	}
	
	/**
	 * @see AnexoDespesaDAOImpl#findById(Long)
	 */
	public AnexoDespesa getBean(Long idAnexo) {
		return AnexoDespesaDAOImpl.getInstance().findById(idAnexo);
	}

	public AnexoDespesa buildAnexoDespesa(Despesa despesa, String fileUpload, String fileName) {
		AnexoDespesa anexoDespesa = null;
		if (despesa != null && fileUpload != null && fileUpload.length() > 0) {
			byte[] anexo = DatatypeConverter.parseBase64Binary(new String(fileUpload));
			if (despesa.getAnexo() == null) {
				anexoDespesa = new AnexoDespesa();
				anexoDespesa.setDespesa(despesa);
			} else {
				anexoDespesa = despesa.getAnexo();
			}
			anexoDespesa.setDocumento(anexo);
			anexoDespesa.setNome(fileName);
			anexoDespesa.setTipo("pdf");
		}
		return anexoDespesa;
	}

	public int salvarAnexo(Despesa despesa, String fileUpload, String fileName) throws Exception {
		int ret = 0;
		AnexoDespesa anexoDespesa = AnexoDespesaBusiness.getInstance().buildAnexoDespesa(despesa, fileUpload, fileName);
		if (anexoDespesa != null) {
			if (anexoDespesa.getId() == null) {
				ret = AnexoDespesaDAOImpl.getInstance().inserir(anexoDespesa);
			} else {
				ret = AnexoDespesaDAOImpl.getInstance().alterar(anexoDespesa);
			}
		}
		return ret;
	}

}
