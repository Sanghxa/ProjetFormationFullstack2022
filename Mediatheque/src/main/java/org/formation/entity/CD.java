package org.formation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cds")
public class CD extends Items {
	private String ArtisteGroupe;
	private float duree;
	private int nombreDeTitres;
	
	
	
//GETTERS AND SETTERS
	public String getArtisteGroupe() {
		return ArtisteGroupe;
	}
	public void setArtisteGroupe(String artisteGroupe) {
		ArtisteGroupe = artisteGroupe;
	}
	public float getDuree() {
		return duree;
	}
	public void setDuree(float duree) {
		this.duree = duree;
	}
	public int getNombreDeTitres() {
		return nombreDeTitres;
	}
	public void setNombreDeTitres(int nombreDeTitres) {
		this.nombreDeTitres = nombreDeTitres;
	}
	
	
}
