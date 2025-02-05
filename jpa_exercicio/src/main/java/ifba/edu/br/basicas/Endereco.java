package ifba.edu.br.basicas;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;


@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
   private int id; 
   private String cidade;
   private String rua;
   private String bairro;
   private String numero;
   private String cep;

   @OneToOne
   @JoinColumn(name = "cliente_id", nullable = false)
   private Cliente cliente;

public Endereco() {
}

public Endereco(int id, String cidade, String rua, String bairro, String numero, String cep, Cliente cliente) {
    this.id = id;
    this.cidade = cidade;
    this.rua = rua;
    this.bairro = bairro;
    this.numero = numero;
    this.cep = cep;
    this.cliente = cliente;
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

public String getCidade() {
    return cidade;
}

public void setCidade(String cidade) {
    this.cidade = cidade;
}

public String getRua() {
    return rua;
}

public void setRua(String rua) {
    this.rua = rua;
}

public String getBairro() {
    return bairro;
}

public void setBairro(String bairro) {
    this.bairro = bairro;
}

public String getNumero() {
    return numero;
}

public void setNumero(String numero) {
    this.numero = numero;
}

public String getCep() {
    return cep;
}

public void setCep(String cep) {
    this.cep = cep;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

@Override
public String toString() {
    return "Endereco [id=" + id + ", cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + ", numero=" + numero
            + ", cep=" + cep + ", cliente=" + cliente + "]";
}

   

}
