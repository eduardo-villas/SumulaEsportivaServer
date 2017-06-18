package br.com.sumulaesportiva.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Partida")
public class Partida implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull
	private int hora;
	
	@OneToOne
	private Equipe mandante;
	
	@OneToOne
	private Equipe visitante;

	@OneToOne
	private Equipe arbitral;
	
	@NotNull
	private String local;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHora() {
		LocalTime time = LocalTime.ofSecondOfDay(this.hora);
		return time;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora.toSecondOfDay();  
	}

	public Equipe getMandante() {
		return mandante;
	}

	public void setMandante(Equipe mandante) {
		this.mandante = mandante;
	}

	public Equipe getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipe visitante) {
		this.visitante = visitante;
	}

	public Equipe getArbitral() {
		return arbitral;
	}

	public void setArbitral(Equipe arbitral) {
		this.arbitral = arbitral;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
}
