package repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Query("select r.dateRes from Reservation r WHERE r.tableBar.nbPersonne=:nbPers")
	Collection<LocalDate> findAllDate(@Param("nbPers") int nbPersonne);
	
//	@Query("select r.dateRes from Reservation r WHERE r.tableBar.nbPersonne=:nbPers GROUP BY r.dateResa")
//	List<LocalDate> findUniqueDate(@Param("nbPers") int nbPersonne);
	
//	@Query("select r.heureResa, COUNT(*) from Reservation r WHERE r.dateRes =:nbPers GROUP BY r.heureResa")
//	Map<LocalTime, Integer> findAllCrenauParDate(@Param("nbPers") LocalDate dateRes);
	
	

}
