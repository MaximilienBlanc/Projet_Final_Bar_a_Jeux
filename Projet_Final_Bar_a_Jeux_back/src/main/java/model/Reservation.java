package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dateRes;
	private LocalTime heureRes;
	private int nbPersonne;
	@ManyToOne
	@JoinColumn(name = "tableBar_id")
	private TableBar table;
	@OneToMany(mappedBy = "reservation")
	private List<CommandeConso> commandeConsos = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@OneToOne
	@JoinColumn(name ="jeu_id")
	private Jeu jeu;
	
	public Reservation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TableBar getTable() {
		return table;
	}

	public void setTable(TableBar table) {
		this.table = table;
	}

	public List<CommandeConso> getCommandeConsos() {
		return commandeConsos;
	}

	public void setCommandeConsos(List<CommandeConso> commandeConsos) {
		this.commandeConsos = commandeConsos;
	}

	public LocalDate getDateRes() {
		return dateRes;
	}

	public void setDateRes(LocalDate dateRes) {
		this.dateRes = dateRes;
	}

	public LocalTime getHeureRes() {
		return heureRes;
	}

	public void setHeureRes(LocalTime heureRes) {
		this.heureRes = heureRes;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
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
	
	
	

}
