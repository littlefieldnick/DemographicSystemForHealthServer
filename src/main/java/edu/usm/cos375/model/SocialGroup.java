package edu.usm.cos375.model;

import javax.validation.constraints.NotNull;

public class SocialGroup {
    @NotNull
    private int id;

    @NotNull
    private String socialGroupType;

    @NotNull
    private String groupMembership;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialGroupType() {
        return socialGroupType;
    }

    public void setSocialGroupType(String socialGroupType) {
        this.socialGroupType = socialGroupType;
    }

    public String getGroupMembership() {
        return groupMembership;
    }

    public void setGroupMembership(String groupMembership) {
        this.groupMembership = groupMembership;
    }
}
