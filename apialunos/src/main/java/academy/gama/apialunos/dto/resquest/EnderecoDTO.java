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
public class EnderecoDTO {

	private Long id;
	
	@NotEmpty
	private String cidade;
	
	@NotEmpty
	private String uf;
	
	@NotEmpty
	private String cep;
	
	@NotEmpty
	private String rua;
	
	@NotEmpty
	private String numero;
	
	@NotEmpty
	private String complemento;
	
	@Valid
	private AlunoDTO aluno;
}
