package edu.usm.cos375.repository;

import edu.usm.cos375.model.SocialGroup;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SocialGroupRepository extends CrudRepository<SocialGroup, Long>{
//    List<SocialGroup> getAll();
//    SocialGroup get(long id);
//    boolean contains(long id);
//    void add(SocialGroup socialGroup);
//    void update(SocialGroup socialGroup);
//    void delete(long id);
//    SocialGroup findByExtId(String extId);
	
	SocialGroup findByExtId(String extId);
}
