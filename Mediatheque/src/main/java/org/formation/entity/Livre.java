package org.formation.entity;

import javax.persistence.*;

@Entity
@Table(name = "livres")
public class Livre extends Items {
	private String ecrivain;
	private Long numeroISBN;
	
	
	//GETTERS AND SETTERS
	public String getEcrivain() {
		return ecrivain;
	}
	public void setEcrivain(String ecrivain) {
		this.ecrivain = ecrivain;
	}
	public Long getNumeroISBN() {
		return numeroISBN;
	}
	public void setNumeroISBN(Long numeroISBN) {
		this.numeroISBN = numeroISBN;
	}
}
