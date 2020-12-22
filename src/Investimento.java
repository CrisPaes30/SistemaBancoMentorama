public class Investimento extends Conta {

    public void debito(double valor) {

        this.saldo = this.saldo - valor;

    }

    public String toString() {
        return "\n-------------\n" +
                "Conta Investimento:\nNúmero: " + this.agencia +
                "\nConta: " + Integer.toString(this.numero) +
                "\nSaldo: " + Double.toString(this.saldo) + "\n-------------";
    }

}