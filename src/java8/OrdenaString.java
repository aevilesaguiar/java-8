package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {

	public static void main(String[] args) {
		List <String> palavras = new  ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do c�digo");
		palavras.add("caellum");
		
		System.out.println("Com Collections m�todo sort");
		Collections.sort(palavras);
		
		System.out.println(palavras);
		System.out.println("Finalizado");
		System.out.println("");
		System.out.println("");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras,comparador);//ao inv�s de usar a compara��o natural da pr�pria String
												//n�s usamos o novo crit�rio
		//Na nova vers�o do java ele tem o m�todo sort
		
		System.out.println("M�todo sort que tem no list");
		palavras.sort(comparador);//List tem um m�todo que se chama sort
		System.out.println(palavras);
		
		//foreach antigo
		
//		for (String p : palavras) {
//			System.out.println(p);
//
//		}
//		foreach nova forma de iterar
		System.out.println("");
		System.out.println("");
		System.out.println("foreach nova forma de iterar usando Consumer");
		Consumer<String> consumidor= new ImprimeNALinha();
		palavras.forEach(consumidor);
		
		

	}

}
class ImprimeNALinha implements Consumer<String>{
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
}

class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
		//se o primeiro elemento for vir antes do segundo elemento voc� retorna um numero negativo
		//se ele vier depois do segundo elemento ele retorna um numero positivo
		//se der um empate dar 0
		if(s1.length()< s2.length()) {
			return -1;
		}
		
		if(s1.length()>s2.length()) {
			return 1;
		}
		return 0;
	}


}


