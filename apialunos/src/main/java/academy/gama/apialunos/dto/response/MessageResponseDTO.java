package academy.gama.apialunos.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
	
	private String message;

	public MessageResponseDTO(String message) {
		this.message = message;
	}
	
	public MessageResponseDTO(String message, Long id) {
		this.message = message.trim() + " " + id;
	}
	
}
