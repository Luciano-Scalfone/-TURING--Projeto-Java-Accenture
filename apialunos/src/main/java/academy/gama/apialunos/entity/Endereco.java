package academy.gama.apialunos.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Endereco {
	private Long id;
	private Aluno aluno;
	private String cidade;
	private String UF;
	private int cep;
	private String rua;
	private int numero;
	private String complemento;
}
