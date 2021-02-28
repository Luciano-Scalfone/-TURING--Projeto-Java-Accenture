package academy.gama.apialunos.dto.resquest;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;

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
	
	private String nota_um;

	private String nota_dois;

	private String nota_apresentacao;

	private String nota_trabalho;
	
	private String media_conceito;

	@Enumerated(EnumType.STRING)
	private StatusAprovacao statusAprovacao;

	@Valid
	private AlunoDTO aluno;

	@Valid
	private DisciplinaDTO disciplina;
}
