package br.jus.tream.saude.DAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.DTO.GuiaProcedimentoDashBoardDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoParamsDTO;
import br.jus.tream.saude.DTO.GuiaProcedimentoReportDTO;
import br.jus.tream.saude.DTO.ProcedimentoDTO;
import br.jus.tream.saude.DTO.ReportParams;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.dominio.GuiaProcedimento;
import br.jus.tream.saude.enumeration.ConsultaSistema;
import br.jus.tream.saude.enumeration.TipoBeneficiario;
import br.jus.tream.saude.util.LeitorArquivo;
import br.jus.tream.saude.util.Mapeador;

public class GuiaProcedimentoDAOImpl implements GuiaProcedimentoDAO {
	
	private DAO<GuiaProcedimento> dao = new DAO<GuiaProcedimento>(GuiaProcedimento.class);

	private static GuiaProcedimentoDAO db;
	
	private Mapeador mapeador = new Mapeador();

	public static GuiaProcedimentoDAO getInstance() {
		if (db == null) {
			db = new GuiaProcedimentoDAOImpl();
		}
		return db;
	}

	@Override
	public GuiaProcedimento findById(Long id) {
		return dao.getBean(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimento> findAll() {
		List<GuiaProcedimento> lista = new ArrayList<GuiaProcedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select gp FROM GuiaProcedimento gp");
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public int inserir(GuiaProcedimento guiaProcedimento) throws Exception {
		int ret = 0;
		try {
			dao.adicionar(guiaProcedimento);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int alterar(GuiaProcedimento guiaProcedimento) throws Exception {
		int ret = 0;
		try {
			dao.atualizar(guiaProcedimento);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(GuiaProcedimento guiaProcedimento) throws Exception {
		int ret = 0;
		try {
			dao.remover(guiaProcedimento);
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimento> findAll(Pagination pagination) {
		List<GuiaProcedimento> lista = new ArrayList<GuiaProcedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select gp FROM GuiaProcedimento gp ")
					.append(" join fetch gp.guia g ")
					.append(" left join fetch g.situacao s")
					.append(" join fetch gp.procedimento p ")
					.append(" WHERE 1=1 ");
			Query query = em.createQuery(sqlString.toString()).setFirstResult(pagination.getStart())
					.setMaxResults(pagination.getEnd());
			lista = query.getResultList();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public int count() throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select count(gp.id) FROM GuiaProcedimento gp ");
			Query query = em.createQuery(sqlString.toString(), Long.class);
			total =  (Long) query.getSingleResult();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return total.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimento> findByParams(GuiaProcedimentoParamsDTO params, Pagination pagination) {
		List<GuiaProcedimento> lista = new ArrayList<GuiaProcedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select gp FROM GuiaProcedimento gp ")
					.append(" join fetch gp.guia g ")
					.append(" left join fetch g.situacao s")
					.append(" join fetch gp.procedimento p ")
					.append(" WHERE 1=1 ");
			buildQuery(sqlString, params);
			Query query = em.createQuery(sqlString.toString(), GuiaProcedimento.class)
					.setFirstResult(pagination.getStart())
					.setMaxResults(pagination.getEnd());
			setParameters(params, query);
			lista = query.getResultList();
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Long countByParams(GuiaProcedimentoParamsDTO params) throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlB = new StringBuilder(LeitorArquivo.getInstancia()
					.lerMemorizar(ConsultaSistema.TOTAL_GUIA_PROCEDIMENTO_POR_PARAMS.getQuery()));
			String sql = buildQueryListagemDashboard(params, sqlB);
			Query query = em.createNativeQuery(sql.toString());
			setParameters(params, query);
			System.out.println(sql);
			total = ((BigDecimal) query.getSingleResult()).longValue();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return total;
	}

	/**
	 * Responsável por os valores aos parâmetros na consulta
	 * @param params
	 * @param query
	 */
	private void setParameters(GuiaProcedimentoParamsDTO params, Query query) {
		if (params == null) {
			return;
		}

		if (params.getNumeroGuia() != null) {
			query.setParameter("numeroGuia", params.getNumeroGuia());
		}

		if (params.getAnoExercicio() != null && !params.getAnoExercicio().isEmpty()) {
			query.setParameter("anoExercicio", params.getAnoExercicio());
		}

		if (params.getCodProcedimento() != null && !params.getCodProcedimento().isEmpty()) {
			query.setParameter("codProcedimento", params.getCodProcedimento());
		}
		
		if (params.getIdTabela() != null) {
			query.setParameter("idTabela", params.getIdTabela());
		}

		if (params.getValor() != null) {
			query.setParameter("valor", params.getValor());
		}

		if (params.getIdSituacaoGuia() != null) {
			query.setParameter("situacaoGuia", params.getIdSituacaoGuia());
		}

		if (params.getDataInicial() != null) {
			query.setParameter("dataInicial", params.getDataInicial());
		}

		if (params.getDataFinal() != null) {
			query.setParameter("dataFinal", params.getDataFinal());
		}
		
		if (params.getDataInicialString() != null && !params.getDataInicialString().isEmpty()) {
			System.out.println( LocalDate.parse(params.getDataInicialString(), DateTimeFormatter.ISO_LOCAL_DATE));
			query.setParameter("dataInicial", LocalDate.parse(params.getDataInicialString(), DateTimeFormatter.ISO_LOCAL_DATE));
		}

		if (params.getDataFinalString() != null && !params.getDataFinalString().isEmpty()) {
			query.setParameter("dataFinal", LocalDate.parse(params.getDataFinalString(), DateTimeFormatter.ISO_LOCAL_DATE));
		}
		
		if (params.getIdCredenciada() != null) {
			query.setParameter("idCredenciada", params.getIdCredenciada());
		}

	}

	/**
	 * Responsável por adicionar os parâmetros na consulta
	 * @param params que serão adicionados
	 * @return query de acordo com os parâmetros
	 * @throws IOException
	 */
	private StringBuilder buildQuery(StringBuilder sqlString, GuiaProcedimentoParamsDTO params) {

		if (params.getNumeroGuia() != null) {
			sqlString.append(" and gp.guia.guiaPK.numeroGuia = :numeroGuia");
		}

		if (params.getAnoExercicio() != null && !params.getAnoExercicio().isEmpty()) {
			sqlString.append(" and gp.guia.guiaPK.anoExercicio = :anoExercicio");
		}

		if (params.getCodProcedimento() != null && !params.getCodProcedimento().isEmpty()) {
			sqlString.append(" and gp.procedimento.procedimentoPK.codigoProcedimento = :codProcedimento");
		}
		
		if (params.getIdTabela() != null) {
			sqlString.append(" and gp.procedimento.procedimentoPK.tabela.id = :idTabela");
		}

		if (params.getValor() != null) {
			sqlString.append(" and gp.valor = :valor");
		}

		if (params.getIdSituacaoGuia() != null) {
			sqlString.append(" and gp.guia.situacao.id = :situacaoGuia");
		}

		if (params.getDataInicial() != null) {
			sqlString.append(" and gp.guia.dataEmissao >= :dataInicial");
		}

		if (params.getDataFinal() != null) {
			sqlString.append(" and gp.guia.dataEmissao <= :dataFinal");
		}
		if (params.getIdCredenciada() != null) {
			sqlString.append(" and gp.guia.credenciado.id = :idCredenciada");
		}
		
		return sqlString;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimento> findByGuia(GuiaPK guiapk) {
		List<GuiaProcedimento> lista = new ArrayList<GuiaProcedimento>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			StringBuilder sqlString = new StringBuilder("Select gp FROM GuiaProcedimento gp ")
					.append(" join fetch gp.guia g ")
					.append(" left join fetch g.situacao s	")
					.append(" join fetch g.situacaoFuncional sf ")
					.append(" left join fetch g.origemGuia o ")
					.append(" left join fetch g.credenciado c ")
					.append(" left join fetch c.tabelaIdade ti ")
					.append(" join fetch c.tabela t ")
					.append(" join fetch c.instituicao i ")
					.append(" join fetch gp.procedimento p ")
					.append(" WHERE g.guiaPK.numeroGuia = :numeroGuia")
					.append(" and  g.guiaPK.anoExercicio = :anoExercicio")
					.append(" and  g.guiaPK.tipoGuia.id = :tipoGuia");
			Query query = em.createQuery(sqlString.toString(), GuiaProcedimento.class)
					.setParameter("numeroGuia", guiapk.getNumeroGuia())
					.setParameter("anoExercicio", guiapk.getAnoExercicio())
					.setParameter("tipoGuia", guiapk.getTipoGuia().getId());
			lista = query.getResultList();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimentoDashBoardDTO> findByParamsNative(GuiaProcedimentoParamsDTO params, Pagination pagination)
			throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		List<Object[]> rows = new ArrayList<Object[]>();
		List<GuiaProcedimentoDashBoardDTO> guiasProcimento;
		try {
			StringBuilder sqlb = new StringBuilder(LeitorArquivo.getInstancia()
					.lerMemorizar(ConsultaSistema.LISTAGEM_GUIA_PROCEDIMENTO_DASHBOARD.getQuery()));
			String sql = buildQueryListagemDashboard(params, sqlb);
			Query query = em.createNativeQuery(sql.toString())
					.setFirstResult(pagination.getStart()).setMaxResults(pagination.getEnd());
			setParameters(params, query);
			System.out.println(sql);
			rows = query.getResultList();
			guiasProcimento = mapeador.paraListaDto(rows, GuiaProcedimentoDashBoardDTO.class);
			consultarAndPreencherProcedimentos(em, guiasProcimento);
		} finally {
			em.close();
		}
		return guiasProcimento;
	}

	@SuppressWarnings("unchecked")
	private void consultarAndPreencherProcedimentos(EntityManager em,
			List<GuiaProcedimentoDashBoardDTO> guiasProcimento) throws IOException {
		List<Object[]> rows;
		Query query;
		String sql_pro = buildQueryProcedimentosPorGuia();
		for (GuiaProcedimentoDashBoardDTO guia : guiasProcimento) {
			query = em.createNativeQuery(sql_pro).setParameter("numeroGuia", guia.getGuia().getNumeroGuia())
					.setParameter("ano", guia.getGuia().getAnoExercicio())
					.setParameter("tipoGuia", guia.getGuia().getTipoGuia().getId());
			rows = query.getResultList();
			for (Object[] obj : rows) {
				String codProcedimento = obj[0] != null ? obj[0].toString() : null;
				Long codTabela = obj[1] != null ? new Long(obj[1].toString()) : null;
				String descricao = obj[2] != null ? obj[2].toString() : null;
				Integer autorizado = obj[3] != null ? new Integer(obj[3].toString()) : null;
				guia.addProcedimento(new ProcedimentoDTO(codProcedimento, codTabela, descricao, autorizado));
			}
		}
	}

	private String buildQueryProcedimentosPorGuia() throws IOException {
		StringBuilder sql_procedimento = new StringBuilder(LeitorArquivo.getInstancia()
				.lerMemorizar(ConsultaSistema.LISTAGEM_PROCEDIMENTO_POR_GUIA_DASHBOARD.getQuery()));
		StringBuilder condicoes = new StringBuilder();
		condicoes.append(" and gp.num_guia = :numeroGuia").append(" and gp.ano_exercicio = :ano")
				.append(" and gp.cod_tip_guia = :tipoGuia");

		String sql_pro = condicoes.length() != 0
				? sql_procedimento.toString().replace(ConsultaSistema.CONDICOES, condicoes.toString())
				: sql_procedimento.toString();
		return sql_pro;
	}
	
	/**
	 * Responsável por adicionar os parâmetros na consulta nativa
	 * @param params que serão adicionados
	 * @return query de acordo com os parâmetros
	 * @throws IOException
	 */
	private String buildQueryListagemDashboard(GuiaProcedimentoParamsDTO params, StringBuilder sql) throws IOException {
		StringBuilder condicoes = new StringBuilder();
		if (params.getNumeroGuia() != null) {
			condicoes.append(" and g.num_guia = :numeroGuia");
		}

		if (params.getAnoExercicio() != null && !params.getAnoExercicio().isEmpty()) {
			condicoes.append(" and g.ano_exercicio = :anoExercicio");
		}

		if (params.getCodProcedimento() != null && !params.getCodProcedimento().isEmpty()) {
			condicoes.append(" and p2.cod_procedimento = :codProcedimento");
		}
		
		if (params.getIdTabela() != null) {
			condicoes.append(" and p2.cod_tabela = :idTabela");
		}

		if (params.getValor() != null) {
			condicoes.append(" and  gp.valorcalc = :valor");
		}

		if (params.getIdSituacaoGuia() != null) {
			condicoes.append(" and s.cod_situacao = :situacaoGuia");
		}

		if (params.getDataInicial() != null) {
			condicoes.append(" and g.dat_emissao >= :dataInicial");
		}

		if (params.getDataFinal() != null) {
			condicoes.append(" and g.dat_emissao <= :dataFinal");
		}
		
		if (params.getDataInicialString() != null && !params.getDataInicialString().isEmpty()) {
			condicoes.append(" and g.dat_emissao >= :dataInicial");
		}

		if (params.getDataFinalString() != null && !params.getDataFinalString().isEmpty()) {
			condicoes.append(" and g.dat_emissao <= :dataFinal");
		}
		
		
		if (params.getIdCredenciada() != null) {
			condicoes.append(" and g.COD_CREDENCIADO = :idCredenciada");
		}
		
		return  condicoes.length() != 0
				? sql.toString().replace(ConsultaSistema.CONDICOES, condicoes.toString())
				: sql.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimentoReportDTO> findDadosRelatorioGuia(ReportParams params) throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		List<Object[]> rows = new ArrayList<Object[]>();
		try {
			StringBuilder sqlb = new StringBuilder(LeitorArquivo.getInstancia()
					.lerMemorizar(ConsultaSistema.GUIA_PROCEDIMENTO_RELATORIO.getQuery()));
			String sql = buildQuery(params, sqlb);
			Query query = em.createNativeQuery(sql.toString());
			setParameters(params, query);
			System.out.println(sql);
			rows = query.getResultList();
		} finally {
			em.close();
		}
		return mapeador.paraListaDto(rows, GuiaProcedimentoReportDTO.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GuiaProcedimentoReportDTO> findDadosRelatorioGuiaOdonto(ReportParams params) throws Exception {
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		List<Object[]> rows = new ArrayList<Object[]>();
		try {
			StringBuilder sqlb = new StringBuilder(LeitorArquivo.getInstancia()
					.lerMemorizar(ConsultaSistema.GUIA_PROCEDIMENTO_ODONTO_RELATORIO.getQuery()));
			String sql = buildQuery(params, sqlb);
			Query query = em.createNativeQuery(sql.toString());
			setParameters(params, query);
			System.out.println(sql);
			rows = query.getResultList();
		} finally {
			em.close();
		}
		return mapeador.paraListaDto(rows, GuiaProcedimentoReportDTO.class);
	}
	
	/**
	 * Responsável por adicionar os parâmetros na consulta
	 * @param params que serão adicionados
	 * @return query de acordo com os parâmetros
	 * @throws IOException
	 */
	private String buildQuery(ReportParams params, StringBuilder sql) throws IOException {
		StringBuilder condicoes = new StringBuilder();
		if (params.getNumeroGuia() != null) {
			condicoes.append(" and gp.num_guia = :numeroGuia");
		}

		if (params.getAnoExercicio() != null && !params.getAnoExercicio().isEmpty()) {
			condicoes.append(" and gp.ano_exercicio = :anoExercicio");
		}

		if (params.getIdTipoGuia() != null) {
			condicoes.append(" and gp.COD_TIP_GUIA = :tipoGuia");
		}
		
		if (params.getTipoBeneficiario() != null && !params.getTipoBeneficiario().isEmpty()) {
			TipoBeneficiario tipoBeneficiario = TipoBeneficiario.findByDescricao(params.getTipoBeneficiario());
			switch (tipoBeneficiario) {
			case DEPENDENTE:
				condicoes.append(" and g.cod_depend = b.cod_depend");
				break;
			case TITULAR:
				condicoes.append(" and g.cod_depend is null");
				break;
			default:
				break;
			}
		}
		
		return  condicoes.length() != 0
				? sql.toString().replace(ConsultaSistema.CONDICOES, condicoes.toString())
				: sql.toString();
	}

	/**
	 * Responsável por os valores aos parâmetros na consulta
	 * @param params
	 * @param query
	 */
	private void setParameters(ReportParams params, Query query) {
		if (params == null) {
			return;
		}
		
		if (params.getNumeroGuia() != null) {
			query.setParameter("numeroGuia", params.getNumeroGuia());
		}

		if (params.getAnoExercicio() != null && !params.getAnoExercicio().isEmpty()) {
			query.setParameter("anoExercicio", params.getAnoExercicio());
		}

		if (params.getIdTipoGuia() != null) {
			query.setParameter("tipoGuia", params.getIdTipoGuia());
		}
	}

	@Override
	public int removerByGuia(GuiaPK guiaPk) throws Exception {
		int ret = 0;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			em.getTransaction().begin();
			em.createQuery("Delete from GuiaProcedimento gp "
										+ " where gp.numeroGuia = :numeroGuia "
										+ " and gp.anoExercicio = :anoExercicio "
										+ " and gp.tipoGuia.id = :idTipoGuia")
										.setParameter("numeroGuia", guiaPk.getNumeroGuia())
										.setParameter("anoExercicio", guiaPk.getAnoExercicio())
										.setParameter("idTipoGuia", guiaPk.getTipoGuia().getId())
										.executeUpdate();
			em.flush();
			em.getTransaction().commit();
			ret = 1;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return ret;
	}
}
