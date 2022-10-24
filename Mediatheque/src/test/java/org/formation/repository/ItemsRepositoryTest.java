package org.formation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.formation.entity.Items;
import org.formation.repository.ItemsRepository;

@DataJpaTest
public class ItemsRepositoryTest {

	@Autowired
	ItemsRepository itemsRepository;
	
	@BeforeEach
	public void separateur() {
		System.out.println("*******************");
	}
	
	//Test si on récupère bien tous les items
	@Test
	@Order(1)
	public void testOfFindAllItems() {
		List<Items> response = itemsRepository.findAllItems();
		System.out.println("Nombre d'items en tout : " + response);
		assertEquals(4, response.size());
	}
	
	
	//Test si on récupère bien que les nouveautés des 2 dernières semaines
	//(tester direct sur la console h2 avec les commandes sql pour voir si ça marche) ==> marche pas
	/*
	 * public void testOfNouveautes() { List<Items> response =
	 * itemsRepository.findAllItemsByDateParution();
	 * System.out.println("Nombres d'items paru ces 2 dernières semaines");
	 * 
	 * }
	 */
	
	
	//Test si on récupère bien que les items dispo (avec nb Exemplaire > 0)
	
	
	//TEST DES TYPES D'ITEMS
	//Test si on récupère que les dvd
	
	//Test si on récupère que les cd
	
	//Test si on récupère que les livres
	
}
