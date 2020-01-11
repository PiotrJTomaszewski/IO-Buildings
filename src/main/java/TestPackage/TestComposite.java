package TestPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.buildings.logic.Building;
import pl.put.poznan.buildings.logic.Floor;
import pl.put.poznan.buildings.logic.Location;
import pl.put.poznan.buildings.logic.Room;

class TestComposite {

	private Building x;
	private Room a, b, c, d;
	
	@BeforeEach
	void setUp() throws Exception {
		x=new Building();
		
		a=new Room();
		b=new Room();
		c=new Room();
		d=new Room();
		
		a.setArea(20);
		b.setArea(310);
		c.setArea(12000);
		d.setArea(5);
		
		a.setCube(100);
		b.setCube(30000);
		c.setCube(350);
		d.setCube(120);
		
		a.setHeating(100.5f);
		b.setHeating(1200.55f);
		c.setHeating(0);
		d.setHeating(400);
		
		a.setLight(20);
		b.setLight(620);
		c.setLight(1);
		d.setLight(400);
		
		Floor e=new Floor();
		List<Location> z=new ArrayList<Location>();
		z.add(a);
		z.add(b);
		e.setLocations(z);
		
		List<Location> y=new ArrayList<Location>();
		y.add(e);
		y.add(c);
		y.add(d);
		
		x.setLocations(y);
		
	}
	
	@Test
	void AreaTest() {
		assertEquals(20, a.getArea(), 0.00001);
		assertEquals(310, b.getArea(), 0.00001);
		assertEquals(12000, c.getArea(), 0.000001);
		assertEquals(5, d.getArea(), 0.00001);
		assertEquals(12335, x.getArea(), 0.0001);
	}
	
	@Test
	void CubeTest() {
		assertEquals(100, a.getCube(), 0.00001);
		assertEquals(30000, b.getCube(), 0.00001);
		assertEquals(350, c.getCube(), 0.000001);
		assertEquals(120, d.getCube(), 0.00001);
		assertEquals(30570, x.getCube(), 0.0001);
	}
	
	@Test
	void HeatingTest() {
		assertEquals(100.5, a.getHeating(), 0.0001);
		assertEquals(1200.55, b.getHeating(), 0.0001);
		assertEquals(0, c.getHeating(), 0.0001);
		assertEquals(400, d.getHeating(), 0.0001);
		assertEquals(1701.05, x.getHeating(), 0.001);
	}

	@Test
	void HeatingEnergyUseTest() {
		assertEquals(1.005, a.getHeatingEnergyUse(), 0.00001);
		assertEquals(0.040018, b.getHeatingEnergyUse(), 0.00001);
		assertEquals(0, c.getHeatingEnergyUse(), 0.000001);
		assertEquals(3.33333333, d.getHeatingEnergyUse(), 0.00001);
		assertEquals(0.05, x.getHeatingEnergyUse(), 0.01);
	}
	
	@Test
	void LightTest() {
		assertEquals(20, a.getLight(), 0.00001);
		assertEquals(620, b.getLight(), 0.00001);
		assertEquals(1, c.getLight(), 0.00001);
		assertEquals(400, d.getLight(), 0.00001);
		assertEquals(1041, x.getLight(), 0.0001);
	}
	
	@Test
	void LightMeanTest() {
		assertEquals(1., a.getMeanLight(), 0.00001);
		assertEquals(2, b.getMeanLight(), 0.00001);
		assertEquals(0.0000833, c.getMeanLight(), 0.000001);
		assertEquals(80, d.getMeanLight(), 0.00001);
		assertEquals(0.0843, x.getMeanLight(), 0.0001);
	}
	
	@Test
	void EnergyTest() {
		assertEquals(2.005, a.getEnergyUse(), 0.00001);
		assertEquals(2.04001, b.getEnergyUse(), 0.00001);
		assertEquals(0.0000833, c.getEnergyUse(), 0.00001);
		assertEquals(83.333333, d.getEnergyUse(), 0.00001);
	}
	
	
	@Test
	void ThresholdEmptyTest() {
		ArrayList<Location> thrempty=new ArrayList<>();
		assertEquals(thrempty, a.thresholding_energy(2.1f));
		assertEquals(thrempty, b.thresholding_energy(2.05f));
		assertEquals(thrempty, c.thresholding_energy(0.0001f));
		assertEquals(thrempty, d.thresholding_energy(84f));
		assertEquals(thrempty, x.thresholding_energy(85));
	}
	
	@Test
	void ThresholdNonEmptyTest() {
		ArrayList<Location> thr=new ArrayList<>();
		thr.add(a);
		assertEquals(thr, a.thresholding_energy(2.0f));
		thr.remove(0);
		thr.add(b);
		assertEquals(thr, b.thresholding_energy(2.0f));
		thr.remove(0);
		thr.add(c);
		assertEquals(thr, c.thresholding_energy(0.000001f));
		thr.remove(0);
		thr.add(d);
		assertEquals(thr, d.thresholding_energy(83f));
		thr.remove(0);
		thr.add(a);
		thr.add(b);
		thr.add(d);
		assertEquals(thr, x.thresholding_energy(2));
	}

}