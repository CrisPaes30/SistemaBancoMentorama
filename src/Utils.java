import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Utils {


    private static List<Cliente> geradorClientes() {
        return List.of(
                new Cliente("João", "MERCADO", 1100.00),
                new Cliente("Pedro", "ESCOLA", 850.65),
                new Cliente("Maria", "FEIRA", 153.55),
                new Cliente("Julia", "CARRO", 755.55),
                new Cliente("Antonio", "MERCADO", 23.25),
                new Cliente("Marcus", "LOJA", 100.00),
                new Cliente("Vander", "VIAGEM", 9255.22),
                new Cliente("Thiago", "VIAGEM", 1599.22),
                new Cliente("Mateus", "MERCADO", 15.22),
                new Cliente("Roberto", "FEIRA", 10.00),
                new Cliente("Antoni", "CURSO", 322.15),
                new Cliente("Gustavo", "ESCOLA", 165.25),
                new Cliente("Carlos", "MERCADO", 100.00)
        );


    }

    private LinkedHashMap<String, Contas> geradorContasClientes(List<Cliente> listaClientes) {
        LinkedHashMap<String, Contas> listaContas = new LinkedHashMap<>();

        var count = 1;

        for (Cliente cliente : listaClientes) {

            var contas = new Contas();

            if (count % 2 == 0) {

                var corrente = new Corrente();
                corrente.criarConta(cliente, gerarValorRandom());


                var poupanca = new Poupanca();
                poupanca.criarConta(cliente, gerarValorRandom());

                contas.setCorrente(corrente);
                contas.setPoupanca(poupanca);
            } else {

                var salario = new Salario();
                salario.criarConta(cliente, gerarValorRandom());

                contas.setSalario(salario);
            }

            if (count == 2) {
                var investimento = new Investimento();
                investimento.criarConta(cliente, gerarValorRandom());
                contas.setInvestimento(investimento);
            }

            listaContas.put(String.valueOf(cliente), contas);

            count++;
        }

        return listaContas;
    }

    public LinkedHashMap<String, Contas> gerarClientes() {
        var listaClientes = geradorClientes();
        return geradorContasClientes(listaClientes);
    }

    public void imprimirListaClientes(LinkedHashMap<String, Contas> listaClientes) {
        System.out.println("Lista de Clientes: \n");

        for (String key : listaClientes.keySet()) {
            System.out.println("Nome: " + key);
        }
    }

    public void imprimirDadosContasPorCliente(Contas contasCliente) {

        if (contasCliente.getCorrente() != null) {
            System.out.println(contasCliente.getCorrente().toString());
        }

        if (contasCliente.getSalario() != null) {
            System.out.println(contasCliente.getSalario().toString());
        }

        if (contasCliente.getPoupanca() != null) {
            System.out.println(contasCliente.getPoupanca().toString());
        }

        if (contasCliente.getInvestimento() != null) {
            System.out.println(contasCliente.getInvestimento().toString());
        }
    }

    public void imprimirSaldoGeralBanco(LinkedHashMap<String, Contas> listaClientes) {

        double corrente = 0;
        double poupanca = 0;
        double investimento = 0;
        double salario = 0;

        for (Contas conta : listaClientes.values()) {
            corrente += conta.getCorrente() != null ? conta.getCorrente().saldo : 0;
            salario += conta.getSalario() != null ? conta.getSalario().saldo : 0;
            poupanca += conta.getPoupanca() != null ? conta.getPoupanca().saldo : 0;
            investimento += conta.getInvestimento() != null ? conta.getInvestimento().saldo : 0;
        }

        System.out.println("Saldo total banco: " + (corrente + salario + poupanca + investimento));
    }

    public void Movimentacoes(Contas contasCliente) {

        if (contasCliente.getCorrente() != null) {
            System.out.println("\n Movimentações conta corrente ->");
            toExtrato(contasCliente.getCorrente().movimentacoes);
        }

        if (contasCliente.getSalario() != null) {
            System.out.println("\n Movimentações conta salario ->");
            toExtrato(contasCliente.getSalario().movimentacoes);
        }

        if (contasCliente.getPoupanca() != null) {
            System.out.println("\n Movimentações conta poupanca ->");
            toExtrato(contasCliente.getPoupanca().movimentacoes);
        }

        if (contasCliente.getInvestimento() != null) {
            System.out.println("\n Movimentações conta investimento ->");
            toExtrato(contasCliente.getInvestimento().movimentacoes);
        }
    }


    public void RankingMaiorValorCompra(LinkedHashMap<String, Contas> listaCompras) {
        System.out.println("Maiores Compras dos Clientes");


        geradorClientes().stream()
                .filter(cliente -> cliente.getValorDaCompra() > 1000.00)
                .limit(3)
                .sorted(Comparator.comparing(Cliente::getNome))
                .collect(Collectors.toList())
                .forEach(x -> System.out.println("Cliente Valor: "
                        + x.getNome() + " " + "R$" + x.getValorDaCompra()));

        System.out.println(" ");
        System.out.println("Menores Compras dos Clientes");
        System.out.println(" ");

        geradorClientes().stream()
                .filter(cliente -> cliente.getValorDaCompra() < 300.00)
                .limit(3)
                .sorted(Comparator.comparing(Cliente::getNome))
                .collect(Collectors.toList())
                .forEach(x -> System.out.println("Cliente Valor: "
                        + x.getNome() + " " + "R$" + x.getValorDaCompra()));
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("Media De Compras");
        System.out.println(" ");

        geradorClientes().stream().mapToDouble(Cliente::getValorDaCompra).average()
                .stream().forEach(x -> System.out.printf("%.2f", +x).println(" Media de Compras "));

    }

    public void toExtrato(List<Extrato> movimentacoes) {

        System.out.println("\n |    Data    | Operação  |  Valor  | ");

        for (Extrato extrato : movimentacoes) {
            System.out.println(" | " + new SimpleDateFormat("yyyy-MM-dd").format(extrato.getData()) +
                    " | " + extrato.getTipoTransacao() + "   |  "
                    + extrato.getValor() + "  | ");
        }
    }

    private double gerarValorRandom() {
        var min = 30;
        var max = 1000;
        var x = (Math.random() * ((max - min) + 1)) + min;
        return Math.round(x);
    }


}