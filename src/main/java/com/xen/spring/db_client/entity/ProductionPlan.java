package com.xen.spring.db_client.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "production_plan")
public class ProductionPlan {

    @EmbeddedId
    private ProductionPlanId ppId;

    @Min(value = 0, message = "Must be not-negative")
    @Column(name = "release_plan")
    private int releasePlan;


    @MapsId("detail_id")
    @ManyToOne
            //(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private Detail detail;

    @MapsId("wdId")
    @ManyToOne
            //(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "workshop_number", referencedColumnName = "workshop_number"),
            @JoinColumn(name = "section_number", referencedColumnName = "section_number")
    })
    private WorkshopDirectory wd;

    public ProductionPlan() {}


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

    public ProductionPlanId getPpId() {
        return ppId;
    }

    public void setPpId(ProductionPlanId ppId) {
        this.ppId = ppId;
    }

    public int getReleasePlan() {
        return releasePlan;
    }

    public void setReleasePlan(int releasePlan) {
        this.releasePlan = releasePlan;
    }
}
