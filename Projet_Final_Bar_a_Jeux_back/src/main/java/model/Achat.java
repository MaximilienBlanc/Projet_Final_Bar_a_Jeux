package model;

import java.time.LocalDate;

public class Achat {

	private Client client;
	private Jeu jeu;
	private LocalDate dateAchat;
	
	public Achat(Client client, Jeu jeu, LocalDate dateAchat) {
		this.client = client;
		this.jeu = jeu;
		this.dateAchat = dateAchat;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Jeu getJeu() {
		return jeu;
	}
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	public LocalDate getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	
	
	
}
