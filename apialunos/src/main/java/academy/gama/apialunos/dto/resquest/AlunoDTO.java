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
public class AlunoDTO {

	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	@Size(min = 11, max = 11)
	private String cpf;
	private String telefone;
	
	@Valid
	private EnderecoDTO enderecoDTO;

	@Valid
	private NotaDTO notaDTO;

	@Valid
	private List<CursoDTO> cursosDTO;
}
