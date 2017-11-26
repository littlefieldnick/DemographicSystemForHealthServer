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

import edu.usm.cos375.model.Residency;
import edu.usm.cos375.service.ResidencyService;

@RestController
@RequestMapping("/residencies")
public class ResidencyController
{
	@Autowired
	ResidencyService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Residency>> getAllResidencies()
	{
		List<Residency> residencies = service.getAllResidencies();

		if(residencies == null || residencies.isEmpty())
			return new ResponseEntity<List<Residency>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Residency>>(residencies, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Residency residency, UriComponentsBuilder ucBuilder)
	{
		if (service.read(residency.getUuid()) != null)
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		service.create(residency);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(residency.getUuid()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Residency> read(@PathVariable("id") Long id)
	{
		Residency residency = service.read(id);

		if (residency == null)
			return new ResponseEntity<Residency>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Residency>(residency, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Residency> update(@PathVariable Long id, @RequestBody Residency residency)
	{
		Residency currentResidency = service.read(id);

		if (currentResidency == null)
			return new ResponseEntity<Residency>(HttpStatus.NOT_FOUND);

		service.update(residency);
		
		return new ResponseEntity<Residency>(currentResidency, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id)
	{
		Residency residency = service.read(id);

        if (residency == null)
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        service.delete(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
