package test;

import java.time.LocalDate;
import java.util.Map;

import model.Achat;
import model.Client;
import model.Jeux;

public class Test {

	public static void main(String[] args) {
		
		
		Client c = new Client();
		
		Jeux j1 = new Jeux();
		
		Map<Jeux,Integer> panier = c.panier;
		
		if(panier.containsKey(j1)) 
		{
		  panier.replace(j1, panier.get(j1)+1);
		}
		else 
		{
			panier.put(j1, 1);
		}
		
		
		
		
		for(Jeux j : panier.keySet()) 
		{
			Achat a = new Achat(c,j,LocalDate.now());
			//daoAchat.insert(a);
			panier.remove(j);
		}
		
		
		
		
		
		
	}

}
