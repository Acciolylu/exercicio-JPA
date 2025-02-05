package ifba.edu.br.basicas;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Funcionario implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

   private String nome;
   private String cpf;
   private String funcao;
   
   public Funcionario() {
   }

   public Funcionario(int id, String nome, String cpf, String funcao) {
      this.id = id;
      this.nome = nome;
      this.cpf = cpf;
      this.funcao = funcao;
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

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getFuncao() {
      return funcao;
   }

   public void setFuncao(String funcao) {
      this.funcao = funcao;
   }

   @Override
   public String toString() {
      return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", funcao=" + funcao + "]";
   }

   


}
