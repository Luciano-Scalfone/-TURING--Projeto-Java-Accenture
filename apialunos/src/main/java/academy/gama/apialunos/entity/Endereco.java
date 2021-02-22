package academy.gama.apialunos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Endereco {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String cidade;
	
	@Column
	private String UF;
	
	@Column
	private int cep;
	
	@Column
	private String rua;
	
	@Column
	private int numero;
	
	@Column
	private String complemento;
	
	@OneToOne
	private Aluno aluno;
}
