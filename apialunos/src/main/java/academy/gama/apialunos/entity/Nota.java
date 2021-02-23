package academy.gama.apialunos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import academy.gama.apialunos.enums.StatusAprovacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private float nota_um;
	
	@Column
	private float nota_dois;
	
	@Column
	private float nota_apresentacao;
	
	@Column
	private float nota_trabalho;
	
	@Column
	private float media_conceito;
	
	@Column
	private StatusAprovacao statusAprovacao;
	
	@OneToOne
	private Aluno aluno;
	
	@OneToOne
	private Disciplina disciplina;

	public float getMedia_conceito() {
		return Math.round(media_conceito);
	}

	public void setMedia_conceito(float media_conceito) {
		this.media_conceito = (nota_um + nota_dois + nota_apresentacao + nota_trabalho) / 4;
	}
	
}
