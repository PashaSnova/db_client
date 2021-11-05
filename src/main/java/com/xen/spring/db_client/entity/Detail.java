package com.xen.spring.db_client.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @Min(value = 0, message = "Must be not-negative")
    @Column(name = "id")
    private int id;

    @Column(name = "detail_type")
    private String detailType;

    @NotEmpty(message = "Must be not empty")
    @Column(name = "detail_name")
    private String detailName;

    @Column(name = "measure")
    private String measure;

    @Min(value = 0, message = "Must be not-negative")
    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "detail", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductionPlan> planList;

    public Detail()
    {
        this.measure = "штука";
    }

    public Detail(String detailType, String detailName, String measure, double price) {
        this.detailType = detailType;
        this.detailName = detailName;
        this.measure = measure;
        this.price = price;
    }


    public List<ProductionPlan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<ProductionPlan> planList) {
        this.planList = planList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
