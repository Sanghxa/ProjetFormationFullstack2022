package org.formation.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import javax.persistence.*;

@Entity
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empruntSequenceGenerator")
	@SequenceGenerator(name = "empruntSequenceGenerator", allocationSize = 1)
	private Long idEmprunt;
		
	@Column(name = "date_emprunt")
	private LocalDate dateEmprunt;
	
	@Column (name = "date_retour")
	private LocalDate dateRetour; // = dateEmprunt + 7 jours
	
	
	
	//MAPPING
	//colonne id_item qui vient de Items
	//@ManyToMany
	//@JoinColumn(name = "id_item" , referencedColumnName = "id")
	//private List<Items> items ;
	
	//Colonne id_utilisateur qui vient de Utilisateur (many emprunt > 1 user)
	@ManyToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;
	
	
	
	//GETTERS AND SETTERS
	
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Long getIdEmprunt() {
		return idEmprunt;
	}
	public void setIdEmprunt(Long idEmprunt) {
		this.idEmprunt = idEmprunt;
	}
	public LocalDate getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
}
