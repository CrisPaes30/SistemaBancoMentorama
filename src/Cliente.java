import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Cliente{

    private String nome;
    private String compraCartão;
    private double valorDaCompra;



    public double getValorDaCompra() {

        return valorDaCompra;
    }

    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCompraCartão() {

        return compraCartão;
    }

    public void setCompraCartão(String compraCartão) {
        this.compraCartão = compraCartão;
    }


    public Cliente(String nome, String compraCartão, double valorDaCompra) {
        this.nome = nome;
        this.compraCartão = compraCartão;
        this.valorDaCompra = valorDaCompra;
    }


}
