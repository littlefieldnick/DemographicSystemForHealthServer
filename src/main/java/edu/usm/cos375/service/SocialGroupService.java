package edu.usm.cos375.service;


import edu.usm.cos375.model.SocialGroup;

import java.util.List;

public interface SocialGroupService {
    List<SocialGroup> getAllSocialGroups();

    SocialGroup getSocialGroup(long id);

    void add(SocialGroup socialGroup);

    void update(SocialGroup socialGroup);

    void remove(long id);
    
    SocialGroup findByExtId(String extId);
}
