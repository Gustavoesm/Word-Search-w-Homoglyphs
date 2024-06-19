package application.src.impl.exceptions;

public class PageReadingException extends RuntimeException {
	public PageReadingException(String errorMessage) {
		super(errorMessage);
	}
}