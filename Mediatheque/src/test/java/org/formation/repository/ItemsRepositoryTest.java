package org.formation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.formation.entity.Items;


@DataJpaTest
public class ItemsRepositoryTest {

	@Autowired
	ItemsRepository itemsRepository;
	
	@BeforeEach
	public void separateurDebut() {
		System.out.println("*******************");
	}
	
	@AfterEach
	public void separateurFin() {
		System.out.println("*******************");
	}
	
	//Test si on récupère bien tous les items
	@Test
	@Order(1)
	public void testFindAllItems() {
		List<Items> response = itemsRepository.findAllItems();
		System.out.println("Nombre d'items en tout : " + response.size());
		assertEquals(6, response.size());
	}
	
	
	
	//Test si on récupère bien que les items dispo (avec nb Exemplaire > 0)
	@Test
	@Order(2)
	public void testFindOnlyAvailableItems() {
		List<Items> response = itemsRepository.findAllItemsByNombreExemplaires();
		System.out.println("Nombre d'items disponibles : " + response.size());
		assertEquals(4, response.size());
	}
	
	
	//TEST DES TYPES D'ITEMS
	//Test si on récupère que les dvd
	@Test
	@Order(3)
	public void testFindOnlyDvd() {
		List<Items> response = itemsRepository.findAllDvd();
		System.out.println("Nombre de DVD disponibles : " + response.size());
		assertEquals(2, response.size());
	}
	
	
	//Test si on récupère que les cd
	@Test
	@Order(4)
	public void testFindOnlyCd() {
		List<Items> response = itemsRepository.findAllCd();
		System.out.println("Nombre de CD disponibles : " + response.size());
		assertEquals(1, response.size());
	}
	
	
	//Test si on récupère que les livres
	@Test
	@Order(5)
	public void testFindOnlyLivre() {
		List<Items> response = itemsRepository.findAllLivre();
		System.out.println("Nombre de Livres disponibles : " + response.size());
		assertEquals(3, response.size());
	}
	
	
	
	
}
