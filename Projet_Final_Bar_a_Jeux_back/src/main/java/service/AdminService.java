package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.AdminException;
import exception.IdException;
import model.Admin;
import repository.IAdminRepository;

@Service
public class AdminService {

	@Autowired 
	private IAdminRepository adminRepo;
	
	public Admin create(String mail, String password) {
		Admin compteAdmin = new Admin(mail, password);
		return save(compteAdmin);
	}
	
	
	public Admin save(Admin compteAdmin) {
		checkNotNull(compteAdmin);
		checkConstraint(compteAdmin);
		return adminRepo.save(compteAdmin);
	}
	
	public void checkNotNull(Admin compteAdmin) {
		if (compteAdmin == null) {
			throw new AdminException("compte admin obligatoire");
		}
	}
	
	private void checkConstraint(Admin compteAdmin) {
		if (compteAdmin.getMail() == null || compteAdmin.getMail().isBlank()) {
			throw new AdminException("mail obligatoire");
		}
		if (compteAdmin.getPassword() == null || compteAdmin.getPassword().isBlank()) {
			throw new AdminException("mot de passe obligatoire");
		}
	}
	
	private void checkId(Integer id) {
		if (id == null) {
			throw new IdException();
		}
	}
	
	private void checkExist(Admin compteAdmin) {
		checkId(compteAdmin.getId());
		findById(compteAdmin.getId());
	}
	
	public void delete(Admin compteAdmin) {
		checkExist(compteAdmin);
		adminRepo.delete(compteAdmin);
	}
	
	public void delete(Integer id) {
		delete(findById(id));
	}
	
	public Admin findById(Integer id) {
		checkId(id);
		return adminRepo.findById(id).orElseThrow(AdminException::new);
	}

	public List<Admin> findAll(){	
		return adminRepo.findAll();
	}
	
	public Admin update(Admin compteAdmin) {
		checkNotNull(compteAdmin);
		checkExist(compteAdmin);
		checkConstraint(compteAdmin);
		Admin AdminEnBase = findById(compteAdmin.getId());
		AdminEnBase.setMail(compteAdmin.getMail());
		AdminEnBase.setPassword(compteAdmin.getPassword());
		return adminRepo.save(AdminEnBase);
	}
}

