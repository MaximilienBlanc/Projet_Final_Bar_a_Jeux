package repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Query("select r.dateRes, COUNT(*) from Reservation r WHERE r.tableBar_id.nbPersonne = :nbPers GROUP BY r.dateRes")
	Map<LocalDate, Integer> findAllDate(@Param("nbPers") int nbPersonne);
	
	@Query("select r.heureResa, COUNT(*) from Reservation r WHERE r.dateRes = :nbPers GROUP BY r.heureResa")
	Map<LocalTime, Integer> findAllCrenauParDate(@Param("nbPers") LocalDate dateRes);
	
	

}
