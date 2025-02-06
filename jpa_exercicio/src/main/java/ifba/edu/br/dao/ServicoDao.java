package ifba.edu.br.dao;

import java.util.List;

import ifba.edu.br.basicas.Servico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ServicoDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarServico(Servico servico) {
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
    }

    public Servico buscarServico(int id) {
        return em.find(Servico.class, id);
    }

    public void atualizarServico(Servico servico) {
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
    }

    public void removerServico(Servico servico) {
        em.getTransaction().begin();
        em.remove(em.merge(servico)); // Garante que a entidade está no estado gerenciado antes de removê-la
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Servico> listarServicos() {
        return em.createQuery("SELECT s FROM Servico s").getResultList();
    }

    public List<Servico> buscarServicosPorDescricao(String descricao) {
        TypedQuery<Servico> query = em.createQuery("SELECT s FROM Servico s WHERE s.descricao = :descricao", Servico.class);
        query.setParameter("descricao", descricao);
        return query.getResultList();
    }

    public List<Servico> buscarServicosPorValor(Double valor) {
        TypedQuery<Servico> query = em.createQuery("SELECT s FROM Servico s WHERE s.valor = :valor", Servico.class);
        query.setParameter("valor", valor);
        return query.getResultList();
    }
}