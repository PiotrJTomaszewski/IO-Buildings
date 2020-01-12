package TestPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.buildings.logic.Building;
import pl.put.poznan.buildings.logic.Location;
import pl.put.poznan.buildings.logic.Room;

class CompositeBuildTime {
	private Building x;
	private Room a;
	private int thr=40;
	long start;
	
	@BeforeEach
	void setUp() throws Exception {
		x=new Building();
		List<Location> y=new ArrayList<Location>();
		for (int i=0;i<5000000;i++) {
			a=new Room();
			a.setArea(20);
			a.setCube(100);
			a.setHeating(100.5f);
			a.setLight(20);
			y.add(a);
		}
		
		x.setLocations(y);
		start = System.currentTimeMillis();
	}

	@Test
	void TimeAreaTest() {
		x.getArea();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-thr, 0), 0);
	}
	
	@Test
	void TimeCubeTest() {
		x.getCube();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-thr, 0), 0);
	}
	
	@Test
	void TimeLightTest() {
		x.getLight();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-thr, 0), 0);
	}
	
	@Test
	void TimeHeatingTest() {
		x.getHeating();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-thr, 0), 0);
	}
	
	@Test
	void TimeHeatingEnergyTest() {
		x.getHeatingEnergyUse();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-2*thr, 0), 0);
	}
	
	@Test
	void TimeMeanLightTest() {
		x.getMeanLight();
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-2*thr, 0), 0);
	}
	
	@Test
	void TimeThresholdNonEmptyTest() {
		x.thresholding_energy(2);
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-12*thr, 0), 0);
	}
	
	@Test
	void TimeThresholdEmptyTest() {
		x.thresholding_energy(3);
		long end= System.currentTimeMillis()-start;
		assertEquals(Math.max(end-5*thr, 0), 0);
	}
	

}