package com.cbt.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("rel")
    private String rel;
    @SerializedName("href")
    private String href;

    /**
     * No args constructor for use in serialization
     */
    public Link() {
    }

    /**
     * @param rel
     * @param href
     */
    public Link(String rel, String href) {
        super();
        this.rel = rel;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}