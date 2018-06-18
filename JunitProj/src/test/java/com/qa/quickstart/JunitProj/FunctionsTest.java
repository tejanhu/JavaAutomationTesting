package com.qa.quickstart.JunitProj;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FunctionsTest {
	
	Functions calc;
    @Before 
    public void initialize() {
    	calc = new Functions();
     }
    
    @AfterClass
    public static void message() {
    	System.out.println("Tests finished");
    }

	@Test
	public void testAdd() {
		assertEquals(10,calc.add(3,7));
		assertEquals(10000, calc.add(2199, 7801));
		assertEquals(0, calc.add(60000, -60000));
	}

	@Test
	public void testSubtract() {
		assertEquals(10, calc.subtract(-10, -20));
		assertEquals(-5, calc.subtract(10, 15));
	}

	@Test
	public void testMultiply() {
		assertEquals(-10, calc.multiply(-5, 2));
		assertEquals(10,calc.multiply(-2, -5));
	}

	@Test
	public void testDivide() {
		assertEquals(2.5, calc.divide(5, 2), 0.01);
		assertEquals(-4, calc.divide(8, -2), 0.02);
	}

	@Test
	public void testMod() {
		assertEquals(1, calc.mod(11,10));
		assertEquals(0, calc.mod(100, 10));
	}

	@Test
	public void testPower() {
		assertEquals(4, calc.power(2, 2));
		assertEquals(25, calc.power(-5, 2));
	}

	@Test
	public void testSwtich() {
		assertEquals(0, calc.swtich(false));
		assertEquals(1, calc.swtich(true));
	}

}
