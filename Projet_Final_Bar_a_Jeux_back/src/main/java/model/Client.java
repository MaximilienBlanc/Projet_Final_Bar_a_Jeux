package model;

import java.util.HashMap;
import java.util.Map;

public class Client extends Compte {

	
	public transient Map<Jeux,Integer> panier = new HashMap<Jeux, Integer>();
	
	
}
