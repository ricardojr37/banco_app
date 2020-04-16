package br.ufc.banco.servico;
import  br.ufc.banco.conta.*;
import br.ufc.banco.repositorio.*;
import br.ufc.banco.exceptions.*;

//Utilizo na main, sendo meu BancoIndependente
public class BancoArray implements IBanco {
  IRepositorioContas repositorio;

  public BancoArray (IRepositorioContas contas){
    repositorio = contas;
  }

  public void cadastrar(ContaAbstrata conta){
    repositorio.cadastrar(conta);
  }

  public ContaAbstrata encontrarConta(String numero){
    return repositorio.encontrarConta(numero);
  }
  
  public double numeroContas(){
    return repositorio.numeroContas();
  }

  public void creditar(String numero, double valor) throws CIException{
    ContaAbstrata conta = encontrarConta(numero);
      if (conta == null) {
        throw new CIException(numero);
      } else {
       conta.creditar(valor);
      }
     
    
  }

  public void debitar(String numero, double valor) throws CIException, SIException{
    ContaAbstrata conta = encontrarConta(numero);
     if (conta == null) {
       throw new CIException(numero);
      } else if(conta.getSaldo() < valor){
          throw new SIException(numero, valor);
        }
        else {
          conta.debitar(valor); 
     }
  }

  public double saldo(String numero) throws CIException {
    ContaAbstrata conta = encontrarConta(numero);
    if (conta == null) {
       throw new CIException(numero);
      } 
        else {
          return conta.getSaldo(); 
     }
  }

  public void transferir(String origem, String destino, double valor) {
    ContaAbstrata conta_o = encontrarConta(origem);
    ContaAbstrata conta_d = encontrarConta(destino);
    if (conta_o != null && conta_d != null){
      conta_o.debitar(valor);
      conta_d.creditar(valor);
    }
    else {
      System.out.println("Falha na transferência");
    }
  }

   public void renderContaPoupanca(String numero, double taxa){
        if (encontrarConta(numero) instanceof ContaPoupanca){ 
            ((ContaPoupanca)encontrarConta(numero)).renderJuros(taxa);
        }
        else {
            System.out.println("A conta não existe...");
        }
    }

    public void renderContaEspecial(String numero){
        if (encontrarConta(numero) instanceof ContaEspecial){ 
            ((ContaEspecial)encontrarConta(numero)).renderBonus();
        }
        else {
            System.out.println("A conta não existe...");
        }
    }
}