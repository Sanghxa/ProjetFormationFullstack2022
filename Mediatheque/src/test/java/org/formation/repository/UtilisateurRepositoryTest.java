package org.formation.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.formation.entity.Utilisateur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	
	//Test findByEmail - on récupère utilisateur via email ?
	@Test 
	public void testFindUserIdByEmail() {
		Optional<Utilisateur> findUtilisateur = utilisateurRepository.findByEmail("paloma@gmail.com");
		assertTrue(findUtilisateur.isPresent());
		
		//assertEquals(3, findUtilisateur.get().getId());

	}
	
	//Test existsByEmail - email exists dans la database ?
	@Test 
	public void testFindIfUserExists() {
		assertTrue(utilisateurRepository.existsByEmail("paloma@gmail.com"));
		assertFalse(utilisateurRepository.existsByEmail("rogerrabbit@gmail.com"));
	}
	
	
}
