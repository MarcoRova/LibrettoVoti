package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto implements Comparable<Voto>{
	
	private String corso;
	private int punti; // da 18 a 31
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	//Copy constructor di voto
	public Voto(Voto v) {
		this.corso = v.corso;
		this.punti = v.punti;
		this.dataEsame = v.dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return "Voto [corso = " + corso + ", voto = " + punti + ", data Esame = " + dataEsame + "]";
	}
	
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() == altro.getPunti();
	}

	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso()) && this.getPunti() != altro.getPunti();
	}
	
	public Voto clone() {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}

	@Override
	public int compareTo(Voto other) {
		// TODO calcola this - other
		return 0;
	}
}
