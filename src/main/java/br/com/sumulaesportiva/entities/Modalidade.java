package br.com.sumulaesportiva.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Modalidade")
public class Modalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	private String descricao;

	@PrimaryKeyJoinColumn
	@Cascade(value = CascadeType.ALL)
	@OneToOne(orphanRemoval = true)
	private Tempo tempo;

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

	public Tempo getTempo() {
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}
}