package br.ufc.banco.exceptions;

public class SIException extends Exception {
  public String numero;
  public double saldo;

  public SIException(String numero, double saldo){
    super("Saldo Insuficiente");
    this.numero = numero;
    this.saldo = saldo;
  }

}