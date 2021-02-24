package academy.gama.apialunos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.CursoDTO;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.service.CursoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/cursos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CursoController {

	private CursoService cursoService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid CursoDTO itemDTO) {
		return cursoService.create(itemDTO);
	}

	@GetMapping
	public List<CursoDTO> getAll() {
		return cursoService.listAll();
	}

	@GetMapping("/{id}")
	public CursoDTO findById(@PathVariable Long id) throws ItemNotFoundException {
		return cursoService.findById(id);
	}

	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ItemNotFoundException {
		cursoService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CursoDTO itemDTO) throws ItemNotFoundException {
		return cursoService.updateById(id, itemDTO);
	}
}
