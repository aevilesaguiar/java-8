package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do c�digo");
		palavras.add("caellum");

		Collections.sort(palavras);
		System.out.println(palavras);

		
		// Collections.sort(palavras,comparador);//ao inv�s de usar a compara��o natural
		// da pr�pria String
		// n�s usamos o novo crit�rio
		// Na nova vers�o do java ele tem o m�todo sort

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		}
	
}
