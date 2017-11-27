package edu.usm.cos375.model;

import java.io.Serializable;

public class AuditableCollectedEntity extends AuditableEntity implements Serializable  {

	private static final long serialVersionUID = -5381087913546922667L;

	protected String status;
	protected Fieldworker collectedBy;
	protected String statusMessage;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Fieldworker getCollectedBy() {
		return collectedBy;
	}
	
	public void setCollectedBy(Fieldworker collectedBy) {
		this.collectedBy = collectedBy;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	
}
