/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openspection.auth.model;

import javax.persistence.*;
import java.util.Set;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author greg
 */
@Entity(name="post")
@Table(name = "\"post\"")
public class Post implements Serializable {

    private Long id;

    private String title;
    private String description;
    private String location;

    private Long createdby;

    private double latitude;
    private double longitude;
    private Long radius;

    private boolean requestPhotos;
    private boolean requestVideos;
    private boolean requestAudio;

    private Long votesup;
    private Long votesdown;

    private Long acceptedcommentid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecreated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateexpired;


    @ManyToMany
    @JoinTable(name = "POST_COMMMENT", joinColumns = {
            @JoinColumn(name = "POST_ID", referencedColumnName = "ID"),
            @JoinColumn(name = "COMMENT_ID", referencedColumnName = "ID")
    })
    private Set<Comment> comments;

    private Set<User> inspectors;
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(name = "POST_INSPECTOR", joinColumns = {
            @JoinColumn(name = "POST_ID", referencedColumnName = "ID"),
            @JoinColumn(name = "INSPECTOR_ID", referencedColumnName = "ID")
    })
    public Set<User> getInspectors() {
        return inspectors;
    }

    public void setInspectors(Set<User> inspectors) {
        this.inspectors = inspectors;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
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

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

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

    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
