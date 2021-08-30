package comcast.digital.assignment.commons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LCSGeneratorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LCSGeneratorException(String message) {
		super(message);
	}
}
