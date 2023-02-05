package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
				throw new ReservationException("réservation obligatoire");
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
			// donner un jeu n'est pas obligatoire
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
		
		public Reservation update(Reservation resa) {
			checkNotNull(resa);
			checkExist(resa);
			checkConstraint(resa);
			Reservation resaEnBase = findById(resa.getId());
			resaEnBase.setDateRes(resa.getDateRes());
			resaEnBase.setHeureRes(resa.getHeureRes());
			resaEnBase.setClient(resa.getClient());
			resaEnBase.setNbPersonne(resa.getNbPersonne());
			// donner un jeu n'est pas obligatoire
			if (resa.getJeu() != null) {
				resaEnBase.setJeu(resa.getJeu());
			}
			return resaRepo.save(resaEnBase);
		}
		
		
		public Reservation findById(Integer id) {
			checkId(id);
			return resaRepo.findById(id).orElseThrow(ReservationException::new);
		}
		
		public List<Reservation> findAll(){
			return resaRepo.findAll();
		}
		
		public List<LocalDate> findAllDisableDate(int nbPersonne){
			Map<LocalDate, Integer> dates = resaRepo.findAllDate(nbPersonne);
			List<LocalDate> dateDisables = new ArrayList<>();
			for (var date : dates.entrySet()) {
				if (date.getValue()==40) {
					dateDisables.add(date.getKey());
				}
			}
			return dateDisables;
		}
		
		public List<LocalTime> findAllDisableCrenau(LocalDate dateRes){
			Map<LocalTime, Integer> heures = resaRepo.findAllCrenauParDate(dateRes);
			List<LocalTime> heureDisables = new ArrayList<>();
			for (var heure : heures.entrySet()) {
				if (heure.getValue()==40) {
					heureDisables.add(heure.getKey());
				}
			}
			return heureDisables;
		}

}
