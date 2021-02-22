package academy.gama.apialunos.entity;

import java.util.List;

public class Aluno {

	private Long id;
	private String nome;
	private int cpf;
	private Endereco endereco;	
	private int telefone;
	private List<Curso> cursos;
}
