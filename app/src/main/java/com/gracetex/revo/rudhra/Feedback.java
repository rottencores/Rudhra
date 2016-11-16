package com.gracetex.revo.rudhra;

/**
 * Created by midhul on 11/14/2016.
 */

public class Feedback {
    private String title;
    private String description;
    private int upvotes;

    public Feedback() {
    }

    public Feedback(String title, String description, int upvotes) {
        this.title = title;
        this.description = description;
        this.upvotes = upvotes;

    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
