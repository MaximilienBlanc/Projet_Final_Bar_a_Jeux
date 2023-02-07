package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Jeu;

public interface IJeuRepository extends JpaRepository<Jeu, Integer>{
	
	
	//On récupère tout les type de jeu pour le select dans la page collection/boutique
	@Query("select DISTINCT j.typeJeu from Jeu j")
	List<String> findAllTypeJeu();

}
