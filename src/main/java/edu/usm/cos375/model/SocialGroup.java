package edu.usm.cos375.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.usm.cos375.model.constraint.CheckFieldNotBlank;

@Entity
@Table(name="socialGroup")
public class SocialGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;

	@NotNull
	private String extId; 
	
    @NotNull
    @CheckFieldNotBlank
    private String socialGroupType;

    @NotNull
    @CheckFieldNotBlank
    private String groupMembership;
    
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}
}
