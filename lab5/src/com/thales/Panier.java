package com.thales;

import java.util.ArrayList;
import java.util.Iterator;

public class Panier {

	final int taille; 
	final ArrayList <Orange> contenu;
	
	public Panier(final int uneTaille) {
		taille = uneTaille;
		contenu = new ArrayList<>(taille);
	}
	
	public int getContenu() {
		return contenu.size();
	}

	public int taillePanier() {
		return contenu.size();
	}

	public boolean estPlein() {
		return (contenu.size() == taille);
	}

	public boolean estVide() {
		return contenu.isEmpty();
	}

	public String toString() {
		final StringBuilder buf = new StringBuilder();
		for (Orange i : contenu) {
			buf.append(i.getOrigine())
			.append(" | ")
			.append(i.getPrix())
			.append('\n');
		}
		return buf.toString();
	}

	public void ajoute(final Orange o) {
		if (contenu.size() < taille) {
			contenu.add(o);
		} else {
			throw new RuntimeException("Le panier est plein");
		}
	}

	public void retire() {
		contenu.remove(contenu.size() - 1);
	}

	public double getPrix() {
		double resultat = 0;
		for (Orange i : contenu) {
			resultat += i.getPrix();
		} 
		return resultat;
	}

	public void boycottOrigine(final String origine) {
		if (origine != null) {
			Orange o;
		    final Iterator<Orange> iter = contenu.iterator();
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
			final int count = p1.contenu.size();
			if (count ==  p2.contenu.size()) {
				// duplicate p2 content
				final ArrayList<Orange> content = new ArrayList<>(p2.contenu);
				Orange o2;
				Iterator<Orange> iter;
				for (Orange o1 : p1.contenu) {
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
