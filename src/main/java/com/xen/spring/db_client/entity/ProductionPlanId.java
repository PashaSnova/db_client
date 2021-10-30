package com.xen.spring.db_client.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductionPlanId implements Serializable {

    @MapsId
    private int detailId;
    @MapsId
    private WorkshopDirectoryId wdId;
    private int releaseYear;
    private String releaseMonth;

    public ProductionPlanId() {}

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

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public WorkshopDirectoryId getWdId() {
        return wdId;
    }

    public void setWdId(WorkshopDirectoryId wdId) {
        this.wdId = wdId;
    }
}
