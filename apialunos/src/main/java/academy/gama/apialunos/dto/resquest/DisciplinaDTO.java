package academy.gama.apialunos.dto.resquest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {

	private Long id;
	
	@NotEmpty
	private String nome;
	
	@Valid
	private CursoDTO cursoDTO;
}
