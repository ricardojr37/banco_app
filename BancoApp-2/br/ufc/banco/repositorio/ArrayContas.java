package br.ufc.banco.repositorio;
import br.ufc.banco.conta.*;

 public class ArrayContas implements IRepositorioContas{ 
  private ContaAbstrata[] contas;
  private int indice = 0;
  int i = 0;
  boolean achou = false;
  
  public ArrayContas(){
    contas = new ContaAbstrata[100];
  }
  
  public void cadastrar(ContaAbstrata conta){
    contas[indice] = conta;
    indice++;
  }

  public double numeroContas(){
    return indice;
  }

  public ContaAbstrata encontrarConta(String numero){
    i = 0;
    achou = false;
    while ((!achou) && (i < indice)) {
      if (contas[i].getNumero().equals(numero)) {
        achou = true;
      } else {
          i++;
      }
    }
    if (achou == true) {
      return contas[i];
    } else {
      return null;
    }
  }

  public double saldo(){
		double saldo = 0;
		for(int j = 0; j < indice; j++){
			saldo += contas[j].getSaldo();
		}
		return saldo;
	}
 }