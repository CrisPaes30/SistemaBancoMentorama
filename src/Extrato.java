import java.util.Date;

public class Extrato{

    //private final int saldoInicial;
    private Date Data;
    private String TipoTransacao;
    private double valor;
    private double compras;

    public Extrato(int saldoInicial, Date data, String tipoTransacao, double valor, double compras) {
        //this.saldoInicial = saldoInicial;
        Data = data;
        TipoTransacao = tipoTransacao;
        this.valor = valor;
        this.compras = compras;
    }

    public Extrato(Date date, String credito, double saldoInicial) {
    }

//    public Extrato(Date date, String debito, double saldoInicial){
//        date = date;
//        debito = debito;
//        this.saldoInicial = 0;
//    }

//    public Extrato(Date date, String credito, double saldoInicial) {
//    }

    public Date getData() {
        return Data;
    }

    public String getTipoTransacao() {
        return TipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }
}
