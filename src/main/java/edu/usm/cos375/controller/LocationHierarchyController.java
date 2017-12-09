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

import edu.usm.cos375.model.LocationHierarchy;
import edu.usm.cos375.service.LocationHierarchyService;

@RestController
@RequestMapping("/hierarchies")
public class LocationHierarchyController
{
	@Autowired
	LocationHierarchyService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LocationHierarchy>> getAllHierarchies()
	{
		List<LocationHierarchy> hierarchies = service.getAllHierarchies();

		if(hierarchies == null || hierarchies.isEmpty())
			return new ResponseEntity<List<LocationHierarchy>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<LocationHierarchy>>(hierarchies, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody LocationHierarchy hierarchy, UriComponentsBuilder ucBuilder)
	{
		if (service.read(hierarchy.getUuid()) != null)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		service.create(hierarchy);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(hierarchy.getUuid()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocationHierarchy> read(@PathVariable("id") Long id)
	{
		LocationHierarchy hierarchy = service.read(id);

		if (hierarchy == null)
			return new ResponseEntity<LocationHierarchy>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<LocationHierarchy>(hierarchy, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<LocationHierarchy> update(@PathVariable Long id, @RequestBody LocationHierarchy hierarchy)
	{
		LocationHierarchy currentLocation = service.read(id);

		if (currentLocation == null)
			return new ResponseEntity<LocationHierarchy>(HttpStatus.NOT_FOUND);

		currentLocation.setUuid(hierarchy.getUuid());
		currentLocation.setName(hierarchy.getName());

		service.update(hierarchy);
		
		return new ResponseEntity<LocationHierarchy>(currentLocation, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id)
	{
		LocationHierarchy hierarchy = service.read(id);

        if (hierarchy == null)
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        service.delete(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
