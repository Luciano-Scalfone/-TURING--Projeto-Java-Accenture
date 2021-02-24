package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.NotaDTO;
import academy.gama.apialunos.entity.Nota;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.NotaMapper;
import academy.gama.apialunos.repository.NotaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotaService {

	private final NotaRepository notaRepository;
	
	private final NotaMapper notaMapper = NotaMapper.INSTANCE;
	
	public MessageResponseDTO create(NotaDTO itemDTO) {
		Nota itemToSave = notaMapper.toModel(itemDTO);
		Nota savedItem = notaRepository.save(itemToSave);
		return createMessageResponse(savedItem.getId(), "Nota created with ID ");
	}
	
	public List<NotaDTO> listAll() {
		List<Nota> todosItems = notaRepository.findAll();
		return todosItems.stream()
				.map(notaMapper::toDTO)
				.collect(Collectors.toList())
				;
	}
	
	public NotaDTO findById(Long id) throws ItemNotFoundException {
		Nota itemEncontrado = verifyIfExists(id);
		
		return notaMapper.toDTO(itemEncontrado);
	}
	
	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		notaRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, NotaDTO itemDTO ) throws ItemNotFoundException {
		verifyIfExists(id);
		
		Nota itemToUpdate = notaMapper.toModel(itemDTO);
		
		Nota updatedItem = notaRepository.save(itemToUpdate);
		
		return createMessageResponse(updatedItem.getId(), "Updated nota com ID ");
	}
	
	private Nota verifyIfExists(Long id) throws ItemNotFoundException {
		return notaRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "nota"));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
	
}
