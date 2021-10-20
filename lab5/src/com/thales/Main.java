package com.thales;

public class Main {

	public static void main(final String[] args) {
		Panier p = new Panier(5);
		p.ajoute(new Orange("France", 0.80));
		p.ajoute(new Orange("Espagne", 0.80));
		p.ajoute(new Orange("Floride", 0.90));
		System.out.println("Panier contient " + p.taillePanier() + " Oranges");
		p.boycottOrigine("France");
		System.out.println("Panier contient " + p.taillePanier() + " Oranges");
	}

}
