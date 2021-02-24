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
	private float nota_um;
	
	@Size(max = 2)
	private float nota_dois;
	
	@Size(max = 2)
	private float nota_apresentacao;
	
	@Size(max = 2)
	private float nota_trabalho;
	
	private float media_conceito;

	@Enumerated(EnumType.STRING)
	private StatusAprovacao statusAprovacao;

	@Valid
	@NotEmpty
	private AlunoDTO alunoDTO;

	@Valid
	@NotEmpty
	private DisciplinaDTO disciplinaDTO;
}
