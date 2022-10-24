package org.formation.repository;

import java.util.List;

import org.formation.entity.Emprunt;
import org.formation.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

	
	//ACTIONS
	//Voir la liste des emprunts de l'utilisateur
	List<Emprunt> findByUtilisateur(Utilisateur utilisateur);
	
	
	//récupérer la liste d'emprunt d'un utilisateur via son id
	List<Emprunt> findByUtilisateurId(Long id);
	
	
	
}
