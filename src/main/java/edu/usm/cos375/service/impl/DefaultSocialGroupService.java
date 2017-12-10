package edu.usm.cos375.service.impl;

import edu.usm.cos375.model.Fieldworker;
import edu.usm.cos375.model.SocialGroup;
import edu.usm.cos375.repository.SocialGroupRepository;
import edu.usm.cos375.service.SocialGroupService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSocialGroupService implements SocialGroupService{
    @Inject
    SocialGroupRepository socialGroupRepository;

    @Override
    public List<SocialGroup> getAllSocialGroups() {
    		Iterable<SocialGroup> allSocialGroups = this.socialGroupRepository.findAll();
		List<SocialGroup> all = new ArrayList<SocialGroup>();
		allSocialGroups.forEach(all::add);
		all.sort((g1, g2) -> g1.getExtId().compareTo(g2.getExtId()));
        return all;
    }

    @Override
    public SocialGroup getSocialGroup(long id) {
        SocialGroup socialGroup = this.socialGroupRepository.findOne(id);
        return socialGroup;
    }

    @Override
    public void add(SocialGroup socialGroup) {
        if(socialGroupRepository.exists((long) socialGroup.getId())) {
            socialGroupRepository.save(socialGroup);
        } else {
            socialGroupRepository.save(socialGroup);
        }
    }

    @Override
    public void update(SocialGroup socialGroup) {
        if(socialGroupRepository.findOne((long) socialGroup.getId()) != null) {
            this.socialGroupRepository.save(socialGroup);
        }
    }

    @Override
    public void remove(long id) {
        this.socialGroupRepository.delete(id);
    }
    
    public SocialGroup findByExtId(String extId) {
    		return this.socialGroupRepository.findByExtId(extId);
    }
}
