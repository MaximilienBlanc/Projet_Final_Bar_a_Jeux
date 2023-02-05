package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class CommandeJeu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "commandeJeu")
	private List<AchatJeu> achatJeux = new ArrayList<>();

	public CommandeJeu() {
		super();
	}
	
	

	public CommandeJeu(Statut statut) {
		super();
		this.statut = statut;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<AchatJeu> getAchatJeux() {
		return achatJeux;
	}

	public void setAchatJeux(List<AchatJeu> achatJeux) {
		this.achatJeux = achatJeux;
	}


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	
	
}
