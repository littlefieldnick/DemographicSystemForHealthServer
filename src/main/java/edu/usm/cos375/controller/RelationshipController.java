package edu.usm.cos375.controller;
import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.service.RelationshipService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {

	@Autowired
	RelationshipService relationshipService;

	//Get all the current relationships
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Relationship>> getAll(){
		List<Relationship> individuals = relationshipService.readAll();
		if(individuals == null || individuals.isEmpty()) {
			return new ResponseEntity<List<Relationship>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Relationship>>(individuals, HttpStatus.OK);
	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Relationship> get(@PathVariable("id") long id){
		Relationship r = relationshipService.read(id);

		if (r == null){
			return new ResponseEntity<Relationship>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Relationship>(r, HttpStatus.OK);
	}

	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Relationship r, UriComponentsBuilder ucBuilder){
		if(relationshipService.read(r.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		relationshipService.create(r);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/individuals/{id}").buildAndExpand(r.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Relationship> update(@PathVariable int id, @RequestBody Relationship r){
		Relationship updateRelationship = relationshipService.read(id);

		if(updateRelationship == null) {
			return new ResponseEntity<Relationship>(HttpStatus.NOT_FOUND);
		}


		relationshipService.update(id, r);
		updateRelationship = relationshipService.read((long) id);

		return new ResponseEntity<Relationship>(updateRelationship, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		Relationship r = relationshipService.read(id);
		if (r == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		relationshipService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
