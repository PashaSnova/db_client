package com.xen.spring.db_client.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "workshop_sections")
public class WorkshopDirectory {


    @EmbeddedId
    private WorkshopDirectoryId wdId;

    @NotEmpty
    @Column(name = "section_name")
    private String sectionName;

    @Min(value = 0, message = "Must be not-negative")
    @Column(name = "master_id")
    private int masterId;



    @OneToMany(mappedBy = "wd", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProductionPlan> planList;

    public WorkshopDirectory() {}

    public List<ProductionPlan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<ProductionPlan> planList) {
        this.planList = planList;
    }

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
