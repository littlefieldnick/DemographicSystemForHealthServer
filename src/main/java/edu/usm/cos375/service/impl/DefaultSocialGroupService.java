package edu.usm.cos375.service.impl;

import edu.usm.cos375.model.SocialGroup;
import edu.usm.cos375.repository.SocialGroupRepository;
import edu.usm.cos375.service.SocialGroupService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DefaultSocialGroupService implements SocialGroupService{
    @Inject
    SocialGroupRepository socialGroupRepository;

    @Override
    public List<SocialGroup> getAllSocialGroups() {
        List<SocialGroup> allSocialGroups = this.socialGroupRepository.getAll();
        return allSocialGroups;
    }

    @Override
    public SocialGroup getSocialGroup(long id) {
        SocialGroup socialGroup = this.socialGroupRepository.get(id);
        return socialGroup;
    }

    @Override
    public void add(SocialGroup socialGroup) {
        if(socialGroupRepository.contains(socialGroup.getId())) {
            socialGroupRepository.update(socialGroup);
        } else {
            socialGroupRepository.add(socialGroup);
        }
    }

    @Override
    public void update(SocialGroup socialGroup) {
        if(socialGroupRepository.get(socialGroup.getId()) != null) {
            this.socialGroupRepository.update(socialGroup);
        }
    }

    @Override
    public void remove(long id) {
        this.socialGroupRepository.delete(id);
    }
}
