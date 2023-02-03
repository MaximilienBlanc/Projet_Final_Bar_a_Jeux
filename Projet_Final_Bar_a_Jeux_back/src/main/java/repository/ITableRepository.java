package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.TableBar;

public interface ITableRepository extends JpaRepository<TableBar, Integer>{

}
