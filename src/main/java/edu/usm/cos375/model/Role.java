package edu.usm.cos375.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role extends AuditableEntity implements Serializable{

	private static final long serialVersionUID = -4654295158636668488L;
	
	String name; 
	String description;
	Set<Privilege> privileges = new HashSet<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37*hash + (this.uuid != null ? this.uuid.hashCode(): 0);
		return hash;
	}
	
}
