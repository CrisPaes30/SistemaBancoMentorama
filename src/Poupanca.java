public class Poupanca extends Conta {

    public void debito(double valor) {

        this.saldo = this.saldo - valor;

    }

    public String toString() {
        return "\n-------------\n" +
                "Conta Poupança:\nNúmero: " + this.agencia +
                "\nConta: " + Integer.toString(this.numero) +
                "\nSaldo: " + Double.toString(this.saldo) + "\n-------------";
    }

}