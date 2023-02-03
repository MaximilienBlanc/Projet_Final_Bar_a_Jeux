package service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ReservationException;
import model.Client;
import model.Jeu;
import model.Reservation;
import model.TableBar;
import repository.IReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private IReservationRepository resaRepo;
	
	// creation réservation
		public Reservation create(LocalDate dateRes, LocalTime heureRes, Integer nbPersonne,TableBar tableBar, Client client, Jeu jeu) {
			Reservation resa = new Reservation(dateRes, heureRes, nbPersonne, tableBar, client, jeu);
			return create(resa);
		}
		
		public Reservation create(Reservation resa) {
			if (resa.getDateRes() == null) {
				throw new ReservationException("date absente");
			}
			if (resa.getHeureRes() == null) {
				throw new ReservationException("heure absente");
			}
			if (resa.getNbPersonne() == 0) {
				throw new ReservationException("nombre de joueur absent");
			}
			return resaRepo.save(resa);
		}
		
		
		

}
