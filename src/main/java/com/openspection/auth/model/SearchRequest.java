package com.openspection.auth.model;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchRequest {

    private String keywords;
    private String location;
    private double latitude;
    private double longitude;
    private Category category;
    private Long id;


    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
/*
    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDateexpired() {
        return dateexpired;
    }

    public void setDateexpired(Date dateexpired) {
        this.dateexpired = dateexpired;
    }

	public boolean getRequestPhotos() {
        return requestPhotos;
    }

    public void setRequestPhotos(boolean requestPhotos) {
        this.requestPhotos = requestPhotos;
    }

    public Long getVotesup() {
        return votesup;
    }

    public void setVotesup(Long votesup) {
        this.votesup = votesup;
    }

    public Long getVotesdown() {
        return votesdown;
    }

    public void setVotesdown(Long votesdown) {
        this.votesdown = votesdown;
    }

    public boolean isRequestVideos() {
        return requestVideos;
    }

    public void setRequestVideos(boolean requestVideos) {
        this.requestVideos = requestVideos;
    }

    public boolean isRequestAudio() {
        return requestAudio;
    }

    public void setRequestAudio(boolean requestAudio) {
        this.requestAudio = requestAudio;
    }

    public Long getAcceptedcommentid() {
        return acceptedcommentid;
    }

    public void setAcceptedcommentid(Long acceptedcommentid) {
        this.acceptedcommentid = acceptedcommentid;
    }

*/
}
