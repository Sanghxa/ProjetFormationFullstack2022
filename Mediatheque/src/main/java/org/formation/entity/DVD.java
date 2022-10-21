package org.formation.entity;

import javax.persistence.*;

@Entity
@Table(name = "dvd")
public class DVD extends Items {
	
	@Column
	private String realisateur;
	
	@Column
	private float duree;
	
	@Column
	@Enumerated(EnumType.STRING)
	private DvdType type;
	
	
//GETTERS AND SETTERS
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public float getDuree() {
		return duree;
	}
	public void setDuree(float duree) {
		this.duree = duree;
	}
	
	public DvdType getType() {
		return type;
	}
	public void setType(DvdType type) {
		this.type = type;
	};
	
	
}
