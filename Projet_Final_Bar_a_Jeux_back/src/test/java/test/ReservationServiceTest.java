package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.IdException;
import exception.ReservationException;
import model.Civilite;
import model.Client;
import model.Jeu;
import model.Reservation;
import model.TableBar;
import service.ClientService;
import service.JeuService;
import service.ReservationService;
import service.TableService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class ReservationServiceTest {
	
	@Autowired
	ReservationService resaSrv;
	
	@Autowired
	ClientService clientSrv;
	
	@Autowired
	TableService tableSrv;
	
	@Autowired
	JeuService jeuSrv;
	
	@Test
	void injectionReservationServiceTest() {
		assertNotNull(resaSrv);
	}
	
	@Test
	void creationReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		//System.out.println(resa1.toString());
		resaSrv.create(resa1);
	}
	
	@Test
	void creationReservationAvecJeuxTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		Jeu jeu1 = new Jeu("6 qui prend !",2,10,10,20,"Gigamic","2007",14.9,"\\Projet_Final\\bdd\\image_jeu\\6-qui-prend.png","logique,réflexes",6, "qui prend, la version française de 6 nimmt!");
		
		jeu1=jeuSrv.create(jeu1);
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1,jeu1);
		//System.out.println(resa1.toString());
		resaSrv.create(resa1);
	}

	@Test
	void deleteReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		resaSrv.create(resa1);
		assertNotNull(resaSrv.findById(resa1.getId()));
		resaSrv.delete(resa1);
	}
	
	@Test
	void updateReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		Jeu jeu1 = new Jeu("6 qui prend !",2,10,10,20,"Gigamic","2007",14.9,"\\Projet_Final\\bdd\\image_jeu\\6-qui-prend.png","logique,réflexes",6, "qui prend, la version française de 6 nimmt!");
		
		jeu1=jeuSrv.create(jeu1);
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		Reservation resaCreate = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		resaCreate = resaSrv.create(resaCreate);
		Reservation resaUpdate = new Reservation(resaCreate.getId(),LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1,jeu1);
		resaSrv.update(resaUpdate);
	}
	
	@Test
	void disableDatesReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		Reservation resa2 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("11:00:00"),4,table1,client1);
		Reservation resa3 = new Reservation(LocalDate.parse("2023-02-23"),LocalTime.parse("10:00:00"),4,table1,client1);
		
		
		resaSrv.create(resa1);
		resaSrv.create(resa2);
		resaSrv.create(resa3);
		List<LocalDate> datesDisable = resaSrv.findAllDisableDate(4);
		System.out.println(datesDisable);
	}
	
	@Test
	void disableHeuresReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		
		client1=clientSrv.save(client1);
		table1=tableSrv.create(table1);
		
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		Reservation resa2 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("11:00:00"),4,table1,client1);
		Reservation resa3 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		
		
		resaSrv.create(resa1);
		resaSrv.create(resa2);
		resaSrv.create(resa3);
		List<LocalTime> heuresDisable = resaSrv.findAllDisableHeureparDate(4);
		System.out.println(heuresDisable);
	}
	
	@Test
	void findByIdThrowsTest() {
		assertThrows(IdException.class, () -> {
			resaSrv.findById(1);
		});
	}

	@Test
	void checkConstraintThrowsTest() {
		
		assertThrows(ReservationException.class, () -> {
			Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
			client1=clientSrv.save(client1);
			resaSrv.create(new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,null,client1));
		});
		assertThrows(ReservationException.class, () -> {
			TableBar table1 = new TableBar(4,1);
			table1=tableSrv.create(table1);
			resaSrv.create(new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,null));
		});
		assertThrows(ReservationException.class, () -> {
			Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
			client1=clientSrv.save(client1);
			TableBar table1 = new TableBar(4,1);
			table1=tableSrv.create(table1);
			resaSrv.create(new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),0,table1,client1));
		});
		assertThrows(ReservationException.class, () -> {
			Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
			client1=clientSrv.save(client1);
			TableBar table1 = new TableBar(4,1);
			table1=tableSrv.create(table1);
			resaSrv.create(new Reservation(LocalDate.parse("2023-02-22"),null,4,table1,client1));
		});
		assertThrows(ReservationException.class, () -> {
			Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
			client1=clientSrv.save(client1);
			TableBar table1 = new TableBar(4,1);
			table1=tableSrv.create(table1);
			resaSrv.create(new Reservation(null,LocalTime.parse("10:00:00"),4,table1,client1));
		});
	}
	
	@Test
	void checkNotNullThrowsTest() {
		
		assertThrows(ReservationException.class, () -> {
			resaSrv.create(null);
		});
	}
}
