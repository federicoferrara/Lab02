package it.polito.tdp.alien;

import java.security.InvalidParameterException;
import java.util.*;

public class AlienDictionary {
	
////	List<WordEnhanced> dizionario;
//	Map<String,WordEnhanced> mapDizionario; 
//	
//	public AlienDictionary() {
////		dizionario= new LinkedList<>();
//		mapDizionario= new HashMap<>();
//	}
//	
//	public void addWord(String alienWord, String translation) {
//		if(mapDizionario.containsKey(alienWord)) {
//			this.mapDizionario.get(alienWord).setTranslation(translation);
//		}
//		else {
//			WordEnhanced parola= new WordEnhanced(alienWord,translation);
//			this.mapDizionario.put(alienWord, parola);
////			this.dizionario.add(parola);
//		}	
//	}
//	
//	public String translateWord(String alienWord) {
//		if(this.mapDizionario.containsKey(alienWord))
//			return this.mapDizionario.get(alienWord).getTranslation();
//		else
//			return "Errore, la parola da tradurre non è presente nel dizionario!";
//	}
	
	List<WordEnhanced> parole;
	
	public AlienDictionary() {
		parole= new LinkedList<WordEnhanced>();
	}
	
	public void add(String alienWord, String translation) {
		if(this.controlloInserimento(alienWord) && this.controlloInserimento(translation)) {
			for(WordEnhanced w: this.parole) {
				if(w.getAlienWorld().equals(alienWord)) {
					w.setTranslation(translation);
					return;
				}
			}
			WordEnhanced w= new WordEnhanced(alienWord,translation);
			this.parole.add(w);
		}
		else {
			throw new InvalidParameterException("Devi inserire solo lettere! NO numeri, NO caratteri speciali!");
		}
	}
	
	public String translate(String alienWorld) {
		
		if(this.controlloInserimento(alienWorld)) {
			
			if(alienWorld.contains("?")) {
				List<WordEnhanced> match= new LinkedList<>();
				for(WordEnhanced w: parole) {
					String prova=w.getAlienWorld();
					String provaCarattere=prova;
					for(char c: provaCarattere.toCharArray()) {
						provaCarattere=prova;
						c='?';
						if(prova.equals(alienWorld)) {
							match.add(w);
						}
					}
				}
				String risultato="";
				for(WordEnhanced w: match) {
					risultato+= w.getAlienWorld()+"-->"+w.getTranslation()+"\n";
				}
				if(risultato.equals(""))
					throw new InvalidParameterException("Devi prima registrare una traduzione per questa AlienWord!");
				else
					return risultato;
			}
			
			
			for(WordEnhanced w: parole) {
				if(w.getAlienWorld().equals(alienWorld))
					return w.getTranslation();
			}
			throw new InvalidParameterException("Devi prima registrare una traduzione per questa AlienWord!");	
		}
		else {
			throw new IllegalStateException("Devi inserire solo lettere! NO numeri, NO caratteri speciali!");
		}
	}
	
	public boolean controlloInserimento(String parola) {
		if(parola.matches("[a-zA-Z?]*")) {
			return true;
		}
		return false;
	}
	
	
}
