package br.ufc.banco.conta;
import java.io.Serializable;

public abstract class ContaAbstrata implements Serializable {
 protected String numero;
 protected double saldo;
 
 public ContaAbstrata(String numero){
  this.numero = numero;
  saldo = 0;
 }

 public void creditar(double valor) {
  saldo = saldo + valor;
 }

 public void debitar(double valor){
    saldo = saldo - valor; 
 }

 public String getNumero(){
  return numero;
 }

 public double getSaldo(){
  return saldo;
 }

} 