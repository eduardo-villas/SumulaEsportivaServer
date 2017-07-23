package br.com.sumulaesportiva.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Tempo")
public class Tempo {

	@Id
	private Long Id;

	private String descricao;
	private int quantidadePeriodos;
	private int duracaoPeriodos;
	private int quantidadeTemposExtras;
	private int duracaoExtra;
	private int quantidadeTimeout;
	private int duracaoTimeout;

	@MapsId
	@OneToOne
	@PrimaryKeyJoinColumn
	private Modalidade modalidade;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
}