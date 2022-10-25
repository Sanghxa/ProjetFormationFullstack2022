package org.formation.service;

import java.time.LocalDate;
import java.util.*;


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
		 //a- on récupère la liste des items empruntés par l'utilisateur
		List<Emprunt> empruntsUtilisateur = empruntRepository.findByUtilisateur(utilisateurFound);
		
		 //b- if EmpruntsUtilisateur.size() + itemsDuPaniers.size() > 3 : throw EmpruntLimitReachedException
		if (empruntsUtilisateur.size() + itemsDuPanier.size() > 3 ) {
			throw new EmpruntLimitReachedException("vous ne pouvez pas emprunter plus de 3 items");
		}
		
		
//////////3) VALIDATION EMPRUNT
		 //a- décrémentation du nombreExemplaires dans la table ITEMS
		 //NB: mettre truc.get().getMachin quand le type est Optional
		for (Long idItem: idItems) {
			Optional<Items> itemEmpruntes = itemsRepository.findById(idItem);
			itemEmpruntes.get().setNombreExemplaires(itemEmpruntes.get().getNombreExemplaires()-1);
		}
		
		 //b- add la liste des itemsDuPanier dans la table EMPRUNTS associé à l'id utilisateur + date de retour null (signifie que l'emprunt est en cours)
		Emprunt empruntEnCours = new Emprunt();
		empruntEnCours.setDateEmprunt(LocalDate.now());
		empruntEnCours.setItems(itemsDuPanier);
		empruntEnCours.setUtilisateur(utilisateurFound);
        
		empruntRepository.save(empruntEnCours);
		
		
		return empruntEnCours;
		
	}
		


	
	
//----------------------------------------------------RENDRE UN EMPRUNT----------------------------------------------------
	
	
	public Emprunt retournerEmprunt(Long idUtilisateur, Long idEmprunt) 
			throws EntityNotFoundException, ItemAlreadyReturnedException {
		
//////////1) UTILISATEUR ? (via son Id)
		
		 //a- Utilisateur existe ? (dans table UTILISATEUR)
		utilisateurRepository.findById(idUtilisateur)
				.orElseThrow(() -> new EntityNotFoundException("cet utilisateur n'existe pas"));
		

//////////2) ITEM ? (via son Id)
		
		//a- Emprunt existe ? (dans table EMPRUNT)		
		Emprunt empruntARendre = empruntRepository.findById(idEmprunt)
				.orElseThrow(() -> new EntityNotFoundException("cet emprunt n'existe pas"));
		
		 //b- Emprunt déjà rendu ?			
		if(empruntARendre.getDateRetour() != null) {
			throw new ItemAlreadyReturnedException("cet item a déjà été rendu");
		}		
			
			
//////////3) VALIDATION RETOUR	
			
		 //a- création d'une date de retour dans la table EMPRUNTS
		for(Items item : empruntARendre.getItems()) {
			item.setNombreExemplaires(item.getNombreExemplaires() + 1 );
			itemsRepository.save(item);
		}
		
		 //b- Incrémentation de l'item retourné
		empruntARendre.setDateRetour(LocalDate.now());
		empruntRepository.save(empruntARendre);
	
		
		
		
		
		return empruntARendre;
		
	}
	
////////////////////////////////////////////////////////
	
}
