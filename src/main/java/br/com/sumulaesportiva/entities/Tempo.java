// Eduardo
package br.com.sumulaesportiva.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tempo")
public class Tempo {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;
	private int quantidadePeriodos, duracaoPeriodos, quantidadeTemposExtras, duracaoExtra, quantidadeTimeout,
			duracaoTimeout;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadePeriodos() {
		return quantidadePeriodos;
	}

	public void setQuantidadePeriodos(int quantidadePeriodos) {
		this.quantidadePeriodos = quantidadePeriodos;
	}

	public int getDuracaoPeriodos() {
		return duracaoPeriodos;
	}

	public void setDuracaoPeriodos(int duracaoPeriodos) {
		this.duracaoPeriodos = duracaoPeriodos;
	}

	public int getQuantidadeTemposExtras() {
		return quantidadeTemposExtras;
	}

	public void setQuantidadeTemposExtras(int quantidadeTemposExtras) {
		this.quantidadeTemposExtras = quantidadeTemposExtras;
	}

	public int getDuracaoExtra() {
		return duracaoExtra;
	}

	public void setDuracaoExtra(int duracaoExtra) {
		this.duracaoExtra = duracaoExtra;
	}

	public int getQuantidadeTimeout() {
		return quantidadeTimeout;
	}

	public void setQuantidadeTimeout(int quantidadeTimeout) {
		this.quantidadeTimeout = quantidadeTimeout;
	}

	public int getDuracaoTimeout() {
		return duracaoTimeout;
	}

	public void setDuracaoTimeout(int duracaoTimeout) {
		this.duracaoTimeout = duracaoTimeout;
	}

}
