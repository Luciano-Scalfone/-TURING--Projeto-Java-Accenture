package academy.gama.apialunos.dto.resquest;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import academy.gama.apialunos.enums.StatusAprovacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotaDTO {

	private Long id;
	
	@Size(max = 2)
	private String nota_um;
	
	@Size(max = 2)
	private String nota_dois;
	
	@Size(max = 2)
	private String nota_apresentacao;
	
	@Size(max = 2)
	private String nota_trabalho;
	
	private String media_conceito;

	@Enumerated(EnumType.STRING)
	private StatusAprovacao statusAprovacao;

	@Valid
	@NotEmpty
	private AlunoDTO aluno;

	@Valid
	@NotEmpty
	private DisciplinaDTO disciplina;
}
