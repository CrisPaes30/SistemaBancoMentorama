import java.util.Date;
import java.util.Random;

public class Extrato {

    private double compras;
    private Date Data;
    private String TipoTransacao;
    private double valor;


    public Extrato(Date data, String tipoTransacao, double valor, Double compra) {
        Data = data;
        TipoTransacao = tipoTransacao;
        this.valor = valor;
        Random valorComprarCliente = new Random();
        int x = valorComprarCliente.nextInt(8000);
        this.compras = x;
    }

    public Date getData() {
        return Data;
    }

    public String getTipoTransacao() {
        return TipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public Double getCompras() {

        return compras;
    }



}
