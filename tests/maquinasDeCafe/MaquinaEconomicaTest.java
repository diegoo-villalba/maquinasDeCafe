package maquinasDeCafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEconomicaTest {

	MaquinaDeCafe maquina;

	@Before
	public void setup() {
		maquina = new MaquinaEconomia();
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
	public void queNoRestaAntesDelTerceroTest() {
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000, maquina.getGramosDeCafe());
	}
	
	@Test
	public void queRestaCafeDespuesDelTerceroTest() {
		maquina.servirCafe();
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000 - 10, maquina.getGramosDeCafe());
	}
	
	@Test
	public void seAgotaElCafeTest() {
		for (int i = 0; i < 299; i++) {
			maquina.servirCafe();
		}
		
		assertFalse(maquina.puedeServir());

	}
	
	@Test
	public void queNoSeAgotaElCafeTest() {
		for (int i = 0; i < 300; i++) {
			maquina.servirCafe();
		}
		
		assertFalse(maquina.puedeServir());

	}
	
	@Test
	public void sirveCafeVacioAlAgotarElCafeTest() {
		for (int i = 0; i<300; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLleno());
	}

}
