package org.formation.entity;

import java.time.LocalDate;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequenceGenerator")
	@SequenceGenerator(name = "itemSequenceGenerator", allocationSize = 1)
	private Long id;
	private String titre;
	private int nombreExemplaires;
	private LocalDate dateParution;
	
	
	
//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNombreExemplaires() {
		return nombreExemplaires;
	}
	public void setNombreExemplaires(int nombreExemplaires) {
		this.nombreExemplaires = nombreExemplaires;
	}
	public LocalDate getDateParution() {
		return dateParution;
	}
	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}
	
}
