package edu.usm.cos375.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.usm.cos375.model.Location;
import edu.usm.cos375.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController
{
	@Autowired
	LocationService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getAllLocations()
	{
		List<Location> locations = service.getAllLocations();

		if(locations == null || locations.isEmpty())
			return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Location> create(@RequestBody Location location, UriComponentsBuilder ucBuilder)
	{
		
		if (service.getByExtId(location.getExtId()) != null)
			return new ResponseEntity<Location>(location, HttpStatus.CONFLICT);

		service.create(location);
		Location loc = service.getByExtId(location.getExtId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(location.getUuid()).toUri());
		
		return new ResponseEntity<Location>(loc, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Location> read(@PathVariable("id") Long id)
	{
		Location location = service.read(id);

		if (location == null)
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location)
	{
		Location currentLocation = service.read(id);

		if (currentLocation == null)
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);

		currentLocation.setUuid(location.getUuid());
		currentLocation.setLocationName(location.getLocationName());

		service.update(location);
		
		return new ResponseEntity<Location>(currentLocation, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id)
	{
        Location location = service.read(id);

        if (location == null)
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        service.delete(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
