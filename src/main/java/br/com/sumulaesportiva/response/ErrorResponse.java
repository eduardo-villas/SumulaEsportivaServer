package br.com.sumulaesportiva.response;

public class ErrorResponse<T> extends Response<T> {

	public ErrorResponse() {
		setStatus(ResponseStatus.ERROR);
		setMessage("Ocorreu um erro na requisição.");
	}
	
}
