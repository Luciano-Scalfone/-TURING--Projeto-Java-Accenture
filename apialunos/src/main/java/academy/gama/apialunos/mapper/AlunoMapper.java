package academy.gama.apialunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.gama.apialunos.dto.resquest.AlunoDTO;
import academy.gama.apialunos.entity.Aluno;

@Mapper
public interface AlunoMapper {
	AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

	Aluno toModel(AlunoDTO alunoDTO); // request
	AlunoDTO toDTO(Aluno aluno); // responder 
}
