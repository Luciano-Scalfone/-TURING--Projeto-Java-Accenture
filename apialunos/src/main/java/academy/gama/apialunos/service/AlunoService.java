package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.AlunoDTO;
import academy.gama.apialunos.dto.resquest.NotaDTO;
import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.entity.Nota;
import academy.gama.apialunos.exception.FiledNotValidException;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.AlunoMapper;
import academy.gama.apialunos.mapper.NotaMapper;
import academy.gama.apialunos.repository.AlunoRepository;
import academy.gama.apialunos.repository.NotaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoService {

	private final AlunoRepository alunoRepository;

	private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

	public MessageResponseDTO create(AlunoDTO itemDTO) {

		Aluno itemToSave = alunoMapper.toModel(itemDTO);
		Aluno savedItem = alunoRepository.save(itemToSave);
		MessageResponseDTO resposta = new MessageResponseDTO("Aluno created with ID", savedItem.getId());

		return resposta;
	}

	public List<AlunoDTO> listAll() {
		List<Aluno> todosItems = alunoRepository.findAll();
		return todosItems.stream()
				.map(alunoMapper::toDTO)
				.collect(Collectors.toList())
				;
	}

	public AlunoDTO findById(Long id) throws ItemNotFoundException {
		Aluno itemEncontrado = verifyIfExists(id);

		return alunoMapper.toDTO(itemEncontrado);
	}

	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		alunoRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, AlunoDTO itemDTO ) throws ItemNotFoundException, FiledNotValidException {

		MessageResponseDTO resposta = null;

		verifyIfExists(id);
		Aluno itemToUpdate = backToModel(itemDTO);
		
		try {
			Aluno updatedItem = alunoRepository.save(itemToUpdate);
			resposta = new MessageResponseDTO("Updated aluno com ID", updatedItem.getId());

		} catch (Exception e) {
			
			 throw new FiledNotValidException(e.getMessage());
		}
		return resposta;
	}
	
	private Aluno backToModel(AlunoDTO itemDTO) throws FiledNotValidException {
		return alunoMapper.toModel(itemDTO);
	}

	private Aluno verifyIfExists(Long id) throws ItemNotFoundException {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "aluno"));
	}
	
	// RELAÇÕES	>> NOTAS
	
	private final NotaRepository notaRepository;

	private final NotaMapper notaMapper = NotaMapper.INSTANCE;
		
	public List<NotaDTO> getNotasById(Long id) throws ItemNotFoundException {
		Aluno alunoEndontrado = verifyIfExists(id);
		List<Nota> todosItems = notaRepository.getNotasByAlunoId(alunoEndontrado);
		return todosItems.stream()
				.map(notaMapper::toDTO)
				.collect(Collectors.toList())
				;
	}

}
