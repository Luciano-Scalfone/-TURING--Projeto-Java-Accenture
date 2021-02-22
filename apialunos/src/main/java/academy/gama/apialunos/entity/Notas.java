package academy.gama.apialunos.entity;

import academy.gama.apialunos.controller.StatusAprovacao;

public class Notas {
	
	private Long id;
	private float nota1;
	private float nota2;
	private float apresentacao;
	private float trabalho;
	private float conceito;
	private StatusAprovacao statusAprovacao;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public float getConceito() {
		return Math.round(conceito);
	}
	
	public void setConceito(float conceito) {
		this.conceito =  (nota1 + nota2 + apresentacao + trabalho) / 4;
	}

	
}
