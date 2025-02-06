package ifba.edu.br.basicas;

import java.io.Serializable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Entity
public class HistoricoServico implements Serializable {
  @EmbeddedId
    private HistoricoServicoId id;

    @ManyToOne
    @MapsId("servico_id")
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @ManyToOne
    @MapsId("veiculo_id")
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    public HistoricoServico() {
    }

    public HistoricoServico(HistoricoServicoId id, Servico servico, Veiculo veiculo, Funcionario funcionario) {
      this.id = id;
      this.servico = servico;
      this.veiculo = veiculo;
      this.funcionario = funcionario;
    }

    public HistoricoServicoId getId() {
      return id;
    }

    public void setId(HistoricoServicoId id) {
      this.id = id;
    }

    public Servico getServico() {
      return servico;
    }

    public void setServico(Servico servico) {
      this.servico = servico;
    }

    public Veiculo getVeiculo() {
      return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
      this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
      return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
      this.funcionario = funcionario;
    }

    @Override
    public String toString() {
      return "HistoricoServico [id=" + id + ", servico=" + servico + ", veiculo=" + veiculo + ", funcionario="
          + funcionario + "]";
    }

  
    
}
