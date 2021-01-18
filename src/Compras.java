import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compras {


    protected Stream<Compras> comprasStream;
    protected List<Extrato> movimentacoes;
    protected double Compras;
    protected double valorCompra;

    public Compras(double compras, double valorCompras) {
        Compras = compras;
        Random valorComprasCliente = new Random();
        int debito = valorComprasCliente.nextInt(8000);
        this.valorCompra = debito;
    }


    public List<Extrato> getMovimentacoes() {
        return movimentacoes;
    }

    public double getCompras() {
        return Compras;
    }

    public void setCompras(double compras) {
        Compras = compras;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void filtros(List<Compras> comprasClientes) {

        for (Extrato x : movimentacoes) {
            Stream<Compras> filtros1 = (Stream<Compras>) movimentacoes.stream()
                    .filter(compras -> getCompras()>100)
                    .collect(Collectors.toList());
            filtros1.forEach(System.out::print);
        }

    }

}

