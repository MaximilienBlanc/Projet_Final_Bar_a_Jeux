package repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Reservation;
import model.TableBar;

public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Query("select r.dateRes from Reservation r r.tableBar_id.nbPersonne = :nbPers")
	List<LocalDate> findAllDate(@Param("nbPers") TableBar nbPersonne);
	
	@Query("select r.heureResa from Reservation r where r.dateRes = :nbPers")
	List<LocalTime> findAllCrenauParDate(@Param("nbPers") LocalDate dateRes);
	
	

}
