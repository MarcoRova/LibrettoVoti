package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		if(this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v)) {
			throw new IllegalArgumentException("Voto errato: "+v);
		}
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
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for(Voto v:voti) {
			if(v.isConflitto(nuovo))
				return true;
		}
		return false;	
	}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for(Voto v:voti) {
			if(v.isDuplicato(nuovo))
				return true;
		}
		return false;	
	}
	
	/**
	 * Metodo factory per creare un nuovo libretto con i voti migliorati
	 * @return libretto migliorato
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		
		//migliore.voti = new ArrayList<>(this.voti); //creo lista con gli stessi elementi e non copie
		
		migliore.voti = new ArrayList<>();
		
		for(Voto v: this.voti) {
			//migliore.voti.add(v.clone());
			migliore.voti.add(new Voto(v));
		}
		for(Voto v: migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCancellare = new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getPunti()<punti) {
				daCancellare.add(v);
			}
		}
		for(Voto v1:daCancellare) {
			this.voti.remove(v1);
		} //Meglio: this.voti.removeAll(daCancellare);
	}
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		
		Libretto ordinato = new Libretto();
		
		ordinato.voti = new ArrayList<>(this.voti);
		
		Collections.sort(ordinato.voti, new ComparatorByName());
		
		return ordinato;
		
	}
	
	public Libretto librettoOrdinatoVoto() {
		
		Libretto ordinato = new Libretto();
		
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>() { //implementazione del Comparatore in-line

			@Override
			public int compare(Voto o1, Voto o2) {
				return o2.getPunti()-o1.getPunti();
			}
		});
		
		return ordinato;
	}
	
}

