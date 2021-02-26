package academy.gama.apialunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiledNotValidException extends Exception {
	
	public FiledNotValidException(String message) {
		super("Erro de validação de campo: " + message);
 	}

}
