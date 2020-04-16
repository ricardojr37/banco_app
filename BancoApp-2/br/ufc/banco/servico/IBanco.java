package br.ufc.banco.servico;
import br.ufc.banco.conta.*;
import br.ufc.banco.repositorio.*;
import br.ufc.banco.exceptions.*;

public interface IBanco {
    public double numeroContas();
    public void cadastrar(ContaAbstrata conta);
    public ContaAbstrata encontrarConta(String numero);
    public void creditar(String numero, double valor) throws CIException;
    public void debitar(String numero, double valor) throws CIException, SIException;
    public double saldo(String numero) throws CIException;
    public void transferir(String origem, String destino, double valor);
} 