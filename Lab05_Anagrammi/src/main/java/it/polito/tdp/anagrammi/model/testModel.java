package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class testModel {

	public static void main(String[] args) {
		Model model = new Model();
		
		Set<Parola> insieme = model.findAnagrammi("cavolo");
		System.out.println(insieme.size());
		
		for (Parola a : insieme)
			System.out.println(a.toString());
		
		
	}

}
