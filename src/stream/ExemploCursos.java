package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Curso {
	
	private String nome;
	private int alunos;
	
	
	
	//construtor com dois atributos um construtor que recebe e popula
	//os dois argumentos
	public Curso(String nome, int alunos) {
	this.nome=nome;
	this.alunos=alunos;
	
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAlunos() {
		return alunos;
	}


	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	


}
	public class ExemploCursos {
		
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//ORDENAR OS CURSOS
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(c-> System.out.println(c.getNome()));
		
		
		System.out.println(" ----------------");
		//ordenar os cursos que tem mais de 100 alunos
		//toda collection tem um método que se chama stream
		cursos.stream().filter(c->c.getAlunos()>=100)
			  .forEach(c->System.out.println(c.getNome()));
		
		System.out.println(" ----------------");
		cursos.stream().filter(c->c.getAlunos()>=100)
		      .map(c->c.getAlunos())
		      .forEach(total-> System.out.println(total));
		
		System.out.println(" ------- <56---------");
		
		int soma = cursos.stream()                            
				      .filter(c->c.getAlunos()<56)
	                  .mapToInt(Curso::getAlunos)
	                  .sum();
		System.out.println(soma);
		
		System.out.println(" ----------------");
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .forEach(c -> System.out.println(c.getNome()));
		
		System.out.println(" ----------------");
		
		//transformar o Stream<Curso> em um Stream<String> contendo apenas dois cursos
	
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		Optional<Curso> optionalCurso = Optional.empty();
	}
	
	
	}
	
