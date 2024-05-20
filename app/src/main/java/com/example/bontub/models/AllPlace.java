package com.example.bontub.models;

public class AllPlace {
    private int id;
    private String provinceName;
    private String pageBannerUrl;
    private String pageBannerTitle;
    private String placeTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getPageBannerUrl() {
        return pageBannerUrl;
    }

    public void setPageBannerUrl(String pageBannerUrl) {
        this.pageBannerUrl = pageBannerUrl;
    }

    public String getPageBannerTitle() {
        return pageBannerTitle;
    }

    public void setPageBannerTitle(String pageBannerTitle) {
        this.pageBannerTitle = pageBannerTitle;
    }

    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }
}