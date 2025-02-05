package ifba.edu.br.basicas;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Servico implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private int id; 
   private String descricao;
   private Double valor;

   @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
   private List<HistoricoServico> historicoServicos;

   public Servico() {
   }

   public Servico(int id, String descricao, Double valor, List<HistoricoServico> historicoServicos) {
      this.id = id;
      this.descricao = descricao;
      this.valor = valor;
      this.historicoServicos = historicoServicos;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public Double getValor() {
      return valor;
   }

   public void setValor(Double valor) {
      this.valor = valor;
   }

   public List<HistoricoServico> getHistoricoServicos() {
      return historicoServicos;
   }

   public void setHistoricoServicos(List<HistoricoServico> historicoServicos) {
      this.historicoServicos = historicoServicos;
   }

   @Override
   public String toString() {
      return "Servico [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", historicoServicos="
            + historicoServicos + "]";
   }

   

}
