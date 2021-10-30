package com.xen.spring.db_client.entity;


import javax.persistence.*;

@Entity
@Table(name = "production_plan")
public class ProductionPlan {

    @EmbeddedId
    private ProductionPlanId ppId;

    @Column(name = "release_plan")
    private int releasePlan;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "workshopNumber"
            , referencedColumnName = "workshop_number"),
            @JoinColumn(name = "sectionNumber",
            referencedColumnName = "section_number")
    })
    private WorkshopDirectory wd;

    @ManyToOne
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private Detail detail;

    public ProductionPlan() {}

    public int getReleasePlan() {
        return releasePlan;
    }

    public void setReleasePlan(int releasePlan) {
        this.releasePlan = releasePlan;
    }
}
