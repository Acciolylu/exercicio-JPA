package ifba.edu.br.principal;

import java.util.ArrayList;
import java.util.List;

import ifba.edu.br.basicas.Cliente;
import ifba.edu.br.basicas.Endereco;
import ifba.edu.br.basicas.Funcionario;
import ifba.edu.br.basicas.HistoricoServico;
import ifba.edu.br.basicas.HistoricoServicoId;
import ifba.edu.br.basicas.Servico;
import ifba.edu.br.basicas.Veiculo;
import ifba.edu.br.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = GetEntityManager.getConnectionJpa();

        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");
        cliente.setEmail("joao.silva@example.com");
        cliente.setCpf("123.456.789-00");

        Endereco endereco = new Endereco();
        endereco.setCidade("Salvador");
        endereco.setRua("Rua das Flores");
        endereco.setBairro("Centro");
        endereco.setNumero("123");
        endereco.setCep("40000-000");
        endereco.setCliente(cliente);
        cliente.setEndereco(endereco);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria Oliveira");
        funcionario.setCpf("987.654.321-00");
        funcionario.setFuncao("Mecânica");

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Fusca");
        veiculo.setMontadora("Volkswagen");
        veiculo.setCliente(cliente);

        Servico servico = new Servico();
        servico.setDescricao("Troca de óleo");
        servico.setValor(150.0);

        HistoricoServicoId historicoServicoId = new HistoricoServicoId(servico.getId(), veiculo.getId());

        HistoricoServico historicoServico = new HistoricoServico();
        historicoServico.setId(historicoServicoId);
        historicoServico.setServico(servico);
        historicoServico.setVeiculo(veiculo);
        historicoServico.setFuncionario(funcionario);

        List<HistoricoServico> historicosServico = new ArrayList<>();
        historicosServico.add(historicoServico);
        servico.setHistoricoServicos(historicosServico);
        veiculo.setHistoricoServicos(historicosServico);

        em.getTransaction().begin();
        em.persist(cliente);
        em.persist(endereco);
        em.persist(funcionario);
        em.persist(veiculo);
        em.persist(servico);
        em.persist(historicoServico);
        em.getTransaction().commit();

        Cliente clienteImprimir = em.find(Cliente.class, cliente.getId());
        Veiculo veiculoImprimir = em.find(Veiculo.class, veiculo.getId());
        Servico servicoImprimir = em.find(Servico.class, servico.getId());
        HistoricoServico historicoServicoImprimir = em.find(HistoricoServico.class, historicoServicoId);

        System.out.println("                  NOTA FISCAL                \n");
        System.out.println("=============================================\n");
        System.out.println("Cliente: " + clienteImprimir.getNome() + "\n" +
                "CPF: " + clienteImprimir.getCpf() + "\n" +
                "Email: " + clienteImprimir.getEmail() + "\n" +
                "Endereço: " + clienteImprimir.getEndereco().getRua() + ", " +
                clienteImprimir.getEndereco().getNumero() + " - " +
                clienteImprimir.getEndereco().getBairro() + ", " +
                clienteImprimir.getEndereco().getCidade() + " - " +
                clienteImprimir.getEndereco().getCep() + "\n" +
                "---------------------------------------------\n" +
                "Veículo: " + veiculoImprimir.getModelo() + " (" + veiculoImprimir.getMontadora() + ")\n" +
                "---------------------------------------------\n" +
                "Serviço: " + servicoImprimir.getDescricao() + "\n" +
                "Valor: R$ " + String.format("%.2f", servicoImprimir.getValor()) + "\n" +
                "---------------------------------------------\n" +
                "Funcionário Responsável: " + historicoServicoImprimir.getFuncionario().getNome() + "\n" +
                "CPF do Funcionário: " + historicoServicoImprimir.getFuncionario().getCpf() + "\n" +
                "Função: " + historicoServicoImprimir.getFuncionario().getFuncao() + "\n" +
                "=============================================\n");

    }
}