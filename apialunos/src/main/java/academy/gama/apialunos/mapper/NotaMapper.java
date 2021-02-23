package academy.gama.apialunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.gama.apialunos.dto.resquest.NotaDTO;
import academy.gama.apialunos.entity.Nota;

@Mapper
public interface NotaMapper {

	NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);
	
	Nota toModel(NotaDTO notaDTO);
	
	NotaDTO toDTO(Nota nota);
}
