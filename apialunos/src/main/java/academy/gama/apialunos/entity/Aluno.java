package academy.gama.apialunos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private int cpf;
	
	@Column(unique = true)
	private int telefone;

	@OneToOne
	private Endereco endereco;
	
	@OneToOne
	private Nota nota;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos;
	
}
