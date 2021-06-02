package br.jus.tream.saude.DAO;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.tream.saude.dominio.Guia;
import br.jus.tream.saude.dominio.GuiaPK;
import br.jus.tream.saude.enumeration.ClassificacaoTipoGuia;
import br.jus.tream.saude.enumeration.SituacaoGuia;

public class GuiaDAOImpl implements GuiaDAO {
	
	private DAO<Guia> dao = new DAO<Guia>(Guia.class);

	static GuiaDAO db;

	public static GuiaDAO getInstance() {
		if (db == null) {
			db = new GuiaDAOImpl();
		}
		return db;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guia> findAll() {
		List<Guia> lista = new ArrayList<Guia>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select g FROM Guia g "
										+ " left join fetch g.situacao s	"
										+ " join fetch g.situacaoFuncional sf "
										+ " left join fetch g.origemGuia o "
										+ " left join fetch g.credenciado c "
										+ " left join fetch c.tabelaIdade ti "
										+ " join fetch c.tabela t "
										+ " join fetch c.instituicao i ");
			lista = query.getResultList();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Guia findById(GuiaPK id) {
		Guia guia = null;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			guia = em.createQuery("Select g FROM Guia g "
										+ " where g.guiaPK.numeroGuia = :numeroGuia "
										+ " and g.guiaPK.anoExercicio = :anoExercicio "
										+ " and g.guiaPK.tipoGuia.id = :idTipoGuia", Guia.class)
										.setParameter("numeroGuia", id.getNumeroGuia())
										.setParameter("anoExercicio", id.getAnoExercicio())
										.setParameter("idTipoGuia", id.getTipoGuia().getId())
										.getSingleResult();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return guia;
	}

	@Override
	public int inserir(Guia guia) throws Exception {
		int ret = dao.adicionar(guia);
		if (ret == 5) {
			throw new Exception("Erro ao cadastrar a Guia");
		}
		return ret;
	}

	@Override
	public int alterar(Guia guia) throws Exception {
		int ret = dao.atualizar(guia);
		if (ret == 5) {
			throw new Exception("Erro ao atualizar a Guia");
		}
		return ret;
	}

	@Override
	public int remover(Guia guia) throws Exception {
		int ret = dao.remover(guia);
		if (ret == 5) {
			throw new Exception("Erro ao remover a Guia");
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guia> findGuiasDaCredenciada(Long idCredenciada, Pagination pagination) {
		List<Guia> lista = new ArrayList<Guia>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select g FROM Guia g "
										+ " left join fetch g.situacao s	"
										+ " join fetch g.situacaoFuncional sf "
										+ " left join fetch g.origemGuia o "
										+ " left join fetch g.credenciado c "
										+ " left join fetch c.tabelaIdade ti "
										+ " join fetch c.tabela t "
										+ " join fetch c.instituicao i "
										+ " where g.credenciado.id = :idCredenciada")
					.setParameter("idCredenciada", idCredenciada)
					.setFirstResult(pagination.getStart())
					.setMaxResults(pagination.getEnd());
			lista = query.getResultList();
		}  finally {
			em.close();
		}
		return lista;
	}

	@Override
	public Long countGuiasDaCredenciada(Long idCredenciada) throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em
					.createQuery("Select count(g) FROM Guia g where g.credenciado.id = :idCredenciada", Long.class)
					.setParameter("idCredenciada", idCredenciada);
			total = (Long) query.getSingleResult();
		} finally {
			em.close();
		}
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guia> findAll(Pagination pagination) {
		List<Guia> lista = new ArrayList<Guia>();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em.createQuery("Select g FROM Guia g " 
										+ " join fetch g.guiaPK.tipoGuia tg"
										+ " left join fetch g.auxiliar aux	"
										+ " left join fetch g.especialidade esp	"
										+ " left join fetch g.situacao s	"
										+ " join fetch g.situacaoFuncional sf "
										+ " left fetch g.usuarioAutorizado usua "
										+ " left fetch usua.credenciado credUsu "
										+ " left join fetch g.origemGuia o "
										+ " left join fetch g.credenciado c "
										+ " left join fetch c.tabelaIdade ti "
										+ " join fetch c.tabela t "
										+ " join fetch c.instituicao i ", Guia.class)
							.setFirstResult(pagination.getStart())
							.setMaxResults(pagination.getEnd());
			lista = query.getResultList();
		} finally {
			em.close();
		}
		return lista;
	}
	
	@Override
	public Long countGuias() throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em
					.createQuery("Select count(g) FROM Guia g", Long.class);
			total = (Long) query.getSingleResult();
		} finally {
			em.close();
		}
		return total;
	}

	@Override
	public Long totalGuiasAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao) throws Exception {
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em
					.createQuery("Select count(g) FROM Guia g where to_char(g.dataEmissao,'YYYY-MM') = :anoMes "
							+ " and g.credenciado.id = :idCredenciada "
							+ " and g.guiaPK.tipoGuia.classificacao = :classificacao "
							, Long.class)
					.setParameter("anoMes", anoMes.toString())
					.setParameter("idCredenciada", idCredenciada)
					.setParameter("classificacao", classificacao);
			total = (Long) query.getSingleResult();
		}  finally {
			em.close();
		}
		return total;
	}

	@Override
	public Long getSequence() {
		Long sequence = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em
					.createNativeQuery("select SEQNUM_GUIA.nextval from dual");
			sequence = ((BigDecimal) query.getSingleResult()).longValue();		
		}  finally {
			em.close();
		}
		return sequence;
	}

	@Override
	public Long findTotalGuiasPorSituacaoAnoMes(YearMonth anoMes, Long idCredenciada, ClassificacaoTipoGuia classificacao, SituacaoGuia... ids) throws Exception {
		List<Short> idsSituacoes = new ArrayList<Short>();
		for (SituacaoGuia id : ids) {
			idsSituacoes.add(id.getIdSituacao());
		}
		Long total = 0L;
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			Query query = em
					.createQuery("Select count(g) FROM Guia g "
							+ " join g.situacao s where to_char(g.dataEmissao,'YYYY-MM') = :anoMes "
							+ " and g.credenciado.id = :idCredenciada "
							+ " and g.guiaPK.tipoGuia.classificacao = :classificacao "
							+ " and s.id in (:ids)", Long.class)
					.setParameter("anoMes", anoMes.toString())
					.setParameter("idCredenciada", idCredenciada)
					.setParameter("classificacao", classificacao)
					.setParameter("ids", idsSituacoes);
			total = (Long) query.getSingleResult();
		}  finally {
			em.close();
		}
		return total;
	}

}
