package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.DisciplinaDTO;
import academy.gama.apialunos.entity.Disciplina;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.DisciplinaMapper;
import academy.gama.apialunos.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaService {

	private final DisciplinaRepository disciplinaRepository;
	
	private final DisciplinaMapper disciplinaMapper = DisciplinaMapper.INSTANCE;
	
	public MessageResponseDTO create(DisciplinaDTO itemDTO) {
		Disciplina itemToSave = disciplinaMapper.toModel(itemDTO);
		Disciplina savedItem = disciplinaRepository.save(itemToSave);
		return createMessageResponse(savedItem.getId(), "Disciplina created with ID ");
	}
	
	public List<DisciplinaDTO> listAll() {
		List<Disciplina> todosItems = disciplinaRepository.findAll();
		return todosItems.stream()
				.map(disciplinaMapper::toDTO)
				.collect(Collectors.toList())
				;
	}
	
	public DisciplinaDTO findById(Long id) throws ItemNotFoundException {
		Disciplina itemEncontrado = verifyIfExists(id);
		
		return disciplinaMapper.toDTO(itemEncontrado);
	}
	
	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		disciplinaRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, DisciplinaDTO itemDTO ) throws ItemNotFoundException {
		verifyIfExists(id);
		
		Disciplina itemToUpdate = disciplinaMapper.toModel(itemDTO);
		
		Disciplina updatedItem = disciplinaRepository.save(itemToUpdate);
		
		return createMessageResponse(updatedItem.getId(), "Updated disciplina com ID ");
	}
	
	private Disciplina verifyIfExists(Long id) throws ItemNotFoundException {
		return disciplinaRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "disciplina"));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
