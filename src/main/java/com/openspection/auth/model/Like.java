package com.openspection.auth.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author greg
 */
@Entity
@Table(name = "\"like\"")
public class Like implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long createdby; //user id
    private Long entityid; // the thing the like applies to.

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
