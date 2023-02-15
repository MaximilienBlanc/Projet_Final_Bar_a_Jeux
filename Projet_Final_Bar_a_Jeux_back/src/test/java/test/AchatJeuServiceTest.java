package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.AchatJeuException;
import exception.IdException;
import model.AchatJeu;
import model.Civilite;
import model.Client;
import model.CommandeJeu;
import model.Jeu;
import model.Statut;
import service.AchatJeuService;
import service.ClientService;
import service.CommandeJeuService;
import service.JeuService;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class AchatJeuServiceTest {
	
	@Autowired
	AchatJeuService achatJeuSrv;
	
	@Autowired
	JeuService jeuSrv;
	
	@Autowired
	ClientService clientSrv;
	
	@Autowired
	CommandeJeuService cmdJeuSrv;
	
	
	@Test
	void injectionAchatServiceTest() {
		assertNotNull(achatJeuSrv);
	}
	
	@Test
	void creationAchat() {
	Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
	clientSrv.save(clientTest);
	CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
	cmdJeuSrv.create(cmdTest);
	Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
	jeuSrv.create(jeuTest);
	AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
	achatJeuSrv.create(achatTest);
	assertNotNull(jeuSrv.findById(achatTest.getId()));
	} 
	
	@Test
	void checkConstraintThrowsTest() {
		
		AchatJeuException thrown1 = assertThrows(AchatJeuException.class, () -> {
			Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
			clientSrv.save(clientTest);
			CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
			cmdJeuSrv.create(cmdTest);
			Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
			jeuSrv.create(jeuTest);
			achatJeuSrv.create(new AchatJeu(null,1,jeuTest,cmdTest));
		});
		AchatJeuException thrown2 = assertThrows(AchatJeuException.class, () -> {
			Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
			clientSrv.save(clientTest);
			CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
			cmdJeuSrv.create(cmdTest);
			Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
			jeuSrv.create(jeuTest);
			achatJeuSrv.create(new AchatJeu(LocalDate.parse("2023-02-10"),-2,jeuTest,cmdTest));
		});
		AchatJeuException thrown3 = assertThrows(AchatJeuException.class, () -> {
			Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
			clientSrv.save(clientTest);
			CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
			cmdJeuSrv.create(cmdTest);
			achatJeuSrv.create(new AchatJeu(LocalDate.parse("2023-02-10"),1,null,cmdTest));
		});
		AchatJeuException thrown4 = assertThrows(AchatJeuException.class, () -> {
			Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
			jeuSrv.create(jeuTest);
			achatJeuSrv.create(new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,null));
		});
		
		
		assertTrue(thrown1.getMessage().contentEquals("date d'achat obligatoire"));
		assertTrue(thrown2.getMessage().contentEquals("saisir quantité positive"));
		assertTrue(thrown3.getMessage().contentEquals("saisir un objet jeu"));
		assertTrue(thrown4.getMessage().contentEquals("saisir un objet commandeJeu"));
		
	}
	
	@Test
	void findByIdThrowsTest() {
		IdException thrown1 = assertThrows(IdException.class, () -> {
			achatJeuSrv.findById(100);
		});
		assertTrue(thrown1.getMessage().contentEquals("id inconnu"));
	}
	
	@Test
	void findByIdThrowsNullTest() {
		IdException thrown1 = assertThrows(IdException.class, () -> {
			achatJeuSrv.findById(null);
		});
		assertTrue(thrown1.getMessage().contentEquals("id inconnu"));
	}
	
	@Test
	void findByIdTest() {
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		assertNotNull(achatJeuSrv.findById(achatTest.getId()));
	}
	
	@Test
	void updateDateAchatTest() {
		
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		
		AchatJeu achatUpdate = new AchatJeu(achatTest.getId(),LocalDate.parse("2023-02-13"),1,jeuTest,cmdTest);
		achatUpdate = achatJeuSrv.update(achatUpdate);
		assertEquals(LocalDate.parse("2023-02-13"),achatUpdate.getDateAchat());
	}
	
	
	@Test
	void updateQteAchatTest() {
		
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		
		AchatJeu achatUpdate = new AchatJeu(achatTest.getId(),LocalDate.parse("2023-02-10"),3,jeuTest,cmdTest);
		achatUpdate = achatJeuSrv.update(achatUpdate);
		assertEquals(3,achatUpdate.getQuantite());
	}
	
	@Test
	void updateJeuAchatTest() {
		
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		
		Jeu jeuTest2 = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		
		AchatJeu achatUpdate = new AchatJeu(achatTest.getId(),LocalDate.parse("2023-02-10"),3,jeuTest2,cmdTest);
		achatUpdate = achatJeuSrv.update(achatUpdate);
		assertEquals(3,achatUpdate.getQuantite());
	}
	
	// Est ce qu'on permet la modification de commande sachant quelles sont indissociable
	
	@Test
	void checkNotNullTest() {
		AchatJeu achatJeuTest = null;
		AchatJeuException thrown = assertThrows(AchatJeuException.class, () -> {
			achatJeuSrv.create(achatJeuTest);
		});
		assertTrue(thrown.getMessage().contentEquals("achatJeu obligatoire"));
	}
	
	@Test
	void deleteByIdTest() {
		
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		
		achatJeuSrv.delete(achatTest.getId());	
		IdException thrown1 = assertThrows(IdException.class, () -> {
			achatJeuSrv.findById(achatTest.getId());
		});	
		assertTrue(thrown1.getMessage().contentEquals("id inconnu"));
	}
	
	@Test
	void deleteByObjectTest() {
		
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achatTest = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeuSrv.create(achatTest);
		
		achatJeuSrv.delete(achatTest);	
		IdException thrown1 = assertThrows(IdException.class, () -> {
			achatJeuSrv.findById(achatTest.getId());
		});	
		assertTrue(thrown1.getMessage().contentEquals("id inconnu"));
	}
	
	@Test 
	void findAllTest() {
		List<AchatJeu> achatJeux = new ArrayList<>();	
		Client clientTest = new Client("client1@test.fr","clienttest1","clienttest1","clienttest1","0600000001",Civilite.homme, LocalDate.parse("2000-01-01"));	
		clientSrv.save(clientTest);
		CommandeJeu cmdTest = new CommandeJeu(Statut.EnCours,clientTest);
		cmdJeuSrv.create(cmdTest);
		Jeu jeuTest = new  Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuSrv.create(jeuTest);
		AchatJeu achat1 = new AchatJeu(LocalDate.parse("2023-02-10"),1,jeuTest,cmdTest);
		achatJeux.add(achat1);
		achatJeuSrv.create(achat1);
		
		//vérif renvoie bien une liste
		assertEquals(achatJeux.getClass(),achatJeuSrv.findAll().getClass());	
		//vérif la class des objets dans la liste
		assertEquals(achat1.getClass(),achatJeuSrv.findAll().get(0).getClass());		
	}
	
	
}
