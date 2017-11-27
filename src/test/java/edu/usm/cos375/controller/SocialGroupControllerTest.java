package edu.usm.cos375.controller;

import edu.usm.cos375.model.Location;
import edu.usm.cos375.model.SocialGroup;
import edu.usm.cos375.service.SocialGroupService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class SocialGroupControllerTest {

    @Test
    public void getAllWhenSocialGroupExistsTest() {
        SocialGroupController socialGroupController = new SocialGroupController();
        SocialGroupService socialGroupService = mock(SocialGroupService.class);
        socialGroupController.socialGroupService = socialGroupService;
        SocialGroup socialGroup = new SocialGroup();
        socialGroup.setId(0);
        socialGroup.setSocialGroupType("Family");
        //mock method call to getAllSocialGroups
        when(socialGroupService.getAllSocialGroups()).thenReturn(new ArrayList<SocialGroup>(Arrays.asList(
                socialGroup
        )));

        List socialGroupList = Arrays.asList(socialGroup);

        ResponseEntity<List<SocialGroup>> listResponseEntity = new ResponseEntity<List<SocialGroup>>(socialGroupList, HttpStatus.OK);

        assertEquals(listResponseEntity,socialGroupController.getAll());
    }

    @Test
    public void getAllReturnNoContentWhenResponseDoesNotExistTest() {
        SocialGroupController socialGroupController = new SocialGroupController();
        SocialGroupService socialGroupService = mock(SocialGroupService.class);
        socialGroupController.socialGroupService = socialGroupService;

        //mock method call to getAllSocialGroups
        when(socialGroupService.getAllSocialGroups()).thenReturn(new ArrayList<SocialGroup>(Arrays.asList(

        )));


        ResponseEntity<List<SocialGroup>> listResponseEntity = new ResponseEntity<List<SocialGroup>>(HttpStatus.NO_CONTENT);

        assertEquals(listResponseEntity,socialGroupController.getAll());
    }

    @Test
    public void createSocialGroupReturnConflictIfExistsTest() {
        SocialGroupController socialGroupController = new SocialGroupController();
        SocialGroupService socialGroupService = mock(SocialGroupService.class);
        socialGroupController.socialGroupService = socialGroupService;
        SocialGroup socialGroup = new SocialGroup();
        socialGroup.setId(0);
        socialGroup.setSocialGroupType("Family");
        //mock method call to getAllSocialGroups
        when(socialGroupService.getSocialGroup(1)).thenReturn(socialGroup);


        ResponseEntity<Void> responseEntity = new ResponseEntity<Void>(HttpStatus.CONFLICT);

        assertEquals(responseEntity,socialGroupController.create(socialGroup, null));
    }
}
