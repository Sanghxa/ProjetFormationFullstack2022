package com.formation.repositoryTest;

import org.formation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UtilisateurRepositoryTest {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	
	
}
