import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class Conta {

    protected int numero;
    protected String agencia;
    protected double saldo;
    protected Cliente cliente;
    protected List<Extrato> movimentacoes;
    public List<Extrato> compras;

    public Conta() {
        this.numero = 0;
        this.agencia = "0001";
        this.saldo = 0;
        this.cliente = null;
        this.movimentacoes = new ArrayList<>();
        this.compras =new ArrayList<>();

    }

    public void criarConta(Cliente cliente, double saldoInicial) {
        Random random = new Random();
        int numConta = random.nextInt(1000000);
        String numAgencia = "0001";
        this.cliente = cliente;
        this.numero = numConta;
        this.agencia = numAgencia;
        this.saldo = saldoInicial;

        if(saldoInicial > 0){
            movimentacoes.add(new Extrato(new Date(), "credito", saldoInicial));
            //compras.add(new Extrato(new Date(), "debito", saldoInicial));
        }
    }

    public void credito(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void transferirParaAConta(double valor, Conta conta) {

        this.debito(valor);
        conta.credito(valor);

    }

    public abstract void debito(double valor);

}