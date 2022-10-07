package org.formation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dvds")
public class DVD extends Items {
	
	private String realisateur;
	private float duree;
	private enum type {BluRay,DVD;}
	
	
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
	};
	
	
}
