package br.ufc.banco.conta;

public class Conta extends ContaAbstrata {
 public Conta(String numero){
  super(numero);
 }
 
 public void debitar(double valor){
  super.debitar(valor);
  }
}