package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {

//	private String alienWord;
//	private List<String> translation= new LinkedList<>();
//	
//	
//	public WordEnhanced(String alienWord, String translation) {
//		super();
//		this.alienWord = alienWord;
//		this.translation.add(translation);
//	}
//	
//	
//	public String getAlienWord() {
//		return alienWord;
//	}
//
//
//	public void setAlienWord(String alienWord) {
//		this.alienWord = alienWord;
//	}
//
//
//	public String getTranslation() {
//		String risultato="";
//		for(String s: this.translation)
//			risultato+=s+"\n";
//		return risultato;
//	}
//
//
//	public void setTranslation(String translation) {
//		this.translation.add(translation);
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		WordEnhanced other = (WordEnhanced) obj;
//		if (alienWord == null) {
//			if (other.alienWord != null)
//				return false;
//		} else if (!alienWord.equals(other.alienWord))
//			return false;
//		return true;
//	}
	
	private String alienWorld;
	private List<String> translation= new LinkedList<>();
	
	public WordEnhanced(String alienWorld, String translation) {
		super();
		this.alienWorld = alienWorld;
		this.translation.add(translation);
	}
	
	public String getAlienWorld() {
		return alienWorld;
	}
	
	public void setAlienWorld(String alienWorld) {
		this.alienWorld = alienWorld;
	}
	
	public String getTranslation() {
		String risultato="";
		for(String s: this.translation) {
			risultato+=s+" ";
		}
		return risultato;
	}
	
	public void setTranslation(String translation) {
		this.translation.add(translation);
	}
	
	
	
	
	
	
	
}
