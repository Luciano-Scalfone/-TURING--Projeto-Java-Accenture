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
import academy.gama.apialunos.dto.resquest.NotaDTO;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.service.NotaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/notas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotaController {

	private NotaService notaService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid NotaDTO itemDTO) {
		return notaService.create(itemDTO);
	}

	@GetMapping
	public List<NotaDTO> getAll() {
		return notaService.listAll();
	}

	@GetMapping("/{id}")
	public NotaDTO findById(@PathVariable Long id) throws ItemNotFoundException {
		return notaService.findById(id);
	}

	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ItemNotFoundException {
		notaService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid NotaDTO itemDTO) throws ItemNotFoundException {
		return notaService.updateById(id, itemDTO);
	}
}
