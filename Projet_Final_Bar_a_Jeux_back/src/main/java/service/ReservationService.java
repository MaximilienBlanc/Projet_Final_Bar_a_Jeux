package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.ReservationException;
import model.Reservation;
import repository.IReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private IReservationRepository resaRepo;
	
	// creation réservation
		public Reservation create(Reservation resa) {
			checkNotNull(resa);
			checkConstraint(resa);
			return resaRepo.save(resa);
		}
		
		private void checkNotNull(Reservation resa) {
			if (resa == null) {
				throw new ReservationException("formateur obligatoire");
			}
		}
		
		private void checkConstraint(Reservation resa) {
			if (resa.getDateRes() == null) {
				throw new ReservationException("date obligatoire");
			}
			if (resa.getHeureRes() == null) {
				throw new ReservationException("heure obligatoire");
			}
			if (resa.getClient() == null) {
				throw new ReservationException("client obligatoire");
			}
			if (resa.getNbPersonne() == 0) {
				throw new ReservationException("personne obligatoire");
			}
			if (resa.getJeu() == null) {
				throw new ReservationException("personne obligatoire");
			}
		}
		
		private void checkId(Integer id) {
			if (id == null) {
				throw new IdException();
			}
		}

		private void checkExist(Reservation resa) {
			checkId(resa.getId());
			findById(resa.getId());
		}

		public void delete(Reservation resa) {
			checkExist(resa);
			resaRepo.delete(resa);
		}

		public void delete(Integer id) {
			delete(findById(id));
		}
		
		public Reservation findById(Integer id) {
			checkId(id);
			return resaRepo.findById(id).orElseThrow(ReservationException::new);
		}
		
		public List<Reservation> findAll(){
			return resaRepo.findAll();
		}

}
