package academy.gama.apialunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/alunos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {

	private AlunoService alunoService;

	@PostMapping
	public Aluno create(Aluno aluno) {
		return alunoService.create(aluno);
	}

	@GetMapping
	public String getAll() {
		System.out.println("vamos listar???");
		return "Lista de Alunos";
	}

	@GetMapping("/{id}")
	public void findById() {

	}

	@DeleteMapping("/{id}")
	public void deleteById() {

	}
	
	@PutMapping("/{id}")
	public void updateById() {

	}

}
