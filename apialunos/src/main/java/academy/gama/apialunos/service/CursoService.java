package academy.gama.apialunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.mapper.CursoMapper;
import academy.gama.apialunos.repository.CursoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CursoService {

	private final CursoRepository cursoRepository;

	private final CursoMapper cursoMapper = CursoMapper.INSTANCE;
}
