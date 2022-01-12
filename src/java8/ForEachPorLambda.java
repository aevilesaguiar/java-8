package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ForEachPorLambda {

	public static void main(String[] args) {
		List <String> palavras = new  ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do c�digo");
		palavras.add("caellum");
		
		
		palavras.forEach((Consumer<? super String>) new Consumer<String>(){
		    public void accept(String palavra) {
		        System.out.println(palavra);
		    }
		});
		
		//nova sintaxe
		System.out.println("");
		System.out.println("NOVA SINTAXE");
		
		palavras.forEach(s -> System.out.println(s));
	
	//Transforme esse Comparator em uma express�o lambda.
		System.out.println("");
		System.out.println("Transforme esse Comparator em uma express�o lambda.");
	palavras.sort(new Comparator<String>() {
	    @Override
	    public int compare(String s1, String s2) {
	        if(s1.length() < s2.length()) 
	            return -1;
	        if(s1.length() > s2.length()) 
	            return 1;
	        return 0;
	    }
	});
	//nova sintaxe
	//Conhecendo a API, uma op��o mais interessante � utilizar o Integer.compare():
			System.out.println("");
			System.out.println("NOVA SINTAXE");
			
			palavras.sort((s1, s2) -> {
			    return Integer.compare(s1.length(), s2.length()); 
			});
			
		//podemos melhorar
			
			palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
			System.out.println(palavras);
			
			//At� podemos fugir do m�todo compare, subtraindo os valores:
			palavras.sort((s1, s2) -> s1.length() - s2.length());
			System.out.println(palavras);
			
			palavras.sort(Comparator.comparing(s ->s.length()));
			System.out.println(palavras);
			
			//posso fazer no m�todo antigo
			
			Function<String, Integer> funcao = s -> s.length();
			Comparator<String> comparador = Comparator.comparing(funcao);
			palavras.sort(comparador);
			System.out.println(palavras);
			//metodo reference
			palavras.sort(Comparator.comparing(String :: length));//palavras ordene comparando com o tamanho da string
			Function<String, Integer> funcao2=s-> s.length();
			
			palavras.forEach(System.out::println);
			
			//Modifique a forma que estamos fazendo o sort das palavras utilizando o Comparator.comparing().
			palavras.sort((s1, s2) -> {
			    return Integer.compare(s1.length(), s2.length()); 
			});
			//Como ele ficou ap�s as suas mudan�as? O que voc� achou dessa forma de criar Comparators?
			
			palavras.sort(Comparator.comparing(s -> s.length()));
			
			//Mude o lambda que voc� escreveu no m�todo comparing para um method reference.
			palavras.sort(Comparator.comparing(String::length));
			
			palavras.sort(String.CASE_INSENSITIVE_ORDER);
			System.out.println(palavras);
			
			palavras.forEach(System.out::println);
	}
}
