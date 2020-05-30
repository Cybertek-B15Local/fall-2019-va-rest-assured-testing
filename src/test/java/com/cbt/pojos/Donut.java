package com.cbt.pojos;

public class Donut {
    /*
    {
       "donutId" : 100,
       "name" : "cake donut",
       "sugarPercentage": 70,
       "isGlutenFree": yes
    }
     */
    private int id;
    private String name;
    private int sugarPct;
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
