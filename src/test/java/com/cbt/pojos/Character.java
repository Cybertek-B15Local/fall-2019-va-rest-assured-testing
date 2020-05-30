package com.cbt.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("_id")
    
    private String id;

    @SerializedName("name")
    private String name;
    @SerializedName("__v")
    private int v;
    @SerializedName("ministryOfMagic")
    private boolean ministryOfMagic;
    @SerializedName("orderOfThePhoenix")
    private boolean orderOfThePhoenix;
    @SerializedName("dumbledoresArmy")
    private boolean dumbledoresArmy;
    @SerializedName("deathEater")
    private boolean deathEater;
    @SerializedName("bloodStatus")
    private String bloodStatus;
    @SerializedName("species")
    private String species;

    /**
     * No args constructor for use in serialization
     *
     */
    public Character() {
    }

    /**
     *
     * @param bloodStatus
     * @param species
     * @param v
     * @param deathEater
     * @param dumbledoresArmy
     * @param name
     * @param ministryOfMagic
     * @param id
     * @param orderOfThePhoenix
     */
    public Character(String id, String name, int v, boolean ministryOfMagic, boolean orderOfThePhoenix, boolean dumbledoresArmy, boolean deathEater, String bloodStatus, String species) {
        super();
        this.id = id;
        this.name = name;
        this.v = v;
        this.ministryOfMagic = ministryOfMagic;
        this.orderOfThePhoenix = orderOfThePhoenix;
        this.dumbledoresArmy = dumbledoresArmy;
        this.deathEater = deathEater;
        this.bloodStatus = bloodStatus;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", v=" + v +
                ", ministryOfMagic=" + ministryOfMagic +
                ", orderOfThePhoenix=" + orderOfThePhoenix +
                ", dumbledoresArmy=" + dumbledoresArmy +
                ", deathEater=" + deathEater +
                ", bloodStatus='" + bloodStatus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isMinistryOfMagic() {
        return ministryOfMagic;
    }

    public void setMinistryOfMagic(boolean ministryOfMagic) {
        this.ministryOfMagic = ministryOfMagic;
    }

    public boolean isOrderOfThePhoenix() {
        return orderOfThePhoenix;
    }

    public void setOrderOfThePhoenix(boolean orderOfThePhoenix) {
        this.orderOfThePhoenix = orderOfThePhoenix;
    }

    public boolean isDumbledoresArmy() {
        return dumbledoresArmy;
    }

    public void setDumbledoresArmy(boolean dumbledoresArmy) {
        this.dumbledoresArmy = dumbledoresArmy;
    }

    public boolean isDeathEater() {
        return deathEater;
    }

    public void setDeathEater(boolean deathEater) {
        this.deathEater = deathEater;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public void setBloodStatus(String bloodStatus) {
        this.bloodStatus = bloodStatus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
