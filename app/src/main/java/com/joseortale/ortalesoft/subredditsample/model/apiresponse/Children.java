package com.joseortale.ortalesoft.subredditsample.model.apiresponse;

import com.google.gson.annotations.SerializedName;
import com.joseortale.ortalesoft.subredditsample.model.Submission;

public class Children {
    @SerializedName("kind")
    private String kind;

    @SerializedName("data")
    private Submission submission;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }
}
