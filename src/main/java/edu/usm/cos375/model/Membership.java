package edu.usm.cos375.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membership")
public class Membership
{
	//TODO: Implement class fields, services, repository, and controller. Add validation
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	long id;
	
	Individual individual;
}
