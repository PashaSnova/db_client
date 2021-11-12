package com.xen.spring.db_client.service;

import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.ProductionPlanId;

import java.util.List;

public interface ProductionPlanService {


    public List<ProductionPlan> getPlan();

    public void addPlan(ProductionPlan pp);

    public void deletePlan(ProductionPlanId id);

    public ProductionPlan getPlanById(ProductionPlanId id);

    public List<ProductionPlan> getPlanByDetail(int id);

    public List<ProductionPlan> getPlanByWorkshop(int wNumber, int sNumber);

    public double countSum(String section);

    public List<ProductionPlan> taskOneVariantOne(String month, int year);
}
