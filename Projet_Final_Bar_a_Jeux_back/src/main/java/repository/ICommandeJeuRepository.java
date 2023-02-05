package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CommandeJeu;

public interface ICommandeJeuRepository extends JpaRepository <CommandeJeu,Integer>{

}
