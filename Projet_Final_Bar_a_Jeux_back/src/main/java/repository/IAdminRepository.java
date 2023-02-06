package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
