package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "mail" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_personne", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String mail;
	@Column(length = 100)
	private String password;
	
	public Compte() {
		super();
	}

	public Compte(Integer id, String mail, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
	}
	
	public Compte(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
