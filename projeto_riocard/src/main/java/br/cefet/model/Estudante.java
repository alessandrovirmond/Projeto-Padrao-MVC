package br.cefet.model;

public class Estudante {

	private int id;
	private String nome;
	private int matricula;
	
	public Estudante(String nome, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Estudante() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
