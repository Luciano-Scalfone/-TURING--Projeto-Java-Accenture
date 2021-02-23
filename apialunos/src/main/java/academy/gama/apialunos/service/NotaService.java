package academy.gama.apialunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.mapper.NotaMapper;
import academy.gama.apialunos.repository.EnderecoRepository;
import academy.gama.apialunos.repository.NotaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotaService {

	private final NotaRepository notaRepository;
	
	private final NotaMapper notaMapper = NotaMapper.INSTANCE;
	
}
