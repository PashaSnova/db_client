package com.xen.spring.db_client.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Embeddable
public class ProductionPlanId implements Serializable {


    @MapsId()
    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private Detail detail;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "workshop_number"
                    , referencedColumnName = "workshop_number"),
            @JoinColumn(name = "section_number",
                    referencedColumnName = "section_number")
    })
    private WorkshopDirectory wd;
    @Column(name = "release_year")
    @Min(value = 1950)
    @Max(value = 2022)
    private int releaseYear;
    @Column(name = "release_month")
    private String releaseMonth;

    public ProductionPlanId() {}


    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public WorkshopDirectory getWd() {
        return wd;
    }

    public void setWd(WorkshopDirectory wd) {
        this.wd = wd;
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
