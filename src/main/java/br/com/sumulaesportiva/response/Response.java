package br.com.sumulaesportiva.response;

public class Response<T> {

	private T data;
	private ResponseStatus status;
	private String message;
	
	Response() {
	}
	
	public T getData() {
		return data;
	}
	
	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	ResponseStatus getStatus() {
		return status;
	}
	
	void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Response<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	boolean success() {
		return status == ResponseStatus.SUCCESS;
	}
	
	boolean warning() {
		return status == ResponseStatus.WARNING;
	}
	
	boolean error() {
		return status == ResponseStatus.ERROR;
	}
}
