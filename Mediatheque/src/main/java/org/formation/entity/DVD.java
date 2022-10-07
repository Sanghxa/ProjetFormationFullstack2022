package org.formation.entity;

import javax.persistence.*;

@Entity
@Table(name = "dvds")
public class DVD extends Items {
	
	private String realisateur;
	private float duree;
	
	@Enumerated
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
