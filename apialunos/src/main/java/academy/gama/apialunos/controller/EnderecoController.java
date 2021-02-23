package academy.gama.apialunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.dto.resquest.AlunoDTO;
import academy.gama.apialunos.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/enderecos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoController {

	private AlunoService alunoService;
	
	@GetMapping
	private String get() {
		return "Estamos na API ENDEREÇOS";
	}
//	public List<AlunoDTO> getAll() {
//		return alunoService.listAll();
//	}
}
