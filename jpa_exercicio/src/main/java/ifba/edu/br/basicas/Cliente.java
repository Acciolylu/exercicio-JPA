package ifba.edu.br.basicas;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id; 
   private String nome;
   private String email;
   private String cpf;

   
   @OneToOne(cascade = CascadeType.ALL)
   private Endereco endereco;

   @OneToMany(mappedBy= "veiculo", cascade = CascadeType.ALL)
   private List<Veiculo>  veiculo;

public Cliente() {
}

public Cliente(int id, String nome, String email, String cpf, Endereco endereco, List<Veiculo> veiculo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.endereco = endereco;
    this.veiculo = veiculo;
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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

public Endereco getEndereco() {
    return endereco;
}

public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
}

public List<Veiculo> getVeiculo() {
    return veiculo;
}

public void setVeiculo(List<Veiculo> veiculo) {
    this.veiculo = veiculo;
}

@Override
public String toString() {
    return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", endereco=" + endereco
            + ", veiculo=" + veiculo + "]";
}



   


}
