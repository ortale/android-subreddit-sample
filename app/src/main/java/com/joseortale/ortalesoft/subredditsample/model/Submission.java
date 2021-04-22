package com.joseortale.ortalesoft.subredditsample.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Submission {
    @Expose
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @SerializedName("author_fullname")
    @Expose
    @ColumnInfo(name = "author_fullname")
    private String authorName;

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}