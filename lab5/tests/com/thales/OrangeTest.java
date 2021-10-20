package com.thales;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrangeTest {

	@Test
	public void testEqualsOrangeOrange() {
		final Orange o1 = new Orange("France", 1.0);
		assertFalse(Orange.equals(o1,  null));
		assertFalse(Orange.equals(null,  o1));
		assertTrue(Orange.equals(o1,  o1));
		
		Orange o2 = new Orange("Espagne", 0.8);
		assertTrue(Orange.equals(o2,  o2));
		assertFalse(Orange.equals(o1,  o2));
		assertFalse(Orange.equals(o2,  o1));
		o2 = new Orange("France", 0.8);
		assertFalse(Orange.equals(o1,  o2));
		assertFalse(Orange.equals(o2,  o1));
		o2 = new Orange("Espagne", 1.0);
		assertFalse(Orange.equals(o1,  o2));
		assertFalse(Orange.equals(o2,  o1));
		o2 = new Orange("France", 1.0);
		assertTrue(Orange.equals(o1,  o2));
		assertTrue(Orange.equals(o2,  o1));
	}

}
