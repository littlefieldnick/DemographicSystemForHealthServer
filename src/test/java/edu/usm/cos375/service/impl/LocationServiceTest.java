package edu.usm.cos375.service.impl;

import edu.usm.cos375.model.Location;
import edu.usm.cos375.repository.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import edu.usm.cos375.repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class LocationServiceTest {
    @Test
    public void getAllLocationsTest() {
        DefaultLocationService locationService = new DefaultLocationService();
        LocationRepository locationRepository = mock(LocationRepository.class);
        locationService.repository =  locationRepository;//new InMemoryLocationRepositoryMock();
        locationService.create(new Location());
        Location n = new Location();
        n.setLocationName("Hello World");

        when(locationRepository.getAllLocations()).thenReturn(new ArrayList<Location>(Arrays.asList(
                n
        )));

        assertEquals("Hello World", locationService.getAllLocations().get(0).getLocationName());
    }
}

