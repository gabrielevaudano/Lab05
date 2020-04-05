package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	Integer N;
	Parola originale;
	Set<Parola> anagrammi;
	AnagrammaDAO dao = new AnagrammaDAO();
	
	public Set<Parola> findAnagrammi(String parola) {	
		originale = new Parola(parola);
		N = originale.getParola().size();

		anagrammi = new HashSet<Parola>();

		Parola parziale = new Parola();
		int livello = 0;
		
		this.recursive(livello, parziale);	
		return anagrammi;
	}
	
	private void recursive(Integer livello, Parola parziale) {

		if (livello == N)
			this.anagrammi.add(new Parola(parziale));
		
		else {
			List<Character> parola = originale.getParola();
			
			for (int j=0; j<parola.size(); j++) {
				Character c = parola.get(j);
				
				parziale.addParola(c);
				parola.remove(c);
				
				this.recursive(livello + 1, parziale);
				
				parziale.removeParola(c);
				parola.add(j, c);
			}
		}
	}
	
	public boolean isCorrect(Parola parola) {
		return dao.isCorrect(parola);
	}
}
