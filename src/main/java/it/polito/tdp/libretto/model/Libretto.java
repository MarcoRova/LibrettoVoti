package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;


public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		super();
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto
	 * (per ora nessun controllo)
	 * @param v è il voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	
	public void stampa() {
		for(Voto v:voti) {
			System.out.println(v.toString());
		}
	}
	
	public void stampaPuntiUguali(int valore) {
		for(Voto v:voti) {
			if(v.getPunti()==valore)
				System.out.println(v.toString());
		}
	}
	
	public Voto ricercaVotoPerNome(String corso){
		for(Voto v:voti) {
			if(v.getCorso().equals(corso)) {
				return v;
			}
		}
		return null;
		//throw new Exception
	}
	
	public boolean esisteVoto(Voto nuovo) {
		for(Voto v:voti) {
			//if(v.equalsCorsoPunti(nuovo)) creando il relativo metodo
			if(v.getCorso().equals(nuovo.getCorso()) && v.getPunti() == nuovo.getPunti())
				return true;
		}
		return false;	
	}
}

