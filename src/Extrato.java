import java.util.Date;

public class Extrato {

    private Date Data;
    private String TipoTransacao;
    private double valor;

    public Extrato(Date data, String tipoTransacao, double valor) {
        Data = data;
        TipoTransacao = tipoTransacao;
        this.valor = valor;
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
}
