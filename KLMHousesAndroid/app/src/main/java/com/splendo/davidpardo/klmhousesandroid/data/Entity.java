package com.splendo.davidpardo.klmhousesandroid.data;

/**
 * Created by davidpardo on 11/22/16.
 */

public class Entity {
    private int EntityId;
    private String entityImageName;
    private String entityAttributeOne;
    private String entityAttributeTwo;
    private boolean favourite;

    public Entity(int entityId, String entityImageName, String entityAttributeOne, String entityAttributeTwo, boolean favourite) {
        this.EntityId = entityId;
        this.entityImageName = entityImageName;
        this.entityAttributeOne = entityAttributeOne;
        this.entityAttributeTwo = entityAttributeTwo;
        this.favourite = favourite;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getEntityAttributeOne() {
        return entityAttributeOne;
    }

    public void setEntityAttributeOne(String entityAttributeOne) {
        this.entityAttributeOne = entityAttributeOne;
    }

    public String getEntityAttributeTwo() {
        return entityAttributeTwo;
    }

    public void setEntityAttributeTwo(String entityAttributeTwo) {
        this.entityAttributeTwo = entityAttributeTwo;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        this.EntityId = entityId;
    }

    public String getEntityImageName() {
        return entityImageName;
    }

    public void setEntityImageName(String entityImageName) {
        this.entityImageName = entityImageName;
    }

    public boolean toggleFavourite(){
        favourite = !favourite;
        return favourite;
    }
}
