package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.IdException;
import exception.JeuException;
import model.Civilite;
import model.Client;
import model.Jeu;
import service.JeuService;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class JeuServiceTest {
	
	@Autowired
	JeuService jeuSrv;
	
	
	@Test
	void injectionJeuServiceTest() {
		assertNotNull(jeuSrv);
	}
	
	@Test
	void creationJeu() {
	Jeu jeuTest = new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
	jeuSrv.create(jeuTest);
	} 
	
	@Test
	void checkNotNullThrowsTest() {
		
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(null);
		});
	}
	
	@Test
	void checkConstraintThrowsTest() {
		
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu(null,2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",-1,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,0,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,-2,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,-15,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,null,"2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production",null,22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",-5,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,null,"action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png",null,1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",-5,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
		assertThrows(JeuException.class, () -> {
			jeuSrv.create(new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.,De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles."));
		});
	}
	
	@Test
	void findByIdThrowsTest() {
		assertThrows(IdException.class, () -> {
			jeuSrv.findById(100);
		});
	}
	
	@Test
	void findByIdTest() {
		Jeu jeu = jeuSrv.findById(1);
	}
	
	@Test
	void updateJeuTest() {
		Jeu jeuTest = new Jeu("7 Wonders Duel",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuTest = jeuSrv.create(jeuTest);
		Jeu jeuUpdate = new Jeu(jeuTest.getId(),"7 Wonders Duelité",2,2,10,30,"Repos Production","2015",22.95,"\\Projet_Final\\bdd\\image_jeu\\concept.png","action,carte",1,"De bien des façons, 7 Wonders Duel ressemble à son grand-frère 7 Wonders car les joueurs acquièrent des cartes au cours de trois âges, ces dernières fournissant des ressources ou faisant progresser leur développement militaire ou scientifique afin de développer leur civilisation ou bâtir des merveilles.");
		jeuUpdate = jeuSrv.update(jeuUpdate);
	}
	
}
