package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.IAchatJeuRepository;
import repository.ICommandeJeuRepository;
import repository.ICompteRepository;
import repository.IEvenementRepository;
import repository.IJeuRepository;
import repository.IReservationRepository;
import repository.ITableRepository;
import repository.jpa.AchatJeuRepositoryJpa;
import repository.jpa.CommandeJeuRepositoryJpa;
import repository.jpa.CompteRepositoryJpa;
import repository.jpa.EvenementRepositoryJpa;
import repository.jpa.JeuRepositoryJpa;
import repository.jpa.ReservationRepositoryJpa;
import repository.jpa.TableRepositoryJpa;

public class Application {
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projet_final");
	
	private final IAchatJeuRepository achatJeuRepo = new AchatJeuRepositoryJpa();
	private final ICommandeJeuRepository commandeJeuRepo = new CommandeJeuRepositoryJpa();
	private final IJeuRepository jeuRepo = new JeuRepositoryJpa();
	private final IReservationRepository reservationRepo = new ReservationRepositoryJpa();
	private final ITableRepository tableRepo = new TableRepositoryJpa();
	private final ICompteRepository compteRepo = new CompteRepositoryJpa();
	private final IEvenementRepository evenementRepo = new EvenementRepositoryJpa();
	
	
	private Application() {
	}
	
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IAchatJeuRepository getAchatJeuRepo() {
		return achatJeuRepo;
	}

	public ICommandeJeuRepository getCommandeJeuRepo() {
		return commandeJeuRepo;
	}

	public IJeuRepository getJeuRepo() {
		return jeuRepo;
	}

	public IReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public ITableRepository getTableRepo() {
		return tableRepo;
	}

	public ICompteRepository getCompteRepo() {
		return compteRepo;
	}

	public IEvenementRepository getEvenementRepo() {
		return evenementRepo;
	}

	
}
