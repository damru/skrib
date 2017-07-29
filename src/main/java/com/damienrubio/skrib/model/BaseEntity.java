package com.damienrubio.skrib.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    /**
     * Update date
     */
    @Column(insertable = false, updatable = true)
    private Timestamp updateDate;

    /**
     * Creation date
     */
    @Column(insertable = true, updatable = false)
    private Timestamp creationDate;

    @PrePersist
    void onCreate() {
        this.setCreationDate(new Timestamp((new Date()).getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setUpdateDate(new Timestamp((new Date()).getTime()));
    }
}
