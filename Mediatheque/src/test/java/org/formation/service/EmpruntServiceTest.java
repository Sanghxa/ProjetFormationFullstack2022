/*package org.formation.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.formation.entity.Items;
import org.formation.entity.Utilisateur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpruntServiceTest {

	@Autowired
	EmpruntService empruntService;
	
	@BeforeEach
	public void separateur() {
		System.out.println("*******************");
	}
	
	@AfterEach
	public void separateurFin() {
		System.out.println("*******************");
	}
	
	
	//Test Création Emprunt
	@Test
	void testEmprunt() 
		throws EntityNotFoundException, ItemNotAvailableException, EmpruntLimitReachedException {
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId(1l);
		
		List<Items> itemsDuPanier = new ArrayList<>();
		
		Items item1 = new Items();
		item1.setId(1L);
		itemsDuPanier.add(item1);
		
		Items item2 = new Items();
		item2.setId(2L);
		itemsDuPanier.add(item2);
		
		
	}
	
	//Test Retour Emprunt
	@Test
	void testRendreEmprunt()
		throws EntityNotFoundException, ItemAlreadyReturnedException {
		
	}

}
*/