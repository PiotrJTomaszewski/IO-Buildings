import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.buildings.logic.Building;
import pl.put.poznan.buildings.logic.Floor;
import pl.put.poznan.buildings.logic.Location;
import pl.put.poznan.buildings.logic.LocationVisitor;
import pl.put.poznan.buildings.logic.Room;
import pl.put.poznan.buildings.rest.BuildingsController;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
class MockTests {
	
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
	void BuildingTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		
		BuildingsController bc=new BuildingsController();
		bc.postLocation(13, k);
	}
}
