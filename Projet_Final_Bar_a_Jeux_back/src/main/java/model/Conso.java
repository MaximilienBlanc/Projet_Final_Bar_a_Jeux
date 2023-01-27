package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Conso")
public class Conso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private double prix;
	@Column
	private String nom;
	@Column(name="type_conso")
	@Enumerated(EnumType.STRING)
	private TypeConso conso;
	@ManyToOne
	@JoinColumn(name="CommandeConso")
	private CommandeConso commandeConso;
	
	
	
	public Conso() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TypeConso getConso() {
		return conso;
	}
	public void setConso(TypeConso conso) {
		this.conso = conso;
	}
	public CommandeConso getCommandeConso() {
		return commandeConso;
	}
	public void setCommandeConso(CommandeConso commandeConso) {
		this.commandeConso = commandeConso;
	}
	
	
	
	

}
