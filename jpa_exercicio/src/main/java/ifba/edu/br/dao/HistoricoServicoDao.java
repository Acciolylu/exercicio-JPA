package ifba.edu.br.dao;

import java.util.List;

import ifba.edu.br.basicas.Funcionario;
import ifba.edu.br.basicas.HistoricoServico;
import ifba.edu.br.basicas.HistoricoServicoId;
import ifba.edu.br.basicas.Servico;
import ifba.edu.br.basicas.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class HistoricoServicoDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarHistoricoServico(HistoricoServico historicoServico) {
        em.getTransaction().begin();
        em.persist(historicoServico);
        em.getTransaction().commit();
    }

    public HistoricoServico buscarHistoricoServico(HistoricoServicoId id) {
        return em.find(HistoricoServico.class, id);
    }

    public void atualizarHistoricoServico(HistoricoServico historicoServico) {
        em.getTransaction().begin();
        em.merge(historicoServico);
        em.getTransaction().commit();
    }

    public void removerHistoricoServico(HistoricoServico historicoServico) {
        em.getTransaction().begin();
        em.remove(em.merge(historicoServico)); // Garante que a entidade está no estado gerenciado antes de removê-la
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoServico> listarHistoricoServicos() {
        return em.createQuery("SELECT h FROM HistoricoServico h").getResultList();
    }

    public List<HistoricoServico> buscarHistoricoServicosPorServico(Servico servico) {
        TypedQuery<HistoricoServico> query = em.createQuery(
                "SELECT h FROM HistoricoServico h WHERE h.servico = :servico", HistoricoServico.class);
        query.setParameter("servico", servico);
        return query.getResultList();
    }

    public List<HistoricoServico> buscarHistoricoServicosPorVeiculo(Veiculo veiculo) {
        TypedQuery<HistoricoServico> query = em.createQuery(
                "SELECT h FROM HistoricoServico h WHERE h.veiculo = :veiculo", HistoricoServico.class);
        query.setParameter("veiculo", veiculo);
        return query.getResultList();
    }

    public List<HistoricoServico> buscarHistoricoServicosPorFuncionario(Funcionario funcionario) {
        TypedQuery<HistoricoServico> query = em.createQuery(
                "SELECT h FROM HistoricoServico h WHERE h.funcionario = :funcionario", HistoricoServico.class);
        query.setParameter("funcionario", funcionario);
        return query.getResultList();
    }
}