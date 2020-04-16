package br.ufc.banco.conta;

public class ContaEspecial extends Conta{
    private double bonus;

    public ContaEspecial(String numero){
        super(numero);
        bonus = 0;
    }

    public void renderBonus(){
        super.creditar(bonus);
        bonus = 0;
    }

    public void creditar(double valor){
        bonus = bonus + valor*0.1;
        super.creditar(valor);
    }
}