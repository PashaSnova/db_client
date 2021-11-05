package com.xen.spring.db_client.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Embeddable
public class ProductionPlanId implements Serializable {

    @Min(value = 0, message = "Must be not-negative")
    private int detail_id;

    WorkshopDirectoryId wdId;

    @Column(name = "release_year")
    @Min(value = 1950, message = "Must be greater than 1949")
    @Max(value = 2050, message = "Must be less than 2051")
    private int releaseYear;


    @Column(name = "release_month")
    private String releaseMonth;

    public ProductionPlanId() {}

    public ProductionPlanId(int detail_id, WorkshopDirectoryId wdId, int releaseYear, String releaseMonth) {
        this.detail_id = detail_id;
        this.wdId = wdId;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
    }



    public WorkshopDirectoryId getWdId() {
        return wdId;
    }

    public void setWdId(WorkshopDirectoryId wdId) {
        this.wdId = wdId;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(String releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

}
