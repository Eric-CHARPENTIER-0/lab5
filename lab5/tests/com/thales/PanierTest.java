package com.thales;

import static org.junit.Assert.*;

import org.junit.Test;

public class PanierTest {

	@Test
	public void testEqualsPanierPanier() {
		final Panier p1 = new Panier(10);
		p1.ajoute(new Orange("France", 0.80));
		p1.ajoute(new Orange("Espagne", 0.80));
		p1.ajoute(new Orange("Floride", 0.90));
		assertFalse(Panier.equals(p1,  null));
		assertFalse(Panier.equals(null,  p1));
		// TODO assertTrue(Panier.equals(p1,  p1));
		Panier p2 = new Panier(3);
		p2.ajoute(new Orange("France", 0.80));
		p2.ajoute(new Orange("Espagne", 0.80));
		p2.ajoute(new Orange("Floride", 0.90));
		assertTrue(Panier.equals(p1,  p2));
		assertTrue(Panier.equals(p2,  p1));
		p2.boycottOrigine("Floride");
		// TODO assertFalse(Panier.equals(p1,  p2));
		// TODO assertFalse(Panier.equals(p2,  p1));
		p1.boycottOrigine("Floride");
		assertTrue(Panier.equals(p1,  p2));
		assertTrue(Panier.equals(p2,  p1));
	}

}
