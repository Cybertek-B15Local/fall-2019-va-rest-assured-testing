package com.cbt.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Donut {
    /*
    {
       "donutId" : 100,
       "name" : "cake donut",
       "sugarPercentage": 70,
       "isGlutenFree": yes
    }
     */
    @SerializedName("donutId")
    @Expose(serialize = false)
    private int id;

    @Expose
    private String name;

    @SerializedName("sugarPercentage")
    @Expose
    private int sugarPct;

    @Expose
    private boolean isGlutenFree;

    public Donut(String name, int sugarPct, boolean isGlutenFree) {
        this.name = name;
        this.sugarPct = sugarPct;
        this.isGlutenFree = isGlutenFree;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sugarPct=" + sugarPct +
                ", isGlutenFree=" + isGlutenFree +
                '}';
    }
}
