package edu.usm.cos375.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class LocationHierarchyLevel implements Serializable
{
    private static final long serialVersionUID = -1070569257732332545L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    long uuid;

    @NotNull
    String name;
    
    Integer keyIdentifier;

    public long getUuid()
    {
        return uuid;
    }


    public void setUuid(long uuid)
    {
        this.uuid = uuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getKeyIdentifier()
    {
        return keyIdentifier;
    }

    public void setKeyIdentifier(Integer keyIdentifier)
    {
        this.keyIdentifier = keyIdentifier;
    }
}