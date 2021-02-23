package academy.gama.apialunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.mapper.DisciplinaMapper;
import academy.gama.apialunos.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaService {

	private final DisciplinaRepository disciplinaRepository;
	
	private final DisciplinaMapper disciplinaMapper = DisciplinaMapper.INSTANCE;
}
