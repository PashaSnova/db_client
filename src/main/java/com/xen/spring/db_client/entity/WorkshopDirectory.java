package com.xen.spring.db_client.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "workshop_sections")
public class WorkshopDirectory {


    @EmbeddedId
    private WorkshopDirectoryId wdId;

    @Column(name = "section_name")
    private String sectionName;

    @Min(value = 0, message = "Must be greater than 0 or equal")
    @Column(name = "master_id")
    private int masterId;

    public WorkshopDirectory() {}


    public WorkshopDirectoryId getWdId() {
        return wdId;
    }

    public void setWdId(WorkshopDirectoryId wdId) {
        this.wdId = wdId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }
}
