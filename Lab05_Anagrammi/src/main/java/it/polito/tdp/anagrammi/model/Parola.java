package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Parola {
	List<Character> parola;
	
	public Parola(List<Character> parola) {
		parola = new ArrayList<Character>();
		this.parola.addAll(parola);
		
	}

	public Parola() {
		parola = new ArrayList<Character>();
	}

	
	public Parola(Parola parziale) {
		parola = new ArrayList<Character>();
		this.parola.addAll(parziale.getParola());
	}
	
	public Parola(String stringa) {
		parola = new ArrayList<Character>();
		
		for (Character ch: stringa.toCharArray())
			parola.add(ch);
	}
	

	public List<Character> getParola() {
		return parola;
	}

	public void addParola(Character lettera) {
		this.parola.add(lettera);
	}
	
	public void removeParola(Character lettera) {
		this.parola.remove(parola.lastIndexOf(lettera));
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		for (Character c: parola)
			s.append(c);
		
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null) {
				return false;
			}
		} else if (!parola.equals(other.parola)) {
			return false;
		}
		return true;
	}
	
	
	
	

	
}
