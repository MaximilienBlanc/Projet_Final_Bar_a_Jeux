package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AchatJeu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dateAchat;
	private int quantite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jeu_id")
	private Jeu jeu;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CommandeJeu_id")
	private CommandeJeu commandeJeu;
	
	public AchatJeu() {
		super();
	}

	
	public AchatJeu(LocalDate dateAchat, int quantite, Jeu jeu, CommandeJeu commandeJeu) {
		super();
		this.dateAchat = dateAchat;
		this.quantite = quantite;
		this.jeu = jeu;
		this.commandeJeu = commandeJeu;
	}
	

	public AchatJeu(int id, LocalDate dateAchat, int quantite, Jeu jeu, CommandeJeu commandeJeu) {
		super();
		this.id = id;
		this.dateAchat = dateAchat;
		this.quantite = quantite;
		this.jeu = jeu;
		this.commandeJeu = commandeJeu;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public CommandeJeu getCommandeJeu() {
		return commandeJeu;
	}

	public void setCommandeJeu(CommandeJeu commandeJeu) {
		this.commandeJeu = commandeJeu;
	}
	
	
}
