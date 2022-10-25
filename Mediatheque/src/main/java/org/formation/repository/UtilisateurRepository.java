package org.formation.repository;

import java.util.Optional;
import org.formation.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	//ACTIONS
	//récupérer l'Utilisateur selon son email
	//Optional<T> findById(ID primaryKey) -> retuns the entity identified by the given ID
	Optional<Utilisateur> findByEmail(String email);
	
	//récupérer l'Utilisateur selon son id
	//Optional<Utilisateur> findById();
	
	//est-ce que cet email existe dans notre bdd ?
	//boolean existsById(ID primaryKey) -> indicates whether an entity with the given ID exists
	Boolean existsByEmail (String email);

}
