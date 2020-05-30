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

    /*
     @SerializedName("donutId") --> use this tag if you want to use differnet name in pojo
     and different name in json

      @Expose--> use this if to control whether we want read/write selected values from/to json

       @Expose(serialize = false) --> this value will not be written to json

       @Expose(deserialize = false) --> this value will not be read from json

when using @expose tag, create gson object like this:
     Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
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
