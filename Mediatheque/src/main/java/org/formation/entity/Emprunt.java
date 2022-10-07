package org.formation.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Emprunt {
	
	
	private int nombreItem;
	private Instant dateEmprunt;

	
	//MAPPING
	@ManyToOne
	private Utilisateur utilsateur;
	
	@ManyToMany
	private Set<Items> items = new HashSet<>();
	
	
	//GETTERS AND SETTERS
	public int getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(int nombreItem) {
		this.nombreItem = nombreItem;
	}
	public Instant getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Instant dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	
}
