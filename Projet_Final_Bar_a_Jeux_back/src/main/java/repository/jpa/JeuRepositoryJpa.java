package repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Jeu;
import repository.IJeuRepository;

@Repository
public class JeuRepositoryJpa implements IJeuRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Jeu> findAll() {	
		List<Jeu> jeux = new ArrayList<>();
		TypedQuery<Jeu> query = em.createQuery("select j from Jeu j", Jeu.class);
		jeux = query.getResultList();
		return jeux;
	}


	@Override
	public Jeu findById(Integer id) {
		Jeu jeu = null;
		TypedQuery<Jeu> query = em.createQuery("select j from Jeu j where j.id = :id" , Jeu.class);
		query.setParameter("id", id);						
		jeu = query.getSingleResult();	
		return jeu;
	}

	@Override
	@Transactional
	public Jeu save(Jeu jeu) {
		jeu = em.merge(jeu);
		return jeu;
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		TypedQuery<Jeu> query = em.createQuery("delete from Jeu j where j.id = :id", Jeu.class);
		query.setParameter("id",id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(Jeu j) {
		em.remove(em.merge(j));
	}

}
