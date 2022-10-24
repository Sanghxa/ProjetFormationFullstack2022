package org.formation.repository;

import java.util.List;

import org.formation.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

	//ACTIONS: CATALOGUE	
	//Voir TOUT
	@Query("FROM Items i")
	List<Items> findAllItems();
	
	//Voir Nouveautés (seuil = 15 derniers jours)
	//@Query("FROM Items i WHERE (CURRENT_DATE - i.date_parution) BETWEEN 0 AND 14")
	//List<Items> findAllItemsByDateParution();
	
	//Voir Disponibles (if nb_exemplaire > 0)
	@Query("FROM Items i WHERE i.nb_exemplaires > 0")
	List<Items> findAllItemsByNombreExemplaires();
	
	
	//Voir par sections: Dvd, Cd, Livres
	@Query("FROM DVD d") 
	List<Items> findAllDvd();
	  
	@Query("FROM CD c") 
	List<Items> findAllCd();
	  
	@Query("FROM Livre l") 
	List<Items> findAllLivre();
	 
	

	
	
}
