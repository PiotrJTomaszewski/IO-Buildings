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
	
	private Building k, l;
	private BuildingsController bc;
	
	@BeforeEach
	public void setUp() throws Exception {
		k=mock(Building.class);
		doCallRealMethod().when(k).accept(any());
		bc=new BuildingsController();
	}
	
	/**
	 * Correct add of a building
	 */
	@Test
	void PostLocationNoError1Test() {
		when(k.getId()).thenReturn((long) 13);
		assertDoesNotThrow(()->{
			bc.postLocation(13, k);
		});
	}
	
	/**
	 * Building contains correct Id in it's children
	 */
	@Test
	void PostLocationNoError2Test() {
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		Room x1=mock(Room.class), x2=mock(Room.class);
		when(x1.getId()).thenReturn((long) 12);
		when(x2.getId()).thenReturn((long) 13);
		List<Location> z=new ArrayList<Location>();
		
		doCallRealMethod().when(x1).accept(any());
		doCallRealMethod().when(x2).accept(any());
		
		z.add(x1);
		z.add(x2);
		when(k.getLocations()).thenReturn(z);
		when(k.getId()).thenReturn((long) 14);
		
		assertDoesNotThrow(()->{
			bc.postLocation(12, k);
			bc.postLocation(13, k);
			bc.postLocation(14, k);
		});
	}
	
	/**
	 * Building does not contain correct id
	 */
	@Test
	void PostLocationErrorTest() {
		when(k.getId()).thenReturn((long) 102);
		
		assertThrows(LocationNotFoundException.class, ()->{
			bc.postLocation(14, k);
		});
	}
	
	
	/**
	 * Heating returns default - whatever mock says it should return
	 */
	@Test
	void PostLocationHeatingTest() {
		when(k.getId()).thenReturn((long) 13);
		when(k.getHeatingEnergyUse()).thenReturn(10.23f);
		Map<String, Float> m=bc.postLocationHeating(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("heating", 10.23f));
		});
	}
	
	/**
	 * Heating goes deeper to the not-initialized value - NaN
	 */
	@Test
	void PostLocationHeatingErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getHeatingEnergyUse();
		Map<String, Float> m=bc.postLocationHeating(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("heating", Float.NaN));
		});
	}
	
	/**
	 * Light returns default - whatever mock says it should return
	 */
	@Test
	void PostLocationLightTest() {
		when(k.getId()).thenReturn((long) 13);
		when(k.getMeanLight()).thenReturn(72.82f);
		Map<String, Float> m=bc.postLocationLight(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("light", 72.82f));
		});
	}
	
	/**
	 * Light goes deeper to the not-initialized value - NaN
	 */
	@Test
	void PostLocationLightErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getMeanLight();
		Map<String, Float> m=bc.postLocationLight(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("light", Float.NaN));
		});
	}
	
	/**
	 * Area returns default - whatever mock says it should return
	 */
	@Test
	void PostLocationAreaTest() {
		when(k.getId()).thenReturn((long) 13);
		when(k.getArea()).thenReturn(733);
		Map<String, Integer> m=bc.postLocationArea(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("area", 733));
		});
	}
	
	/**
	 * Area goes deeper to the not-initialized value - NullPointerException (This is Integer)
	 */
	@Test
	void PostLocationAreaErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getArea();
		
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationArea(13, k);
		});
	}
	
	/**
	 * Cube returns default - whatever mock says it should return
	 */
	@Test
	void PostLocationCubeTest() {
		when(k.getId()).thenReturn((long) 13);
		when(k.getCube()).thenReturn(1);
		Map<String, Integer> m=bc.postLocationCube(13, k);
		
		assertDoesNotThrow(()->{
			assertEquals(m, toKeyValue("cube", 1));
		});
	}
	
	/**
	 * Cube goes deeper to the not-initialized value - NullPointerException (This is Integer)
	 */
	@Test
	void PostLocationCubeErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getCube();
		
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationCube(13, k);
		});
	}
	
}
