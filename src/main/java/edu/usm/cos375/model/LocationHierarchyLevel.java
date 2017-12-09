package edu.usm.cos375.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class LocationHierarchyLevel implements UuidIdentifiable, Serializable
{
    private static final long serialVersionUID = -1070569257732332545L;

    @Id
    String uuid;

    @NotNull
    String name;
    
    Integer keyIdentifier;

    @Override
    public String getUuid()
    {
        return uuid;
    }

    @Override
    public void setUuid(String uuid)
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