package com.openspection.auth.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author greg
 */
@Entity
@Table(name = "follow")
public class Follow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long createdby; //I am a follower
    private Long entityid; // This is what I am following

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datecreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Long getEntityid() {
        return entityid;
    }

    public void setEntityid(Long entityid) {
        this.entityid = entityid;
    }


    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }
}
