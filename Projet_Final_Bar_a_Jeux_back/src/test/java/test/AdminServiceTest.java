package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.AdminException;
import model.Admin;
import service.AdminService;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class AdminServiceTest {

	@Autowired 
	AdminService adminSrv;


	@Test
	void injectionAdminServiceTest() {
		assertNotNull(adminSrv);
	}

	@Test
	void saveAdminTest() {
		Admin admin2 = new Admin("admin2@test.fr","admin2");
		adminSrv.save(admin2);
		assertNotNull(adminSrv.findById(admin2.getId()));
	}

	@Test
	void creationAdminTest() {
		Admin admin3 = adminSrv.create("admin3@test.fr","admin3");
		assertEquals("admin3@test.fr", admin3.getMail());
		assertEquals("admin3", admin3.getPassword());
	}

	@Test
	void checkNotNullTest() {
		Admin admin4 = null;
		assertThrows(AdminException.class, () -> {
			adminSrv.checkNotNull(admin4);
		});
	}

	@Test
	void checkConstraintMailTest() {
		assertThrows(AdminException.class, () -> {
			adminSrv.save(new Admin(null, "admin5"));
		});
	}

	@Test
	void checkConstraintPasswordTest() {
		assertThrows(AdminException.class, () -> {
			adminSrv.save(new Admin("admin6@test.fr", null));
		});
	}

	@Test
	void deleteAdminTest() {
		Admin admin7 = new Admin("admin7@test.fr","admin7");
		adminSrv.save(admin7);
		adminSrv.delete(admin7);	
		assertThrows(AdminException.class, () -> {
			adminSrv.findById(admin7.getId());
		});	
	}

	@Test
	void deleteByIdTest() {
		Admin admin8 = new Admin("admin8@test.fr","admin8");
		adminSrv.save(admin8);
		adminSrv.delete(admin8.getId());	
		assertThrows(AdminException.class, () -> {
			adminSrv.findById(admin8.getId());
		});	
	}

	@Test
	void findByIdTest() {
		Admin admin9 = new Admin("admin9@test.fr","admin9");
		adminSrv.save(admin9);
		assertNotNull(adminSrv.findById(admin9.getId()));
	}

	//problème car test uniquement s'il y a une liste d'admin vide
	//erreur quand on a un admin en bdd
	@Test 
	void findAllTest() {
		List<Admin> admins = new ArrayList<>();	
		assertEquals(admins,adminSrv.findAll());		

	}

	void updateMailTest() {
		//création d'un admin
		// modification d'un admin
		//assertEquals le mail modifié
	}

	void updatePasswordTest() {
		//création d'un admin
				// modification d'un admin
		//assertEquals le password modifié 
	}

}
