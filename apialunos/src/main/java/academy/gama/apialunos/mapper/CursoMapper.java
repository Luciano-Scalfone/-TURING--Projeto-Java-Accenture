package academy.gama.apialunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.gama.apialunos.dto.resquest.CursoDTO;
import academy.gama.apialunos.entity.Curso;

@Mapper
public interface CursoMapper {

	CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

	Curso toModel(CursoDTO cursoDTO);
	
	CursoDTO toDTO(Curso curso);
}
