package edu.usm.cos375.repository;

import edu.usm.cos375.model.SocialGroup;

import java.util.List;

public interface SocialGroupRepository {
    List<SocialGroup> getAll();
    SocialGroup get(long id);
    boolean contains(long id);
    void add(SocialGroup socialGroup);
    void update(SocialGroup socialGroup);
    void delete(long id);
}
