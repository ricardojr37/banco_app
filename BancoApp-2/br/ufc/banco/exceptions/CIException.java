package br.ufc.banco.exceptions;

public class CIException extends Exception {
  public String numero;

  public CIException(String numero){
    super("Conta Inexistente");
    this.numero = numero;
  }
}