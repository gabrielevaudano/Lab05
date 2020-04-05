package it.polito.tdp.anagrammi.model;

public class Lettera {
	private Character lettera;

	public Lettera(Character lettera) {
		this.lettera = lettera;
	}

	public Character getLettera() {
		return lettera;
	}

	public void setLettera(Character lettera) {
		this.lettera = lettera;
	}

	@Override
	public String toString() {
		return Character.toString(lettera);
	}
	
	
	
}
