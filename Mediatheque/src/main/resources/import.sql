/* UTILISATEURS */
INSERT INTO UTILISATEUR (id, email, mdp, nom, prenom) VALUES(1, 'vrenn@gmail.com', 'vrenn', 'Vrenn', 'Indrani');
INSERT INTO UTILISATEUR (id, email, mdp, nom, prenom) VALUES(2, 'grant@gmail.com', 'grant', 'Grant', 'Neil');
INSERT INTO UTILISATEUR (id, email, mdp, nom, prenom) VALUES(3, 'paloma@gmail.com', 'paloma', 'Paloma', 'Marianne');

/* ITEMS */
INSERT INTO ITEM (id, date_parution, nb_exemplaires, titre) VALUES(1, '2010-03-31', 7, 'Film1' );
INSERT INTO ITEM (id, date_parution, nb_exemplaires, titre) VALUES(2, '2010-03-12', 2, 'Cd1' );
INSERT INTO ITEM (id, date_parution, nb_exemplaires, titre) VALUES(3, '2010-03-05', 4, 'Livre1' );

	/*  DVD  */
INSERT INTO DVD (duree, realisateur, type, id) VALUES(98, 'realisateur1', 'dvd',1);

	/*  CD  */
INSERT INTO CD (artiste_groupe, duree, nb_titres, id) VALUES('artiste1', 55, 14, 2);

	/*  LIVRES  */
INSERT INTO LIVRE (ecrivain, num_isbn, id) VALUES('auteur1', 9780756404741, 3);

/* EMPRUNTS */
	/*  BASE  */
INSERT INTO EMPRUNT (id, date_emprunt, date_retour, id_utilisateur) VALUES(1,'2019-12-20','2019-12-27',1);
INSERT INTO EMPRUNT (id, date_emprunt, date_retour, id_utilisateur) VALUES(2,'2019-11-18','2019-11-15',3);

	/*  ID ITEMS  */
INSERT INTO EMPRUNT_ITEMS (emprunt_id, items_id) VALUES(1,2);
INSERT INTO EMPRUNT_ITEMS (emprunt_id, items_id) VALUES(2,2);


