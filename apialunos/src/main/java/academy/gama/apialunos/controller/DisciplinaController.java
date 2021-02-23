package academy.gama.apialunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.service.DisciplinaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/disciplinas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaController {

	private DisciplinaService disciplinaService;

	@GetMapping
	private String get() {
		return "Estamos na API DISCIPLINA";
	}
}
