package org.formation.entity;

import java.time.LocalDate;
import java.util.List;


//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empruntSequenceGenerator")
	@SequenceGenerator(name = "empruntSequenceGenerator", allocationSize = 1)
	private Long id;
		
	@Column(name = "date_emprunt")
	private LocalDate dateEmprunt;
	
	@Column (name = "date_retour")
	private LocalDate dateRetour; // = dateEmprunt + 7 jours
	
	
	
	//MAPPING
	//colonne id_item qui vient de Items
	@ManyToMany
	@Column(name = "id_item")
	private List<Items> items ;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
