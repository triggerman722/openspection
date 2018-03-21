package com.openspection.auth.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author greg
 */
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userid;
    private Long authorid;
    private Long positive;
    private String description;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datecreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public Long getPositive() {
        return positive;
    }

    public void setPositive(Long positive) {
        this.positive = positive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }
}
