package com.example.bontub.models;

import java.util.List;

public class PlaceSection {
    private int id;
    private List<PlaceSection> placeSectionPhotos;
    private String mapUrl;
    private String description;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PlaceSection> getPlaceSectionPhotos() {
        return placeSectionPhotos;
    }

    public void setPlaceSectionPhotos(List<PlaceSection> placeSectionPhotos) {
        this.placeSectionPhotos = placeSectionPhotos;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
