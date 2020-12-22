import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    private List<Cliente> geradorClientes(){
        List<Cliente> lista = new ArrayList<>();

        lista.add(new Cliente("João"));
        lista.add(new Cliente("Pedro"));
        lista.add(new Cliente("Maria"));
        lista.add(new Cliente("Julia"));

        return lista;
    }

    private LinkedHashMap<String, Contas> geradorContasClientes(List<Cliente> listaClientes){
        LinkedHashMap<String, Contas> listaContas = new LinkedHashMap<>();

        var count = 1;

        for (Cliente cliente : listaClientes ) {

            var contas = new Contas();

            if(count % 2 == 0){

                var corrente = new Corrente();
                corrente.criarConta(cliente, gerarValorRandom());

                var poupanca = new Poupanca();
                poupanca.criarConta(cliente, gerarValorRandom());

                contas.setCorrente(corrente);
                contas.setPoupanca(poupanca);
            }else {

                var salario = new Salario();
                salario.criarConta(cliente, gerarValorRandom());

                contas.setSalario(salario);
            }

            if(count == 2) {
                var investimento = new Investimento();
                investimento.criarConta(cliente, gerarValorRandom());
                contas.setInvestimento(investimento);
            }

            listaContas.put(cliente.getNome(), contas);

            count++;
        }

        return listaContas;
    }

    public LinkedHashMap<String, Contas> gerarClientes(){
        var listaClientes = geradorClientes();
        return geradorContasClientes(listaClientes);
    }

    public void imprimirListaClientes(LinkedHashMap<String, Contas> listaClientes){
        System.out.println("Lista de Clientes: \n");

        for (String key : listaClientes.keySet()) {
            System.out.println("Nome: " + key);
        }
    }

    public void imprimirDadosContasPorCliente(Contas contasCliente){

        if(contasCliente.getCorrente() != null){
            System.out.println(contasCliente.getCorrente().toString());
        }

        if(contasCliente.getSalario() != null){
            System.out.println(contasCliente.getSalario().toString());
        }

        if(contasCliente.getPoupanca() != null){
            System.out.println(contasCliente.getPoupanca().toString());
        }

        if(contasCliente.getInvestimento() != null){
            System.out.println(contasCliente.getInvestimento().toString());
        }
    }

    public void imprimirSaldoGeralBanco(LinkedHashMap<String, Contas> listaClientes){

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

    public void Movimentacoes(Contas contasCliente){

        if(contasCliente.getCorrente() != null){
            System.out.println("\n Movimentações conta corrente ->");
            toExtrato(contasCliente.getCorrente().movimentacoes);
        }

        if(contasCliente.getSalario() != null){
            System.out.println("\n Movimentações conta salario ->");
            toExtrato(contasCliente.getSalario().movimentacoes);
        }

        if(contasCliente.getPoupanca() != null){
            System.out.println("\n Movimentações conta poupanca ->");
            toExtrato(contasCliente.getPoupanca().movimentacoes);
        }

        if(contasCliente.getInvestimento() != null){
            System.out.println("\n Movimentações conta investimento ->");
            toExtrato(contasCliente.getInvestimento().movimentacoes);
        }
    }

    public void toExtrato(List<Extrato> movimentacoes) {

        System.out.println("\n |    Data    | Operação  |  Valor  | ");

        for (Extrato extrato : movimentacoes) {
            System.out.println(" | " + new SimpleDateFormat("yyyy-MM-dd").format(extrato.getData()) +
                    " | " + extrato.getTipoTransacao() +  "   |  "
                     + extrato.getValor() + "  | ");
        }
    }
    
    private double gerarValorRandom(){
        var min = 30;
        var max = 1000;
        var x = (Math.random() * ((max - min) + 1)) + min;
        return Math.round(x);
    }
}
