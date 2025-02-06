package ifba.edu.br.dao;

import java.util.List;

import ifba.edu.br.basicas.Endereco;
import jakarta.persistence.EntityManager;

public class EnderecoDao {

      EntityManager em = GetEntityManager.getConnectionJpa();

      public void adicionarEndereco(Endereco e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    public Endereco buscarEndereco(int id){
        return em.find(Endereco.class, id);
    }
    public void atualizarEndereco(Endereco e){
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }
    public void removerEndereco(Endereco e){
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
    @SuppressWarnings("unchecked")
    public List<Endereco> listarEnderecos(){
        return em.createQuery("SELECT e FROM Endereco e").getResultList();
    }  
}