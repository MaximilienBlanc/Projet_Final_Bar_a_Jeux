package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import exception.AdminException;
import exception.IdException;
import model.Admin;
import model.Compte;
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
	void creationClientTest() {
		Admin compteAdmin = new Admin("toto@gmail.com","admin");
		adminSrv.create(compteAdmin);
		assertNotNull(adminSrv.findById(compteAdmin.getId()));
	}
	
//	@Test
//	void checkNotNullTest(Admin compteAdmin) {
//		
//	}
	
	
	
	
	
//	private void checkNotNull(Admin compteAdmin) {
//		if (compteAdmin == null) {
//			throw new AdminException("compte admin obligatoire");
//		}
//	}
//	
//	private void checkConstraint(Admin compteAdmin) {
//		if (compteAdmin.getMail() == null) {
//			throw new AdminException("mail obligatoire");
//		}
//		if (compteAdmin.getPassword() == null) {
//			throw new AdminException("mot de passe obligatoire");
//		}
//	}
//	
//	private void checkId(Integer id) {
//		if (id == null) {
//			throw new IdException();
//		}
//	}
//	
//	private void checkExist(Admin compteAdmin) {
//		checkId(compteAdmin.getId());
//		findById(compteAdmin.getId());
//	}
//	
//	public void delete(Admin compteAdmin) {
//		checkExist(compteAdmin);
//		adminRepo.delete(compteAdmin);
//	}
//	
//	public void delete(Integer id) {
//		delete(findById(id));
//	}
//	
//	public Admin findById(Integer id) {
//		checkId(id);
//		return adminRepo.findById(id);
//	}
//
//	public List<Admin> findAll(){	
//		return adminRepo.findAll();
//	}
//	
//	public Admin update(Admin compteAdmin) {
//		checkNotNull(compteAdmin);
//		checkExist(compteAdmin);
//		checkConstraint(compteAdmin);
//		Admin AdminEnBase = findById(compteAdmin.getId());
//		AdminEnBase.setMail(compteAdmin.getMail());
//		AdminEnBase.setPassword(compteAdmin.getPassword());
//		return adminRepo.save(AdminEnBase);
//	}
	
	
	
	
}
