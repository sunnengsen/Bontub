package com.example.bontub.models;

public class PageBanner {
    private int id;
    private String imageUrl;
    private String imageUrlSm;
    private String title;
    private String description;
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlSm() {
        return imageUrlSm;
    }

    public void setImageUrlSm(String imageUrlSm) {
        this.imageUrlSm = imageUrlSm;
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
