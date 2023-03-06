package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 2", 21, LocalDate.of(2022, 6, 10)));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2022, 7, 10)));
		
		lib.stampaPuntiUguali(25);
		
		Voto v = lib.ricercaVotoPerNome("Analisi 1");
		System.out.println(v.getPunti());
		Voto v2 = lib.ricercaVotoPerNome("Analisi 2");
		System.out.println(v2);
		
		Voto v3 = new Voto("Analisi 1", 29, LocalDate.of(2025, 6, 6));
		Voto v4 = new Voto("Analisi 1", 30, LocalDate.of(2025, 6, 6));
		
		System.out.println("v3 duplicato: "+ lib.esisteVoto(v3));
		System.out.println("v4 duplicato: "+ lib.esisteVoto(v4));
	}
}
