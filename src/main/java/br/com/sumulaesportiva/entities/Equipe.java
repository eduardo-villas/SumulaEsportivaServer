package br.com.sumulaesportiva.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Equipe")
public class Equipe {

	@Id
	@GeneratedValue
	private Long id;
}
