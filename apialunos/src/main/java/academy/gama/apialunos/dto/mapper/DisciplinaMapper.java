package academy.gama.apialunos.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.gama.apialunos.dto.resquest.DisciplinaDTO;
import academy.gama.apialunos.entity.Disciplina;

@Mapper
public interface DisciplinaMapper {

	DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);
	
	Disciplina toDTO(DisciplinaDTO disciplinaDTO);
	
	DisciplinaDTO toModel(Disciplina disciplina);
	
}
