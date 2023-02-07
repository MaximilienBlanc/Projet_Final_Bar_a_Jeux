package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import exception.AchatJeuException;
import exception.IdException;
import exception.JeuException;
import model.AchatJeu;
import repository.IAchatJeuRepository;

public class AchatJeuService {

	@Autowired
	private IAchatJeuRepository achatJeuRepo;
	
	// creation achat jeu
		public AchatJeu create(AchatJeu achatJeu) {
			checkNotNull(achatJeu);
			checkConstraint(achatJeu);
			return achatJeuRepo.save(achatJeu);
		}
		
		private void checkNotNull(AchatJeu achatJeu) {
			if (achatJeu == null) {
				throw new AchatJeuException("achatJeu obligatoire");
			}
		}
		
		private void checkConstraint(AchatJeu achatJeu) {
			if (achatJeu.getDateAchat() == null) {
				throw new AchatJeuException("date d'achat obligatoire");
			}
			if (achatJeu.getQuantite() < 0) {
				throw new AchatJeuException("saisir quantité positive");
			}
			if (achatJeu.getJeu() == null) {
				throw new AchatJeuException("saisir un objet jeu");
			}
			if (achatJeu.getCommandeJeu() == null) {
				throw new AchatJeuException("saisir un objet commandeJeu");
			}
		}
		
		private void checkId(Integer id) {
			if (id == null) {
				throw new IdException();
			}
		}
		
		private void checkExist(AchatJeu achatJeu) {
			checkId(achatJeu.getId());
			findById(achatJeu.getId());
		}
		
		public void delete(AchatJeu achatJeu) {
			checkExist(achatJeu);
			achatJeuRepo.delete(achatJeu);
		}
		
		public void delete(Integer id) {
			delete(findById(id));
		}
		
		public AchatJeu findById(Integer id) {
			checkId(id);
			return achatJeuRepo.findById(id).orElseThrow(AchatJeuException::new);
		}
		
		public List<AchatJeu> findAll(){
			return achatJeuRepo.findAll();
		}
		
		
		public AchatJeu update(AchatJeu achatJeu) {
			checkNotNull(achatJeu);
			checkExist(achatJeu);
			checkConstraint(achatJeu);
			AchatJeu achatJeuEnBase = findById(achatJeu.getId());
			achatJeuEnBase.setDateAchat(achatJeuEnBase.getDateAchat());
			achatJeuEnBase.setQuantite(achatJeuEnBase.getQuantite());
			achatJeuEnBase.setJeu(achatJeuEnBase.getJeu());
			achatJeuEnBase.setCommandeJeu(achatJeuEnBase.getCommandeJeu());
			
			return achatJeuRepo.save(achatJeuEnBase);
		}
	
}
