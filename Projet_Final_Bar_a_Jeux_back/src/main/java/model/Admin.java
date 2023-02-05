package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Compte {	
	
	public Admin() {
		super();
	}
	
	public Admin(String mail, String password) {
		super(mail, password);
	}

	
	
}
