package com.thales;

import java.util.ArrayList;
import java.util.Iterator;

public class Panier {

	final int taille; 
	final ArrayList <Orange> panier;
	
	public Panier(final int uneTaille) {
		taille = uneTaille;
		panier = new ArrayList<Orange>(taille);
	}
	
	public int getPanier() {
		return panier.size();
	}

	public int taillePanier() {
		return panier.size();
	}

	public boolean estPlein() {
		return (panier.size() == taille);
	}

	public boolean estVide() {
		return panier.isEmpty();
	}

	public String toString() {
		final StringBuilder buf = new StringBuilder();
		for (Orange i : panier) {
			buf.append(i.getOrigine())
			.append(" | ")
			.append(i.getPrix())
			.append('\n');
		}
		return buf.toString();
	}

	public void ajoute(final Orange o) throws RuntimeException {
		if (panier.size() < taille) {
			panier.add(o);
		} else {
			throw new RuntimeException("Le panier est plein");
		}
	}

	public void retire() {
		panier.remove(panier.size() - 1);
	}

	public double getPrix() {
		double resultat = 0;
		for (Orange i : panier) {
			resultat += i.getPrix();
		} 
		return resultat;
	}

	public void boycottOrigine(final String origine) {
		Iterator<Orange> iter = panier.iterator();
		Orange o;
		while (iter.hasNext()) {
			o = iter.next();
			if (o.getOrigine() == origine) {
				iter.remove();
			}
		}
	}

	public static boolean equals(final Panier p1, final Panier p2) {
		boolean resultat = false;
		if ((p1 != null) && (p2 != null)) {
			for (int i = 0; i < p1.panier.size(); i++) {
				for (int k = 0; k < p2.panier.size(); k++) {
					Orange it = new Orange("", 0);
					if (p1.panier.get(i).getOrigine().equals(p2.panier.get(k).getOrigine())
						&& p1.panier.get(i).getPrix() == p2.panier.get(k).getPrix()) {
						if (it != p2.panier.get(k)) {
							it = p1.panier.get(i);
						}
						resultat = true;
						if (it == p2.panier.get(k)) {
							resultat = false;	
						}
					}
				}
			}
		}
		return resultat;
	}

}
