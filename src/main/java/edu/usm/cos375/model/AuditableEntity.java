package edu.usm.cos375.model;

import java.io.Serializable;
import java.util.Calendar;

public class AuditableEntity implements UuidIdentifiable, Serializable{
	private static final long serialVersionUID = -4703049354466276068L;
	
	String uuid;
	protected boolean deleted = false;
	protected User insertBy;
	protected Calendar insertDate;  
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public User getInsertBy() {
		return insertBy;
	}

	public void setInsertBy(User insertBy) {
		this.insertBy = insertBy;
	}

	public Calendar getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Calendar insertDate) {
		this.insertDate = insertDate;
	}
	
	@Override
	public String getUuid() {
		return this.uuid;
	}

	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
		
	}
	
	public int hashCode() {
		if(this.uuid == null) {
			return 0;
		}
		
		return this.uuid.hashCode();
	}

}
