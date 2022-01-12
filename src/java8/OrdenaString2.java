package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString2 {

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
		
//lambda consegue ser convertido para uma interface funcional
		palavras.sort((s1,s2)->{
			return Integer.compare(s1.length(), s2.length());
		});
		System.out.println(palavras);
		
		Consumer<String> impressor = s->System.out.println(s);
		palavras.forEach(impressor);
		
		//lambda 
		palavras.forEach(s-> System.out.println(s));
	}

}
