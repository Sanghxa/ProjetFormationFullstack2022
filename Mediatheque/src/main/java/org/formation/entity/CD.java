package org.formation.entity;

import javax.persistence.*;

@Entity
@Table(name = "cd")
public class CD extends Items {
	
	@Column(name="artiste_groupe")
	private String artisteGroupe;
	
	@Column
	private float duree;
	
	@Column (name = "nb_titres")
	private int nombreDeTitres;
	
	
	
//GETTERS AND SETTERS
	public String getArtisteGroupe() {
		return artisteGroupe;
	}
	public void setArtisteGroupe(String artisteGroupe) {
		this.artisteGroupe = artisteGroupe;
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
