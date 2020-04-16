package br.ufc.banco.servico;
import java.util.Vector; 
import  br.ufc.banco.conta.*;
import br.ufc.banco.repositorio.*;

//Não utilizo na MAIN
public class BancoVector implements IBanco {
  private ContaAbstrata[] contas;
  private int indice = 0;
  boolean achou = false;

  public BancoVector(){
    Vector<ContaAbstrata> contas = new Vector<ContaAbstrata>();
  }

  public void cadastrar(ContaAbstrata conta){
    contas[indice] = conta;
    indice++;
  }

  public double numeroContas(){
    return indice;
  }

  public ContaAbstrata encontrarConta(String numero){
        for(ContaAbstrata i : contas){
            if(i.getNumero().equals(numero)){
                return i;
            }
        }
        return null;
    }

  public void creditar(String numero, double valor){
    ContaAbstrata conta = encontrarConta(numero);
     if (conta != null) {
       conta.creditar(valor); 
      } else {
       System.out.println("Conta Inexistente!");
     }
    
  }

  public void debitar(String numero, double valor){
    ContaAbstrata conta = encontrarConta(numero);
     if (conta != null) {
       conta.debitar(valor); 
      } else {
       System.out.println("Conta Inexistente!");
     }
  }

  public double saldo(String numero) {
    ContaAbstrata conta = encontrarConta(numero);
    if (conta!=null){
      return conta.getSaldo();
    }
    else{
      System.out.println("Conta Inexistente");
      return 0;
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
