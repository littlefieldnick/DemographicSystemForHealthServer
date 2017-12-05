package edu.usm.cos375.repository.impl;

import edu.usm.cos375.model.SocialGroup;
import edu.usm.cos375.repository.SocialGroupRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemorySocialGroupRepository implements SocialGroupRepository {
    private final Map<Integer, SocialGroup> database = new LinkedHashMap<>();
    private int id = 1;

    public InMemorySocialGroupRepository() {
        loadStaticData();
    }


    @Override

    public List<SocialGroup> getAll() {
        return new ArrayList<>(this.database.values());
    }

    @Override
    public SocialGroup get(long id) {
        return this.database.get(id);
    }

    @Override
    public boolean contains(long id) {
        if (database.containsKey(id))
            return true;

        return false;
    }

    @Override
    public void add(SocialGroup socialGroup) {
        socialGroup.setId(this.nextID());
        this.database.put(socialGroup.getId(), socialGroup);
    }

    @Override
    public void update(SocialGroup socialGroup) {
        this.database.put(socialGroup.getId(), socialGroup);
    }

    @Override
    public void delete(long id) {
        this.database.remove(id);
    }

    private int nextID() {
        return this.id++;
    }

    public void loadStaticData() {
        SocialGroup socialGroup = new SocialGroup();
        socialGroup.setId(0);
        socialGroup.setSocialGroupType("Family");
        socialGroup.setGroupMembership("Household");

        this.add(socialGroup);

        socialGroup = new SocialGroup();
        socialGroup.setId(1);
        socialGroup.setSocialGroupType("Family");
        socialGroup.setGroupMembership("Household");

        this.add(socialGroup);

    }
}
