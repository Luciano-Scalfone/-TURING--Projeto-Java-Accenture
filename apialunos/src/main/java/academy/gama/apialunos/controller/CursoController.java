package academy.gama.apialunos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.service.CursoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/cursos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CursoController {

	private CursoService cursoService;

	@GetMapping
	private String get() {
		return "Estamos na API CURSOS";
	}
}
