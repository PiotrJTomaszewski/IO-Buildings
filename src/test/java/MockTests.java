import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import pl.put.poznan.buildings.logic.Building;
import pl.put.poznan.buildings.logic.Floor;
import pl.put.poznan.buildings.logic.Location;
import pl.put.poznan.buildings.logic.LocationVisitor;
import pl.put.poznan.buildings.logic.Room;
import pl.put.poznan.buildings.rest.BuildingsController;
import pl.put.poznan.buildings.rest.LocationNotFoundException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
class MockTests {
	
	private <T> Map<String, T> toKeyValue(String key, T value) {
        Map<String, T> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
	
	@Test
	void PostLocationNoErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		BuildingsController bc=new BuildingsController();
		bc.postLocation(13, k);
		assertDoesNotThrow(()->{
			bc.postLocation(13, k);
		});
	}
	
	@Test
	void PostLocationErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 17);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		BuildingsController bc=new BuildingsController();
		assertThrows(StackOverflowError.class, ()->{
			bc.postLocation(14, k);
		});
	}
	
	@Test
	void PostLocationHeatingTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		//doCallRealMethod().when(k).getHeatingEnergyUse();
		
		BuildingsController bc=new BuildingsController();
		assertDoesNotThrow(()->{
			Map<String, Float> m=bc.postLocationHeating(13, k);
			assertEquals(m, toKeyValue("heating", 0.0f));
		});
	}
	
	@Test
	void PostLocationHeatingErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		doCallRealMethod().when(k).getHeatingEnergyUse();
		
		BuildingsController bc=new BuildingsController();
		assertThrows(AssertionFailedError.class, ()->{
			Map<String, Float> m=bc.postLocationHeating(13, k);
			assertEquals(m, toKeyValue("heating", 0.0f));
		});
	}
	
	@Test
	void PostLocationLightTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		//doCallRealMethod().when(k).getHeatingEnergyUse();
		
		BuildingsController bc=new BuildingsController();
		assertDoesNotThrow(()->{
			Map<String, Float> m=bc.postLocationLight(13, k);
			assertEquals(m, toKeyValue("light", 0.0f));
		});
	}
	
	@Test
	void PostLocationLightErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		doCallRealMethod().when(k).getMeanLight();
		
		BuildingsController bc=new BuildingsController();
		assertThrows(AssertionFailedError.class, ()->{
			Map<String, Float> m=bc.postLocationLight(13, k);
			assertEquals(m, toKeyValue("light", 0.0f));
		});
	}
	
	@Test
	void PostLocationAreaTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		//doCallRealMethod().when(k).getHeatingEnergyUse();
		
		BuildingsController bc=new BuildingsController();
		assertDoesNotThrow(()->{
			Map<String, Integer> m=bc.postLocationArea(13, k);
			assertEquals(m, toKeyValue("area", 0));
		});
	}
	
	@Test
	void PostLocationAreaErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		doCallRealMethod().when(k).getArea();
		
		BuildingsController bc=new BuildingsController();
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationArea(13, k);
			assertEquals(m, toKeyValue("area", 0));
		});
	}
	
	@Test
	void PostLocationCubeTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		//doCallRealMethod().when(k).getHeatingEnergyUse();
		
		BuildingsController bc=new BuildingsController();
		assertDoesNotThrow(()->{
			Map<String, Integer> m=bc.postLocationCube(13, k);
			assertEquals(m, toKeyValue("cube", 0));
		});
	}
	
	@Test
	void PostLocationCubeErrorTest() {
		Building k=mock(Building.class);
		when(k.getId()).thenReturn((long) 13);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		doCallRealMethod().when(k).getCube();
		
		BuildingsController bc=new BuildingsController();
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationCube(13, k);
			assertEquals(m, toKeyValue("cube", 0));
		});
	}
	
}
