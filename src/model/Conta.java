package model;

public abstract class Conta {

    private int agencia;
    private int conta;
    private float saldo;
    private Cliente cliente;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String sacar(float valor){
        if(this.saldo - valor < 0){
            return "SALDO INSUFICIENTE!";
        } else {
            this.saldo -= valor;
            return "SAQUE EFETUADO!";
        }
    }
    
    public String depositar(float valor) {
        this.saldo += valor;
        return "DEPOSITO EFETUADO";
    }
    
    public String transferir(Conta conta, float valor){
        if(this.saldo - valor < 0){
            return "SALDO INSUFICIENTE!";   
        } else {
            this.sacar(valor);
            conta.depositar(valor);
        }
        return "TRANSFERENCIA EFETUADA!";
    }

    @Override
    public String toString() {
        return "Conta{" + "agencia=" + agencia + ", conta=" + conta + ", saldo=" + saldo + '}';
    }
    
}
    
  