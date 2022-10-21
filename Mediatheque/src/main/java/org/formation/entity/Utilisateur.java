package org.formation.entity;


import java.util.HashSet;
import java.util.Set;

//import java.util.HashSet;
//import java.util.Set;
import javax.persistence.*;



@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateurSequenceGenerator")
	@SequenceGenerator(name = "utilisateurSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column
	private String email;
	
	@Column
	private String mdp;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@OneToMany(mappedBy = "utilisateur")
	private Set<Emprunt> emprunts = new HashSet<>() ;

	
	//MAPPING
	
	
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	
}
