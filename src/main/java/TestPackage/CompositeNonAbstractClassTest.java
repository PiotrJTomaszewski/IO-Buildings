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

class CompositeNonAbstractClassTest {

	private Building x;
	private Room a, b, c, d;
	private Floor e;
	
	@BeforeEach
	public void setUp() throws Exception {
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
		
		e=new Floor();
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
	public void GetIdTest() {
		e.setId(12);
		x.setId(13);
		assertEquals(12, e.getId());
		assertEquals(13, x.getId());
	}
	
	@Test
	void GetNameTest() {
		e.setName("Jonasz");
		x.setName("Elizeusz");
		assertEquals("Jonasz", e.getName());
		assertEquals("Elizeusz", x.getName());
	}
	
	@Test
	void GetStringTest() {
		e.setName("Jonasz");
		x.setName("Elizeusz");
		e.setId(12);
		x.setId(13);
		
		assertEquals("Building id:12 name:Jonasz", e.toString());
		assertEquals("Building id:13 name:Elizeusz", x.toString());
	}
	
	

}
