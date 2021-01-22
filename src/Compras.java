import java.util.List;

public class Compras {


    public List<Extrato> movimentacoes;
    public double saldo;
    protected double compras;

    public Compras(List<Extrato> movimentacoes, double saldo, double compras) {
        this.movimentacoes = movimentacoes;
        this.saldo = saldo;
        this.compras = compras;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }


    public Compras(double saldo) {
        this.saldo = saldo;
    }
}
