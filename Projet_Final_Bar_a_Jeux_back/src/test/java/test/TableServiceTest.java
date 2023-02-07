package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.IdException;
import exception.TableException;
import model.TableBar;
import service.TableService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class TableServiceTest {
	
	@Autowired
	TableService tableSrv;
	
	@Test
	void injectionTableServiceTest() {
		assertNotNull(tableSrv);
	}
	
	@Test
	void creationTableTest() {
		TableBar table1 = new TableBar(4,1);
		table1=tableSrv.create(table1);
	}

	@Test
	void deleteTableTest() {
		TableBar table1 = new TableBar(4,1);
		table1=tableSrv.create(table1);
		assertNotNull(tableSrv.findById(table1.getId()));
		tableSrv.delete(table1);
	}
	
	@Test
	void deleteTableIdTest() {
		TableBar table1 = new TableBar(4,1);
		table1=tableSrv.create(table1);
		tableSrv.delete(table1.getId());
	}
	
	@Test
	void updateTableTest() {
		TableBar tableCreate = new TableBar(4,1);
		tableCreate=tableSrv.create(tableCreate);
		TableBar resaUpdate = new TableBar(tableCreate.getId(),6,1);
		tableSrv.update(resaUpdate);
	}
	
	@Test
	void testFindAll() {
		assertTrue(tableSrv.findAll().isEmpty());
		TableBar tableCreate = new TableBar(4,1);
		tableCreate=tableSrv.create(tableCreate);

		assertEquals(1, tableSrv.findAll().size());

	}
	
	@Test
	void findByIdThrowsTest() {
		assertThrows(IdException.class, () -> {
			tableSrv.findById(0);
		});
	}

	@Test
	void checkConstraintThrowsTest() {
		
		TableException thrown1= assertThrows(TableException.class, () -> {
			tableSrv.create(new TableBar(0,1));
		});
		TableException thrown2= assertThrows(TableException.class, () -> {
			tableSrv.create(new TableBar(4,0));
		});
		
		assertTrue(thrown1.getMessage().contentEquals("capacité de la table obligatoire"));
		assertTrue(thrown2.getMessage().contentEquals("id de la table obligatoire"));
	}
	
	@Test
	void checkNotNullThrowsTest() {
		
		assertThrows(TableException.class, () -> {
			tableSrv.create(null);
		});
	}

}
