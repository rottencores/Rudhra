package com.gracetex.revo.rudhra;

import java.util.ArrayList;

/**
 * Created by midhul on 11/14/2016.
 */

public class Article {
    private String id;
    private String title;
    private String text;
    private String category;
    private String cachefile;
    private ArrayList<String> tags;

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCachefile() {
        return cachefile;
    }

    public void setCachefile(String cachefile) {
        this.cachefile = cachefile;
    }
}
