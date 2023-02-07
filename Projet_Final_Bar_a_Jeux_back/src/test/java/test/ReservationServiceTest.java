package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import model.Civilite;
import model.Client;
import model.Reservation;
import model.TableBar;
import service.ClientService;
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
	
	@Test
	void injectionReservationServiceTest() {
		assertNotNull(resaSrv);
	}
	
	@Test
	void creationReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		//System.out.println(resa1.toString());
		resaSrv.create(resa1);
	}

	@Test
	void deleteReservationTest() {
		Client client1 = new Client("client1@test.fr","client1","client1","client2","0600000001",Civilite.homme);
		TableBar table1 = new TableBar(4,1);
		Reservation resa1 = new Reservation(LocalDate.parse("2023-02-22"),LocalTime.parse("10:00:00"),4,table1,client1);
		resaSrv.create(resa1);
		assertNotNull(resaSrv.findById(resa1.getId()));
		resaSrv.delete(resa1);
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

}
