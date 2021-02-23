package academy.gama.apialunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.gama.apialunos.dto.resquest.EnderecoDTO;
import academy.gama.apialunos.entity.Endereco;

@Mapper
public interface EnderecoMapper {

	EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

	Endereco toModel(EnderecoDTO enderecoDTO);
	EnderecoDTO toDTO(Endereco endereco);
}
