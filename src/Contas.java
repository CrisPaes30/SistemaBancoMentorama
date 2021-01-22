public class Contas {
    public Corrente corrente;
    public Poupanca poupanca;
    public Investimento investimento;
    public Salario salario;
    public Compras compras;


    public Contas() {
        this.corrente = corrente;
        this.poupanca = poupanca;
        this.investimento = investimento;
        this.salario = salario;
    }

    public Corrente getCorrente() {
        return corrente;
    }

    public void setCorrente(Corrente corrente) {
        this.corrente = corrente;
    }

    public Poupanca getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Poupanca poupanca) {
        this.poupanca = poupanca;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

   public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }
}
