package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Commande_conso")
public class CommandeConso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int qtité;
	@Transient
	private Conso conso;
	
	
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
	public Conso getConso() {
		return conso;
	}
	public void setConso(Conso conso) {
		this.conso = conso;
	}
	
	
	
}
