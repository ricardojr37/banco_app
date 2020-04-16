package br.ufc.banco.repositorio;
import br.ufc.banco.conta.*;
import java.util.Vector;

public class VectorContas implements IRepositorioContas {
	
	protected Vector<ContaAbstrata> contas;
  double saldo = 0;
  int nContas = 0;


	public VectorContas() {
		contas = new Vector<ContaAbstrata>();
	}

	public ContaAbstrata encontrarConta(String numero){
		for(ContaAbstrata i : contas){
			if(i.getNumero().equals(numero)){
				return i;
			}
		}
		return null;
	}

	public void cadastrar(ContaAbstrata conta){
		if(encontrarConta(conta.getNumero()) != null){
			System.out.println("Conta já existe");
		}
		else{
			contas.add(conta);		
		}
	}

	public double saldo(){
		for(ContaAbstrata i : contas){
			saldo += i.getSaldo();
		}
		return saldo;
	}

	public double numeroContas(){
		for(ContaAbstrata  i : contas){
			nContas += 1;
		}
		return nContas;
	}

}