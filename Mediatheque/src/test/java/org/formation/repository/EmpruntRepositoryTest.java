package org.formation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.formation.entity.Emprunt;
import org.formation.entity.Utilisateur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
	
	//Test findByUtilisateur (find liste emprunts by Utilisateur
	@Test
    void testFindEmpruntByUtilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1l);

        List<Emprunt> response = empruntRepository.findByUtilisateur(utilisateur);
        assertEquals(2, response.size());
    }

	//Test findByUtilisateurId - (find liste emprunts par Id d'utilisateur)
	@Test
	public void testFindEmpruntByUtilisateurId() {
		List<Emprunt> response = empruntRepository.findByUtilisateurId(1l);
		System.out.println("Nombre d'items empruntés par cet utilisateur : " + response.size());
		assertEquals(2, response.size());
	}
	
}
