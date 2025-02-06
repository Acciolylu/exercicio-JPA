package ifba.edu.br.dao;

import java.util.List;

import ifba.edu.br.basicas.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarCliente(Cliente c) {
        em.getTransaction().begin();
        ;
        em.persist(c);
        em.getTransaction().commit();

    }

    public Cliente buscarCliente(int id) {
        return em.find(Cliente.class, id);
    }

    public void atualizarCliente(Cliente c) {
        em.getTransaction().begin();
        ;
        em.persist(c);
        em.getTransaction().commit();
    }

    public void removerCliente(Cliente c) {
        em.getTransaction().begin();
        ;
        em.persist(c);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> listarClientes() {
        return em.createQuery("SELECT c FROM Cliente c").getResultList();
    }

    public List<Cliente> buscarClientes(String nome) {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.nome = :name", Cliente.class);
        query.setParameter("name", nome);

        return query.getResultList();
    }
}