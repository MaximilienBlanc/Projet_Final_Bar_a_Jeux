package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Evenement;

public interface IEvenementRepository extends JpaRepository<Evenement, Integer>{

}
