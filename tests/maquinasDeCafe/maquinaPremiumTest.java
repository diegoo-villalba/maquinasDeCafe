package maquinasDeCafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class maquinaPremiumTest {
	
	MaquinaDeCafe maquina;

	@Before
	public void setup() {
		maquina = new MaquinaPremium();
	}
	
	@Test
	public void devuelveUnVasoAlServirTest() {
		VasoDeCafe vaso = maquina.servirCafe();
		assertNotNull(vaso);
	}
	
	@Test
	public void puedeServirUnCafeTest() {
		assertTrue(maquina.puedeServir());
	}
	
	@Test
	public void seAgotaElCafeTest() {
		for (int i = 0; i < 100; i++) {
			maquina.servirCafe();
		}
		
		assertFalse(maquina.puedeServir());

	}
	
	@Test
	public void sirveCafeVacioAlAgotarElCafeTest() {
		for (int i = 0; i<100; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLleno());
	}

}
