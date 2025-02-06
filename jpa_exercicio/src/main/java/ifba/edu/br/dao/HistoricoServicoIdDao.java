package ifba.edu.br.dao;

import ifba.edu.br.basicas.HistoricoServicoId;

public class HistoricoServicoIdDao {

    public static HistoricoServicoId criarHistoricoServicoId(int servicoId, int veiculoId) {
        return new HistoricoServicoId(servicoId, veiculoId);
    }

}