package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CommandeConso;

public interface ICommandeConsoRepository extends JpaRepository<CommandeConso, Integer> {

}
