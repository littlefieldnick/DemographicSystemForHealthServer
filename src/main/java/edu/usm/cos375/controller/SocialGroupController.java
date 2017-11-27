
package edu.usm.cos375.controller;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.model.SocialGroup;
import edu.usm.cos375.service.SocialGroupService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;


@RestController
@RequestMapping("/social")
public class SocialGroupController {

    @Inject
    SocialGroupService socialGroupService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SocialGroup>> getAll() {
        List<SocialGroup> individuals = socialGroupService.getAllSocialGroups();
        if(individuals == null || individuals.isEmpty()) {
            return new ResponseEntity<List<SocialGroup>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<SocialGroup>>(individuals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody SocialGroup socialGroup, UriComponentsBuilder ucBuilder) {
        if(socialGroupService.getSocialGroup(socialGroup.getId()) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        socialGroupService.add(socialGroup);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/socialGroup/{id}").buildAndExpand(socialGroup.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SocialGroup> get(@PathVariable("id") Long id) {
        SocialGroup socialGroup = socialGroupService.getSocialGroup(id);

        if (socialGroup == null){
            return new ResponseEntity<SocialGroup>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<SocialGroup>(socialGroup, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SocialGroup> update(@PathVariable Long id, @RequestBody SocialGroup socialGroup) {
        SocialGroup socialGroupUpdate = socialGroupService.getSocialGroup(id);

        if(socialGroupUpdate == null) {
            return new ResponseEntity<SocialGroup>(HttpStatus.NOT_FOUND);
        }


        socialGroupService.update(socialGroup);
        socialGroupUpdate = socialGroupService.getSocialGroup((long) id);

        return new ResponseEntity<SocialGroup>(socialGroupUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        SocialGroup socialGroup = socialGroupService.getSocialGroup(id);
        if (socialGroup == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        socialGroupService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
