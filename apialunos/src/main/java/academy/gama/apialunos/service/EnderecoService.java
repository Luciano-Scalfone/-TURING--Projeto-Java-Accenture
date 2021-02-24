package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.EnderecoDTO;
import academy.gama.apialunos.entity.Endereco;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.EnderecoMapper;
import academy.gama.apialunos.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	private final EnderecoMapper enderecoMapper = EnderecoMapper.INSTANCE;
	
	public MessageResponseDTO create(EnderecoDTO itemDTO) {
		Endereco itemToSave = enderecoMapper.toModel(itemDTO);
		Endereco savedItem = enderecoRepository.save(itemToSave);
		return createMessageResponse(savedItem.getId(), "Endereco created with ID ");
	}
	
	public List<EnderecoDTO> listAll() {
		List<Endereco> todosItems = enderecoRepository.findAll();
		return todosItems.stream()
				.map(enderecoMapper::toDTO)
				.collect(Collectors.toList())
				;
	}
	
	public EnderecoDTO findById(Long id) throws ItemNotFoundException {
		Endereco itemEncontrado = verifyIfExists(id);
		
		return enderecoMapper.toDTO(itemEncontrado);
	}
	
	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		enderecoRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, EnderecoDTO itemDTO ) throws ItemNotFoundException {
		verifyIfExists(id);
		
		Endereco itemToUpdate = enderecoMapper.toModel(itemDTO);
		
		Endereco updatedItem = enderecoRepository.save(itemToUpdate);
		
		return createMessageResponse(updatedItem.getId(), "Updated endereco com ID ");
	}
	
	private Endereco verifyIfExists(Long id) throws ItemNotFoundException {
		return enderecoRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "endereco"));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
