package edu.usm.cos375.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class LocationHierarchy implements Serializable
{
    private static final long serialVersionUID = -5334850119671675888L;

    @Id
    Long uuid;

    @NotNull
    String name;

    LocationHierarchy parent;
    
    @NotNull
    LocationHierarchyLevel level;

    public Long getUuid()
    {
        return uuid;
    }

    public void setUuid(Long uuid)
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