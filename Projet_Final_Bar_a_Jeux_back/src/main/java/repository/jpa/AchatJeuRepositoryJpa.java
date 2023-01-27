package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import context.Application;
import model.AchatJeu;
import model.Jeu;
import repository.IAchatJeuRepository;

public class AchatJeuRepositoryJpa implements IAchatJeuRepository {

	@Override
	public List<AchatJeu> findAll() {
	
		List<AchatJeu> achatJeux = new ArrayList<>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<AchatJeu> query = em.createQuery("select aj from AchatJeu aj", AchatJeu.class);

			achatJeux = query.getResultList();

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

		return achatJeux;
	}

	@Override
	public AchatJeu findById(Integer id) {
		
		AchatJeu achatJeu = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<AchatJeu> query = em.createQuery("select aj from achatJeu aj where aj.id = :id ", AchatJeu.class);
			query.setParameter("id", id);						
			achatJeu = query.getSingleResult();	

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

		return achatJeu;
		
	}

	@Override
	public AchatJeu save(AchatJeu aj) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			aj = em.merge(aj);

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

		return aj;
	}

	@Override
	public void deleteById(Integer id) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<AchatJeu> query = em.createQuery("delete from AchatJeu aj where aj.id = :id", AchatJeu.class);
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

	@Override
	public void delete(AchatJeu aj) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(aj));

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
