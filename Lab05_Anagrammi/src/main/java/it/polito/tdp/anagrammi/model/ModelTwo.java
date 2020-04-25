package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class ModelTwo extends Model{
	private Integer N;
	private Parola originale;
	private Set<Parola> anagrammi;
	private AnagrammaDAO dao = new AnagrammaDAO();
	
	public Set<Parola> findAnagrammi(String parola) {	
		originale = new Parola(parola);
		N = originale.getParola().size();

		anagrammi = new HashSet<Parola>();

		Parola parziale = new Parola();
		Integer livello = 0;
		
		this.recursive(livello, parziale);	
		return anagrammi;
	}
	
	// Dato di partenza: parola da anagrammare di lunghezza N
	// Soluzione parziale: una parte dell'anagramma già costruito
	// Livello: numero di lettere di cui è composta la soluzione parziale
	// Soluzione finale: soluzione parziale di lunghezza N -> caso terminale
	// Caso terminale: salvare le soluzioni parziali
	// Generazione delle nuove soluzioni: provare ad aggiungere una lettera, scegliendola
	// tra quellche non sono ancora state utilizzate nella soluzione parziale
	
	private void recursive(Integer livello, Parola parziale) {

		if (livello == N) {
			this.anagrammi.add(new Parola(parziale));
			System.out.println(parziale);
		}
		else {
			List<Character> parola = new ArrayList<Character>(originale.getParola());
			
			for (Character c: parola) {				
				parziale.addParola(c);
				parola.remove(c);
				
				this.recursive(livello + 1, parziale);
				
				
				parziale.removeParola(c);
				parola.add(c);
			}
		}
	}
	
	public boolean isCorrect(Parola parola) {
		return dao.isCorrect(parola);
	}
}
