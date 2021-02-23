package academy.gama.apialunos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.response.MessageResponseDTO;
import academy.gama.apialunos.dto.resquest.AlunoDTO;
import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.exception.ItemNotFoundException;
import academy.gama.apialunos.mapper.AlunoMapper;
import academy.gama.apialunos.repository.AlunoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;
	
	public MessageResponseDTO create(AlunoDTO alunoDTO) {
		Aluno alunoToSave = alunoMapper.toModel(alunoDTO);
		Aluno savedAluno = alunoRepository.save(alunoToSave);
		return createMessageResponse(savedAluno.getId(), "Aluno created with ID ");
	}
	
	public List<AlunoDTO> listAll() {
		List<Aluno> allAlunos = alunoRepository.findAll();
		return allAlunos.stream()
				.map(alunoMapper::toDTO)
				.collect(Collectors.toList())
				;
	}
	
	public AlunoDTO findById(Long id) throws ItemNotFoundException {
		Aluno aluno = verifyIfExists(id);
		
		return alunoMapper.toDTO(aluno);
	}
	
	public void delete (Long id) throws ItemNotFoundException {
		verifyIfExists(id);
		alunoRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, AlunoDTO alunoDTO ) throws ItemNotFoundException {
		verifyIfExists(id);
		
		Aluno alunoToUpdate = alunoMapper.toModel(alunoDTO);
		
		Aluno updatedAluno = alunoRepository.save(alunoToUpdate);
		
		return createMessageResponse(updatedAluno.getId(), "Updated aluno com ID ");
	}
	
	private Aluno verifyIfExists(Long id) throws ItemNotFoundException {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException(id, "pet"));
	}
	
	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
	
}
