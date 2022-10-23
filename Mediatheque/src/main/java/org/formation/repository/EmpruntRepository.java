package org.formation.repository;

import java.util.Optional;

import org.formation.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

	
	//ACTIONS
	//Voir emprunts selon l'ID d'un utilisateur
	Optional<Emprunt> findByUtilisateur(Long id);
	
	
	
	
}
