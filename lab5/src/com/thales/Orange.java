package com.thales;

public class Orange {

	private double prix;
	private String origine;

	public Orange(final String aOrigine, final double aPrix) {
		prix = aPrix;
		origine = aOrigine;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(final double aPrix) {
		if (prix < 0) {
			throw new RuntimeException("Le prix ne peut pas etre negatif");
		} else {
			prix = aPrix;
		}
	}

	public String getOrigine() {
		return origine;
	}
	public void setOrigine(final String origine) {
		this.origine = origine;
	}

	@Override
	public String toString() {
		return getOrigine() + " | "+getPrix() + '\n';
	}

	public static boolean equals(final Orange o1, final Orange o2) {
		boolean resultat = false;
		if ((o1 != null) && (o2 != null)
		    && o1.getOrigine().equals(o2.getOrigine())
		    && (o1.getPrix() == o2.getPrix())) {
			resultat = true;
		}
		return resultat;
	}

}
