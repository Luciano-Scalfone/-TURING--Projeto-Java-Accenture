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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.AlunoDTO;
import academy.gama.apialunos.dto.resquest.NotaDTO;
import academy.gama.apialunos.exception.FiledNotValidException;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/alunos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {

	private AlunoService alunoService;

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid AlunoDTO itemDTO) {
		return alunoService.create(itemDTO);
	}

	@GetMapping
	public List<AlunoDTO> getAll(@RequestParam(required = false) String nome) {
		System.out.println("nome: " + nome);
		return alunoService.listAll(nome);
	}

	@GetMapping("/{id}")
	public AlunoDTO findById(@PathVariable Long id) throws ItemNotFoundException {
		return alunoService.findById(id);
	}

	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ItemNotFoundException {
		alunoService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid AlunoDTO itemDTO) throws ItemNotFoundException, FiledNotValidException {
		return alunoService.updateById(id, itemDTO);
	}
		
	// RELAÇÕES COM NOTA
	
	@GetMapping("/{id}/notas")
	public List<NotaDTO> getNotasById(@PathVariable Long id) throws ItemNotFoundException {
		return alunoService.listNotasByAlunoId(id);
	}
	
	@PostMapping("/{id}/notas")
	public MessageResponseDTO createNota(@PathVariable Long id, @RequestBody @Valid NotaDTO notaDTO) throws ItemNotFoundException, FiledNotValidException {
		return alunoService.createNotaByAlunoId(id, notaDTO);
	}
	
	@PutMapping("/{id}/notas/{notaId}")
	public MessageResponseDTO updateNotaById(@PathVariable Long id, @PathVariable Long notaId, @RequestBody @Valid NotaDTO notaDTO) throws ItemNotFoundException, FiledNotValidException {
		return alunoService.updateNotaByAlunoId(id, notaId, notaDTO);
	}

}
