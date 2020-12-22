public class Corrente extends Conta implements Impostos{

    private double Impostos;

    public void debito(double valor) {

        IMPOSTOS();
        double cpmf = valor * 0.38 / 100;

        this.saldo = this.saldo - valor - cpmf;

    }

    public String toString() {
        return "\n-------------\n" +
                "Conta Corrente:\nNúmero: " + this.agencia +
                "\nConta: " + Integer.toString(this.numero) +
                "\nSaldo: " + Double.toString(this.saldo) + "\n-------------\n";
    }

    @Override
    public double IMPOSTOS() {
        return Impostos * 0.02;
    }

    @Override
    public double IMPOSTOSCONTAPOUPANCA() {
        return 0;
    }
}