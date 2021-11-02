package com.xen.spring.db_client.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "production_plan")
public class ProductionPlan {

    @EmbeddedId
    private ProductionPlanId ppId;

    @Min(value = 0)
    @Column(name = "release_plan")
    private int releasePlan;


    public ProductionPlan() {}

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
