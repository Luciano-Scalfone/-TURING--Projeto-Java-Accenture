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
import academy.gama.apialunos.dto.resquest.DisciplinaDTO;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.service.DisciplinaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/disciplinas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaController {

	private DisciplinaService disciplinaService;

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid DisciplinaDTO itemDTO) {
		return disciplinaService.create(itemDTO);
	}

	@GetMapping
	public List<DisciplinaDTO> getAll() {
		return disciplinaService.listAll();
	}

	@GetMapping("/{id}")
	public DisciplinaDTO findById(@PathVariable Long id) throws ItemNotFoundException {
		return disciplinaService.findById(id);
	}

	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ItemNotFoundException {
		disciplinaService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid DisciplinaDTO itemDTO) throws ItemNotFoundException {
		return disciplinaService.updateById(id, itemDTO);
	}
}
