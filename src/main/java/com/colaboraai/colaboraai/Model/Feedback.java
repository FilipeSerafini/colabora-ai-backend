package com.colaboraai.colaboraai.Model;

public class Feedback {
    private boolean like;
    private String comment;

    public Feedback(boolean like, String comment) {
        this.like = like;
        this.comment = comment;
    }

    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
