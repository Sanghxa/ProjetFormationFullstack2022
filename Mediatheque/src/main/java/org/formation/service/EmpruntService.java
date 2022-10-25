package org.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.formation.entity.Emprunt;
import org.formation.entity.Items;
import org.formation.entity.Utilisateur;
import org.formation.repository.EmpruntRepository;
import org.formation.repository.ItemsRepository;
import org.formation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpruntService {

	@Autowired
	private EmpruntRepository empruntRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	
//----------------------------------------------------FAIRE UN EMPRUNT----------------------------------------------------
	
	
	public Emprunt effectuerEmprunt(Long idUtilisateur, List<Long> idItems) 
			throws EntityNotFoundException, ItemNotAvailableException, EmpruntLimitReachedException {
		
		
//////////1) UTILISATEUR ? (via son Id)
		
		Utilisateur utilisateurFound = utilisateurRepository.findById(idUtilisateur)
				.orElseThrow(() -> new EntityNotFoundException("cet utilisateur n'existe pas"));
		
		//Reviens au même que:
		/*Optional<Utilisateur> utilisateurFound = utilisateurRepository.findById(idUtilisateur);
		  if (utilisateurFound.isEmpty()) {
			throw new EntityNotFoundException("cet utilisateur n'existe pas");
		}*/
		
		
		
		
//////////2) ITEM ? (via son Id)
		
		 //a- initialisation du panier
		List<Items> itemsDuPanier = new ArrayList<>();
		
		 //b- 
		  //i- vérifie que l'item existe 
		
		for (Long idItem: idItems) {
			Items itemFound = itemsRepository.findById(idItem)
					.orElseThrow(() -> new EntityNotFoundException("cet item n'existe pas"));
			
		  //i- vérifie si item pas dispo
			if(itemFound.getNombreExemplaires() == 0) {
				throw new ItemNotAvailableException("cet item n'est pas disponible");
			}
					
		
		  //iii- ajout des items dans le panier 
			itemsDuPanier.add(itemFound);

		}
		
		
		
//////////3) + QUE 3 ?
	//////a- on récupère la liste des items empruntés par l'utilisateur
		List<Emprunt> EmpruntsUtilisateur = empruntRepository.findByUtilisateur(utilisateurFound);
		
	//////b- if EmpruntsUtilisateur.size() + itemsPaniers.size() <= 3 : add Items à empruntListe de cet utilisateur, else throw EmpruntLimitReachedException
		if (EmpruntsUtilisateur.size() + itemsDuPanier.size() > 3 ) {
			throw new EmpruntLimitReachedException("vous ne pouvez pas emprunter plus de 3 items");
		}
		
		
	//////c- else : throw new EmpruntLimitReachedException("vous ne pouvez pas emprunter plus de 3 items en même temps");
		
		
		
		
		//------------------ OPERATIONS DANS LA BDD ------------------
		//CREATION DE L'EMPRUNT DANS LA BDD --> save
		//AU RETOUR EMPRUNT: ON MET UNE DATE DE RETOUR ET SI IL Y A PAS DE DATE DE RETOUR (si c'est null) alors 
		//on comptabilise l'emprunt dans le quota à pas dépasser (comme ça on garde un historique des emprunts)
		//DECREMENTATION dans ITEMS quand emprunt
		//INCREMENTATION dans ITEMS quand retour
		
		return emprunt;
		
	}
	
	
//----------------------------------------------------RENDRE UN EMPRUNT----------------------------------------------------
	//
	
	

	
}
