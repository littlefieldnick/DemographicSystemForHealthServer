package edu.usm.cos375.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class LocationHierarchy implements UuidIdentifiable, Serializable
{
    private static final long serialVersionUID = -5334850119671675888L;

    @Id
    String uuid;

    @NotNull
    String name;

    LocationHierarchy parent;
    
    @NotNull
    LocationHierarchyLevel level;

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

    public LocationHierarchy getParent()
    {
        return parent;
    }

    public void setParent(LocationHierarchy parent)
    {
        this.parent = parent;
    }

    public LocationHierarchyLevel getLevel()
    {
        return level;
    }

    public void setLevel(LocationHierarchyLevel level)
    {
        this.level = level;
    }
}