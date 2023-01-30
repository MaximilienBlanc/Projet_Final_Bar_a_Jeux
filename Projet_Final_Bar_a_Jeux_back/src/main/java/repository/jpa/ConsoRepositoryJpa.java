package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import context.Application;
import model.Conso;
import repository.IConsoRepository;

public class ConsoRepositoryJpa implements IConsoRepository {

		
		public List<Conso> findAll() {
			
			List<Conso> consos = new ArrayList<>();

			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<Conso> query = em.createQuery("select j from conso j", Conso.class);

				consos = query.getResultList();

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

			return consos;
		}

		
		
		public Conso findById(Integer id) {
			
			Conso conso = null;
			EntityManager em = null;
			EntityTransaction tx = null;
			try {
				
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();
				
				TypedQuery<Conso> query = em.createQuery("select j from conso j where j.id = :id" , Conso.class);
				query.setParameter("id", id);						
				conso = query.getSingleResult();	

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

			return conso;
		}

		
		public Conso save(Conso conso) {
			
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				conso = em.merge(conso);

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

			return conso;
		}

		
		public void deleteById(Integer id) {
			
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<Conso> query = em.createQuery("delete from conso j where j.id = :id", Conso.class);
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

		
		public void delete(Conso c) {
			
			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				em.remove(em.merge(c));

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
	
