package org.formation.repository;

import org.formation.repository.UtilisateurRepository;
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
	
	//Test si trouve utilisateur via email dans database
	//@Test 
	//@Order(1)
	
	//Test si email existe dans la bdd
	//@Test 
	//@Order(2)
	
	
	
	
	
	
}
