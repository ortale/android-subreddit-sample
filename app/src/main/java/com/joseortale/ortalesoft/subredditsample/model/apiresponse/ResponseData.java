package com.joseortale.ortalesoft.subredditsample.model.apiresponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {
    @SerializedName("children")
    private List<Children> children;

    @SerializedName("after")
    private String after;

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
