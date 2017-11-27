package edu.usm.cos375.controller;
import edu.usm.cos375.model.*;
import edu.usm.cos375.service.FieldworkerService;

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

import java.util.List;

@RestController
@RequestMapping("/fieldworkers")
public class FieldworkerController {
	
	@Autowired 
	FieldworkerService fieldworkerService;

	//Get all the current individuals
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Fieldworker>> getAll(){
		List<Fieldworker> fieldworkers = fieldworkerService.getAllFieldworkers();
		if(fieldworkers == null || fieldworkers.isEmpty()) {
			return new ResponseEntity<List<Fieldworker>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Fieldworker>>(fieldworkers, HttpStatus.OK);
	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Fieldworker> get(@PathVariable("id") long id){
		Fieldworker fieldworker = fieldworkerService.getFieldworker(id);

		if (fieldworker == null){
			return new ResponseEntity<Fieldworker>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Fieldworker>(fieldworker, HttpStatus.OK);
	}

	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Fieldworker fieldworker, UriComponentsBuilder ucBuilder){
		if(fieldworkerService.getFieldworker(fieldworker.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		fieldworkerService.add(fieldworker);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("rest/fieldworker/{id}").buildAndExpand(fieldworker.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Fieldworker> update(@PathVariable int id, @RequestBody Fieldworker fieldworker){
		Fieldworker updateFieldworker = fieldworkerService.getFieldworker(id);

		if(updateFieldworker == null) {
			return new ResponseEntity<Fieldworker>(HttpStatus.NOT_FOUND);
		}


		fieldworkerService.update(fieldworker);
		updateFieldworker = fieldworkerService.getFieldworker((long) id);

		return new ResponseEntity<Fieldworker>(updateFieldworker, HttpStatus.OK);
	}


	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		Fieldworker fieldworker = fieldworkerService.getFieldworker(id);
		if (fieldworker == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		fieldworkerService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
