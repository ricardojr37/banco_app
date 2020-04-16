package br.ufc.banco.repositorio;
import java.util.Vector;
import br.ufc.banco.conta.ContaAbstrata;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileConta extends VectorContas {
	private File file;

	public FileConta(){
		try{
			file = new File("contas.txt");
			FileInputStream fil = new FileInputStream(file);
      System.out.println("1");
			ObjectInputStream obj = new ObjectInputStream(fil);
      System.out.println("2");
			contas = (Vector<ContaAbstrata>) obj.readObject();
      System.out.println("3");
			obj.close();
      System.out.println("4");
			fil.close();
      System.out.println("5");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encotrado");
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void gravar(){
		try {
			FileOutputStream fi = new FileOutputStream(file);
			ObjectOutputStream ob = new ObjectOutputStream(fi);
			ob.writeObject(contas);
			ob.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("Erro de Inicialização");
		}
	}
}