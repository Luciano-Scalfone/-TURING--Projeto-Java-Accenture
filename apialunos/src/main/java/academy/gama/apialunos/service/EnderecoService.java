package academy.gama.apialunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.gama.apialunos.dto.mapper.EnderecoMapper;
import academy.gama.apialunos.repository.AlunoRepository;
import academy.gama.apialunos.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	private final EnderecoMapper enderecoMapper = EnderecoMapper.INSTANCE;
}
