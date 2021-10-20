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
		if (origine != null) {
			Orange o;
		    final Iterator<Orange> iter = panier.iterator();
		    while (iter.hasNext()) {
			    o = iter.next();
			    if (origine.contentEquals(o.getOrigine())) {
				    iter.remove();
			    }
			}
		}
	}

	public static boolean equals(final Panier p1, final Panier p2) {
		boolean resultat = false;
		if ((p1 != null) && (p2 != null)) {
			final int count = p1.panier.size();
			if (count ==  p2.panier.size()) {
				// duplicate p2 content
				final ArrayList<Orange> content = new ArrayList<Orange>(p2.panier);
				Orange o2;
				Iterator<Orange> iter;
				for (Orange o1 : p1.panier) {
					iter = content.iterator();
					while (iter.hasNext()) {
						o2 = iter.next();
						if (o1.getOrigine().equals(o2.getOrigine())
								&& (o1.getPrix() == o2.getPrix())) {
							iter.remove();
							break;
						}
					}
				}
				resultat = content.isEmpty();
			}
		}
		return resultat;
	}

}
