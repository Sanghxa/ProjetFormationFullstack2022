package org.formation.entity;

import java.time.Instant;
//import javax.persistence.*;


public class Emprunt {
	
	private int nombreItem;
	private Instant dateEmprunt;
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
