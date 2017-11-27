package edu.usm.cos375.model;

import java.io.Serializable;


public class Privilege implements Serializable {

	private static final long serialVersionUID = -290267212241877136L;
	
	private String uuid;
	private String privilege;
	
	public Privilege() {
		
	}
	
	public Privilege(String privilege) {
		this.privilege = privilege;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public int hashCode() {
		return privilege.hashCode();
	}
}
