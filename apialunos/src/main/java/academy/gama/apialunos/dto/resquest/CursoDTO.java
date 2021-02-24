package academy.gama.apialunos.dto.resquest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 30)
	private String nome;
	
	@Valid
	private List<AlunoDTO> alunos;
	
	@Valid
	private List<DisciplinaDTO> disciplinas;
}
