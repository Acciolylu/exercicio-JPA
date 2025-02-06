package ifba.edu.br.dao;

import java.util.List;

import ifba.edu.br.basicas.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class FuncionarioDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarFuncionario(Funcionario funcionario) {
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    public Funcionario buscarFuncionario(int id) {
        return em.find(Funcionario.class, id);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    public void removerFuncionario(Funcionario funcionario) {
        em.getTransaction().begin();
        em.remove(em.merge(funcionario));
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Funcionario> listarFuncionarios() {
        return em.createQuery("SELECT f FROM Funcionario f").getResultList();
    }

    public List<Funcionario> buscarFuncionariosPorNome(String nome) {
        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f WHERE f.nome = :nome", Funcionario.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
}