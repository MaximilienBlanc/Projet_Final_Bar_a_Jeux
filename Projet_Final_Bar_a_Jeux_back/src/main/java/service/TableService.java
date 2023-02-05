package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.TableException;
import model.TableBar;
import repository.ITableRepository;

@Service
public class TableService {
	
	@Autowired
	private ITableRepository tableRepo;
	
	// creation réservation
		public TableBar create(TableBar table) {
			checkNotNull(table);
			checkConstraint(table);
			return tableRepo.save(table);
		}
		
		private void checkNotNull(TableBar table) {
			if (table == null) {
				throw new TableException("table obligatoire");
			}
		}
		
		private void checkConstraint(TableBar table) {
			if (table.getNbPersonne() == 0) {
				throw new TableException("capacité de la table obligatoire");
			}
			if (table.getIdTable() == 0) {
				throw new TableException("id de la table obligatoire");
			}
		}
		
		private void checkId(Integer id) {
			if (id == null) {
				throw new IdException();
			}
		}

		private void checkExist(TableBar table) {
			checkId(table.getId());
			findById(table.getId());
		}

		public void delete(TableBar table) {
			checkExist(table);
			tableRepo.delete(table);
		}

		public void delete(Integer id) {
			delete(findById(id));
		}
		
		public TableBar update(TableBar table) {
			checkNotNull(table);
			checkExist(table);
			checkConstraint(table);
			TableBar tableEnBase = findById(table.getId());
			tableEnBase.setIdTable(table.getIdTable());
			tableEnBase.setNbPersonne(table.getNbPersonne());
			// donner un jeu n'est pas obligatoire
			if (table.getEvenement() != null) {
				tableEnBase.setEvenement(table.getEvenement());
			}
			return tableRepo.save(tableEnBase);
		}
		
		public TableBar findById(Integer id) {
			checkId(id);
			return tableRepo.findById(id).orElseThrow(TableException::new);
		}
		
		public List<TableBar> findAll(){
			return tableRepo.findAll();
		}

}
