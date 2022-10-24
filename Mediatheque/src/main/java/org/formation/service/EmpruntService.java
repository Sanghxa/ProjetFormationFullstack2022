package org.formation.service;

import java.util.List;

import org.formation.entity.Emprunt;
import org.formation.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpruntService {

	@Autowired
	private EmpruntRepository empruntRepository;
	
	//FAIRE UN EMPRUNT
	public Emprunt effectuerEmprunt(Long id_Utilisateur, List<Long> idItems) {
		
		//vérifier que tous les items sont dispo
		
		
		//vérifier que l'utilisateur n'a pas dépassé son quota (3 items max)
		
		//Opérations en base
		//Décrémenter le nombre d'exemplaire disponible
		//Créer un emprunt en position la date d'emprunt
		
		return emprunt;
		
	}
	
	
	//RESTITUER UN EMPRUNT
		//
	
	

	
}
