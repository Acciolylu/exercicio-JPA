package ifba.edu.br.dao;


import java.util.List;

import ifba.edu.br.basicas.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VeiculoDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarVeiculo(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
    }

    public Veiculo buscarVeiculo(int id) {
        return em.find(Veiculo.class, id);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
    }

    public void removerVeiculo(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(em.merge(veiculo)); 
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Veiculo> listarVeiculos() {
        return em.createQuery("SELECT v FROM Veiculo v").getResultList();
    }

    public List<Veiculo> buscarVeiculosPorModelo(String modelo) {
        TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v WHERE v.modelo = :modelo", Veiculo.class);
        query.setParameter("modelo", modelo);
        return query.getResultList();
    }

    public List<Veiculo> buscarVeiculosPorMontadora(String montadora) {
        TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v WHERE v.montadora = :montadora", Veiculo.class);
        query.setParameter("montadora", montadora);
        return query.getResultList();
    }
    
}
