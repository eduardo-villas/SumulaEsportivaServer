package br.com.sumulaesportiva.response;

enum ResponseStatus {

	SUCCESS(0),
	WARNING(1),
	ERROR(2);
	
	private Integer value;

	ResponseStatus(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
