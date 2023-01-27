package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {

	@Column(length = 100)
	private String nom;
	@Column(length = 100)
	private String prenom;
	@Column(length = 50)
	private String tel;
	private LocalDate dateNaissance;
	@Transient
	private List<Reservation> reservations = new ArrayList<>();
	@Transient
	private List<CommandeJeu> commandeJeux = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	
	
	public Client() {
		super();
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getTel() {
		return tel;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public List<CommandeJeu> getCommandeJeux() {
		return commandeJeux;
	}


	public Civilite getCivilite() {
		return civilite;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public void setCommandeJeux(List<CommandeJeu> commandeJeux) {
		this.commandeJeux = commandeJeux;
	}


	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
		
	
}