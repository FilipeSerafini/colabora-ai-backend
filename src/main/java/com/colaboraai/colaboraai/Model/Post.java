package com.colaboraai.colaboraai.Model;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.lang.Nullable;

public class Post {
    private String title;
    private ArrayList<String> category;
    private String description;
    @Nullable
    private String image;
    @Nullable
    private Feedback feedback;
    @Nullable
    private PointOfInterest pointOfInterest;
    private String id;

    public Post(String id, String title, String description, String image, List<String> category,
            PointOfInterest pointOfInterest) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = new ArrayList<>(category);
        this.pointOfInterest = pointOfInterest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public PointOfInterest getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointOfInterest pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}