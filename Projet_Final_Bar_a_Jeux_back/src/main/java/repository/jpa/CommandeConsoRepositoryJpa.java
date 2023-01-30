package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import context.Application;
import model.CommandeConso;
import repository.ICommandeConsoRepository;

public class CommandeConsoRepositoryJpa implements ICommandeConsoRepository {
	
	public List<CommandeConso> findAll() {
		
		List<CommandeConso> commandesConso = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<CommandeConso> query = em.createQuery("select com from commandeConso com", CommandeConso.class);

			commandesConso = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return commandesConso;
	}

	
	
	public CommandeConso findById(Integer id) {
		
		CommandeConso commandeConso = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<CommandeConso> query = em.createQuery("select com from commandeConso com where com.id = :id" , CommandeConso.class);
			query.setParameter("id", id);						
			commandeConso = query.getSingleResult();	

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return commandeConso;
	}

	
	public CommandeConso save(CommandeConso commandeConso) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			commandeConso = em.merge(commandeConso);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return commandeConso;
	}

	
	public void deleteById(Integer id) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<CommandeConso> query = em.createQuery("delete from commandeConso com where com.id = :id", CommandeConso.class);
			query.setParameter("id",id);
			query.executeUpdate();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	
	public void delete(CommandeConso com) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(com));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
