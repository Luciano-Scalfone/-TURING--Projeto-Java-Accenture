package academy.gama.apialunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.service.AlunoService;
import academy.gama.apialunos.service.NotaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/notas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotaController {

	private NotaService notaService;
	
	@GetMapping
	private String get() {
		return "Estamos na API NOTAS";
	}
}
