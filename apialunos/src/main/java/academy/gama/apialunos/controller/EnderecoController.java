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
import academy.gama.apialunos.dto.resquest.EnderecoDTO;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.service.EnderecoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/enderecos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoController {

	private EnderecoService enderecoService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid EnderecoDTO itemDTO) {
		return enderecoService.create(itemDTO);
	}

	@GetMapping
	public List<EnderecoDTO> getAll() {
		return enderecoService.listAll();
	}

	@GetMapping("/{id}")
	public EnderecoDTO findById(@PathVariable Long id) throws ItemNotFoundException {
		return enderecoService.findById(id);
	}

	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ItemNotFoundException {
		enderecoService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid EnderecoDTO itemDTO) throws ItemNotFoundException {
		return enderecoService.updateById(id, itemDTO);
	}
}
