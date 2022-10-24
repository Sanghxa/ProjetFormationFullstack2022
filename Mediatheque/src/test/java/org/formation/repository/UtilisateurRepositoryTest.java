package org.formation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.formation.entity.Utilisateur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UtilisateurRepositoryTest {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@BeforeEach
	public void separateur() {
		System.out.println("*******************");
	}
	
	@AfterEach
	public void separateurFin() {
		System.out.println("*******************");
	}
	
	//Test si trouve utilisateur via email dans database
	@Test 
	@Order(1)
	public void testFindUserIdByEmail() {
		Optional<Utilisateur> findUtilisateur = utilisateurRepository.findByEmail("paloma@gmail.com");
		assertEquals(3, findUtilisateur.get().getId());

	}
	
	//Test si email existe dans la bdd
	//@Test 
	//@Order(2)
	//public void testFindIfUserExists() {
	//	Boolean existsByEmail
	//}
	

	
}
