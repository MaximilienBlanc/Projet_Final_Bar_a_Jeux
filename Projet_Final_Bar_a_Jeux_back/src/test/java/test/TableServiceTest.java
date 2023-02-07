package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	void updateTableTest() {
		TableBar tableCreate = new TableBar(4,1);
		tableCreate=tableSrv.create(tableCreate);
		TableBar resaUpdate = new TableBar(tableCreate.getId(),6,1);
		tableSrv.update(resaUpdate);
	}
	
	@Test
	void findByIdThrowsTest() {
		assertThrows(IdException.class, () -> {
			tableSrv.findById(1);
		});
	}

	@Test
	void checkConstraintThrowsTest() {
		
		assertThrows(TableException.class, () -> {
			tableSrv.create(new TableBar(0,1));
		});
		assertThrows(TableException.class, () -> {
			tableSrv.create(new TableBar(4,0));
		});
	}
	
	@Test
	void checkNotNullThrowsTest() {
		
		assertThrows(TableException.class, () -> {
			tableSrv.create(null);
		});
	}

}
