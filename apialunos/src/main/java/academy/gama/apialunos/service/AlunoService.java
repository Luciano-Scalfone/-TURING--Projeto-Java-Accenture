package academy.gama.apialunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.entity.Aluno;
import academy.gama.apialunos.repository.AlunoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoService {

	private AlunoRepository alunoRepository;
	
	public Aluno create(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
}
