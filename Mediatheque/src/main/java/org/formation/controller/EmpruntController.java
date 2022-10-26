package org.formation.controller;

import org.formation.repository.EmpruntRepository;
import org.formation.repository.UtilisateurRepository;
import org.formation.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

	@Autowired
	EmpruntService empruntService;
	
	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	


	
}
