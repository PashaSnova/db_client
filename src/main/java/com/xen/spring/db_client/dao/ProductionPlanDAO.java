package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.ProductionPlanId;

import java.util.List;

public interface ProductionPlanDAO {

    public List<ProductionPlan> getPlan();

    public void addPlan(ProductionPlan pp);

    public void deletePlan(ProductionPlanId id);

    public ProductionPlan getPlanById(ProductionPlanId id);

    public List<ProductionPlan> planByDetail(int id);

    public List<ProductionPlan> planByWorkshop(int wNumber, int sNumber);

    public double countPlan(String section);

    public List<ProductionPlan> taskOneVariantOne(String month, int year);
}
