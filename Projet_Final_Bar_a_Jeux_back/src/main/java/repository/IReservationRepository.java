package repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Query("select r.dateRes from Reservation r WHERE r.tableBar.nbPersonne=:nbPers")
	Collection<LocalDate> findAllDate(@Param("nbPers") int nbPersonne);
	
//	@Query("select r.dateRes from Reservation r WHERE r.tableBar.nbPersonne=:nbPers GROUP BY r.dateResa")
//	List<LocalDate> findUniqueDate(@Param("nbPers") int nbPersonne);
	
	@Query("select r.heureRes from Reservation r WHERE r.tableBar.nbPersonne=:nbPers")
	Collection<LocalTime> findAllCrenauParDate(@Param("nbPers") int nbPersonne);
	
	List<Reservation> findAllByClientId(Integer id);
	
	@Query("select r.id from Reservation r")
	List<Integer> findAllId();
	
	@Query("select r from Reservation r WHERE r.dateRes>=:dateRes")
	List<Reservation> findAllByAfterDateRes(@Param("dateRes") LocalDate dateRes);

	@Query("select r from Reservation r WHERE r.dateRes<:dateRes")
	List<Reservation> findAllByBeforeDateRes(@Param("dateRes") LocalDate dateRes);
}
