package maquinasDeCafe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEstafadoraTest {
	MaquinaDeCafe maquina;
	
	@Before
	public void setup() {
		maquina = new MaquinaEstafadora();
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
	public void primerVasoLlenoYElSiguienteVacioTest() {
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());
	}
	
	@Test
	public void seAgotaElCafeTest() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		
		assertFalse(maquina.puedeServir());

	}
	
	@Test
	public void noSeAgotaElCafeTest() {
		VasoDeCafe vaso = null;
		for (int i = 0; i < 199; i++) {
			vaso = maquina.servirCafe();
		}
		
		assertFalse(vaso.estaLleno());

	}
	
	@Test
	public void sirveCafeVacioAlAgotarElCafeTest() {
		for (int i = 0; i<200; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLleno());
	}

}


