package br.com.sumulaesportiva.response;

public class WarningResponse<T> extends Response<T> {

	public WarningResponse() {
		setStatus(ResponseStatus.WARNING);
		setMessage("Aviso. Houve um problema na requisição.");
	}
	
}
