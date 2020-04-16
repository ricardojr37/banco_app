package br.ufc.banco.repositorio;
import br.ufc.banco.conta.*;

public interface IRepositorioContas {
    public void cadastrar(ContaAbstrata conta);
    public double numeroContas();
    public ContaAbstrata encontrarConta(String numero);
    public double saldo();
} 