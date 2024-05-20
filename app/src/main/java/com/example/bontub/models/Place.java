package com.example.bontub.models;

import java.util.List;

public class Place {
    private int id;
    private List<PlaceSection> placeSections;
    private List<Object> feedbacks;
    private Province province;
    private PageBanner pageBanner;
    private int starCount;
    private PlaceType placeType;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PlaceSection> getPlaceSections() {
        return placeSections;
    }

    public void setPlaceSections(List<PlaceSection> placeSections) {
        this.placeSections = placeSections;
    }

    public List<Object> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Object> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public PageBanner getPageBanner() {
        return pageBanner;
    }

    public void setPageBanner(PageBanner pageBanner) {
        this.pageBanner = pageBanner;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
