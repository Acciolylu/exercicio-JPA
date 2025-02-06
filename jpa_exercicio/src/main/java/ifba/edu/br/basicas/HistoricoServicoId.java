package ifba.edu.br.basicas;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class HistoricoServicoId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int servico_id;
    private int veiculo_id;
    
    public HistoricoServicoId() {
    }

    public HistoricoServicoId(int servico_id, int veiculo_id) {
        this.servico_id = servico_id;
        this.veiculo_id = veiculo_id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getServico_id() {
        return servico_id;
    }

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

    public int getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(int veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    @Override
    public String toString() {
        return "HistoricoServicoId [servico_id=" + servico_id + ", veiculo_id=" + veiculo_id + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoServicoId that = (HistoricoServicoId) o;
        return servico_id == that.servico_id && veiculo_id == that.veiculo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(servico_id, veiculo_id);
    }
    
}
