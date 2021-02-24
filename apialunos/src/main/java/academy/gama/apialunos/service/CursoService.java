package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.CursoDTO;
import academy.gama.apialunos.entity.Curso;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.CursoMapper;
import academy.gama.apialunos.repository.CursoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CursoService {

	private final CursoRepository cursoRepository;

	private final CursoMapper cursoMapper = CursoMapper.INSTANCE;

	public MessageResponseDTO create(CursoDTO itemDTO) {
		Curso itemToSave = cursoMapper.toModel(itemDTO);
		Curso savedItem = cursoRepository.save(itemToSave);
		return createMessageResponse(savedItem.getId(), "Curso created with ID ");
	}

	public List<CursoDTO> listAll() {
		List<Curso> todosItems = cursoRepository.findAll();
		return todosItems.stream()
				.map(cursoMapper::toDTO)
				.collect(Collectors.toList())
				;
	}

	public CursoDTO findById(Long id) throws ItemNotFoundException {
		Curso itemEncontrado = verifyIfExists(id);

		return cursoMapper.toDTO(itemEncontrado);
	}

	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		cursoRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, CursoDTO itemDTO ) throws ItemNotFoundException {
		verifyIfExists(id);

		Curso itemToUpdate = cursoMapper.toModel(itemDTO);

		Curso updatedItem = cursoRepository.save(itemToUpdate);

		return createMessageResponse(updatedItem.getId(), "Updated curso com ID ");
	}

	private Curso verifyIfExists(Long id) throws ItemNotFoundException {
		return cursoRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "curso"));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
