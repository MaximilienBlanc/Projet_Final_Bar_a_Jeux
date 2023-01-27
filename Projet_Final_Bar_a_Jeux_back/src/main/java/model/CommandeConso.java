package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Commande_conso")
public class CommandeConso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int qtité;
	@OneToMany(mappedBy="commandeConso")
	private List<Conso> consos;
	@ManyToOne
	@JoinColumn(name="reservation")
	private Reservation reservation;
	
	
	public CommandeConso() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtité() {
		return qtité;
	}
	public void setQtité(int qtité) {
		this.qtité = qtité;
	}

	public List<Conso> getConsos() {
		return consos;
	}

	public void setConsos(List<Conso> consos) {
		this.consos = consos;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	
}
