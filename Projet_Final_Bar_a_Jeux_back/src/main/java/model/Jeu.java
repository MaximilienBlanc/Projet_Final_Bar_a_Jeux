package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Jeu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int nbJoueurMin;
	private int nbJoueurMax;
	private int ageMin;
	private int duree;
	private String editeur;
	private String annee;
	private double prix;
	private String image;
	private String typeJeu;
	private String description;
	private int stock;
	@Transient
	private Reservation reservation;
	
	@OneToMany(mappedBy = "jeu")
	private List<AchatJeu> achatJeux = new ArrayList<>();
	
	public Jeu() {
		super();
	}

	public Jeu(String nom, int nbJoueurMin, int nbJoueurMax, int ageMin, int duree, String editeur, String annee, double prix,
			String image, String typeJeu, String description, int stock) {
		super();
		this.nom = nom;
		this.nbJoueurMin = nbJoueurMin;
		this.nbJoueurMax = nbJoueurMax;
		this.ageMin = ageMin;
		this.duree = duree;
		this.editeur = editeur;
		this.annee = annee;
		this.prix = prix;
		this.image = image;
		this.typeJeu = typeJeu;
		this.description = description;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbJoueurMin() {
		return nbJoueurMin;
	}

	public void setNbJoueurMin(int nbJoueurMin) {
		this.nbJoueurMin = nbJoueurMin;
	}

	public int getNbJoueurMax() {
		return nbJoueurMax;
	}

	public void setNbJoueurMax(int nbJoueurMax) {
		this.nbJoueurMax = nbJoueurMax;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTypeJeu() {
		return typeJeu;
	}

	public void setTypeJeu(String typeJeu) {
		this.typeJeu = typeJeu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<AchatJeu> getAchatJeux() {
		return achatJeux;
	}

	public void setAchatJeux(List<AchatJeu> achatJeux) {
		this.achatJeux = achatJeux;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}
