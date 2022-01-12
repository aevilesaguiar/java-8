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
		palavras.add("editora casa do código");
		palavras.add("caellum");
		
		System.out.println("Com Collections método sort");
		Collections.sort(palavras);
		
		System.out.println(palavras);
		System.out.println("Finalizado");
		System.out.println("");
		System.out.println("");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras,comparador);//ao invés de usar a comparação natural da própria String
												//nós usamos o novo critério
		//Na nova versão do java ele tem o método sort
		
		System.out.println("Método sort que tem no list");
		palavras.sort(comparador);//List tem um método que se chama sort
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
		
		//se o primeiro elemento for vir antes do segundo elemento você retorna um numero negativo
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


