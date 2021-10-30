package com.xen.spring.db_client.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "detail_type")
    private String detailType;

    @Column(name = "detail_name")
    private String detailName;

    @Column(name = "measure")
    @Value("штука")
    private String measure;

    @Min(value = 0, message = "Must be greater than 0 or equal")
    @Column(name = "price")
    private double price;

    public Detail() {}

    public Detail(String detailType, String detailName, String measure, double price) {
        this.detailType = detailType;
        this.detailName = detailName;
        this.measure = measure;
        this.price = price;
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
