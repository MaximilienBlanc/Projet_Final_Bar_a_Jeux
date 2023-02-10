package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "table_bdd")
public class TableBar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Evenement evenement;
	private int nbPersonne;
	private int idTable;
	@OneToMany(mappedBy = "tableBar")
	private List<Reservation> reservations = new ArrayList<>();
	// à voir si cette liste est necessaire à un moment
	
	public TableBar() {
	}
	
	


	public TableBar(int nbPersonne, int idTable) {
		this.nbPersonne = nbPersonne;
		this.idTable = idTable;
	}

	


	public TableBar(int id, int nbPersonne, int idTable) {
		this.id = id;
		this.nbPersonne = nbPersonne;
		this.idTable = idTable;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}


	public int getIdTable() {
		return idTable;
	}


	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
