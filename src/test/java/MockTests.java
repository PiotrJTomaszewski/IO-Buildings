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
	
	private Building k;
	private BuildingsController bc;
	
	@BeforeEach
	public void setUp() throws Exception {
		k=mock(Building.class);
		List<Location> c=new ArrayList<Location>();
		c.add(k);
		when(k.getLocations()).thenReturn(c);
		doCallRealMethod().when(k).accept(any());
		bc=new BuildingsController();
	}
	
	/**
	 * Correct add of a building
	 */
	@Test
	void PostLocationNoErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		bc.postLocation(13, k);
		assertDoesNotThrow(()->{
			bc.postLocation(13, k);
		});
	}
	
	/**
	 * Id of a building and id as passed argument differs
	 */
	@Test
	void PostLocationErrorTest() {
		when(k.getId()).thenReturn((long) 17);
		assertThrows(StackOverflowError.class, ()->{
			bc.postLocation(14, k);
		});
	}
	
	@Test
	void PostLocationHeatingTest() {
		when(k.getId()).thenReturn((long) 13);
		
		assertDoesNotThrow(()->{
			Map<String, Float> m=bc.postLocationHeating(13, k);
			assertEquals(m, toKeyValue("heating", 0.0f));
		});
	}
	
	@Test
	void PostLocationHeatingErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getHeatingEnergyUse();
		
		assertThrows(AssertionFailedError.class, ()->{
			Map<String, Float> m=bc.postLocationHeating(13, k);
			assertEquals(m, toKeyValue("heating", 0.0f));
		});
	}
	
	@Test
	void PostLocationLightTest() {
		when(k.getId()).thenReturn((long) 13);
		
		assertDoesNotThrow(()->{
			Map<String, Float> m=bc.postLocationLight(13, k);
			assertEquals(m, toKeyValue("light", 0.0f));
		});
	}
	
	@Test
	void PostLocationLightErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getMeanLight();
		
		assertThrows(AssertionFailedError.class, ()->{
			Map<String, Float> m=bc.postLocationLight(13, k);
			assertEquals(m, toKeyValue("light", 0.0f));
		});
	}
	
	@Test
	void PostLocationAreaTest() {
		when(k.getId()).thenReturn((long) 13);
		assertDoesNotThrow(()->{
			Map<String, Integer> m=bc.postLocationArea(13, k);
			assertEquals(m, toKeyValue("area", 0));
		});
	}
	
	@Test
	void PostLocationAreaErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getArea();
		
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationArea(13, k);
			assertEquals(m, toKeyValue("area", 0));
		});
	}
	
	@Test
	void PostLocationCubeTest() {
		when(k.getId()).thenReturn((long) 13);
		assertDoesNotThrow(()->{
			Map<String, Integer> m=bc.postLocationCube(13, k);
			assertEquals(m, toKeyValue("cube", 0));
		});
	}
	
	@Test
	void PostLocationCubeErrorTest() {
		when(k.getId()).thenReturn((long) 13);
		doCallRealMethod().when(k).getCube();
		
		assertThrows(NullPointerException.class, ()->{
			Map<String, Integer> m=bc.postLocationCube(13, k);
			assertEquals(m, toKeyValue("cube", 0));
		});
	}
	
}
