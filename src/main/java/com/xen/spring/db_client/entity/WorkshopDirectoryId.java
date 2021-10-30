package com.xen.spring.db_client.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WorkshopDirectoryId implements Serializable {

    @Min(value = 0, message = "Must be greater than 0 or equal")
    @Column(name = "workshop_number")
    private int workshopNumber;


    @Min(value = 0, message = "Must be greater than 0 or equal")
    @Column(name = "section_number")
    private int sectionNumber;

    public WorkshopDirectoryId(int workshopNumber, int sectionNumber) {
        this.workshopNumber = workshopNumber;
        this.sectionNumber = sectionNumber;
    }

    public WorkshopDirectoryId() {}

    public int getWorkshopNumber() {
        return workshopNumber;
    }

    public void setWorkshopNumber(int workshopNumber) {
        this.workshopNumber = workshopNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkshopDirectoryId that = (WorkshopDirectoryId) o;
        return workshopNumber == that.workshopNumber && sectionNumber == that.sectionNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workshopNumber, sectionNumber);
    }
}
