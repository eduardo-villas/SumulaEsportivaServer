package br.com.sumulaesportiva.response;

public class SuccessResponse<T> extends Response<T> {

	public SuccessResponse() {
		setStatus(ResponseStatus.SUCCESS);
		setMessage("Requisição realizada com sucesso.");
	}
	
}
