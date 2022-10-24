package org.formation.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmpruntRepositoryTest {
	
	@Autowired
	EmpruntRepository empruntRepository;
	
	
	@BeforeEach
	public void separateur() {
		System.out.println("*******************");
	}
	
	@AfterEach
	public void separateurFin() {
		System.out.println("*******************");
	}
	
	//Test si trouve les emprunts par utilisateur
	//@Test 
	

	
	
}
