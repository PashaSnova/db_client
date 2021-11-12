package com.xen.spring.db_client.service;

import com.xen.spring.db_client.dao.ProductionPlanDAO;
import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.ProductionPlanId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductionPlanServiceImpl implements ProductionPlanService {

    @Autowired
    ProductionPlanDAO dao;


    @Override
    @Transactional
    public List<ProductionPlan> getPlan() {
        return dao.getPlan();
    }

    @Override
    @Transactional
    public void addPlan(ProductionPlan pp) {
        dao.addPlan(pp);
    }

    @Override
    @Transactional
    public void deletePlan(ProductionPlanId id) {
        dao.deletePlan(id);
    }

    @Override
    @Transactional
    public ProductionPlan getPlanById(ProductionPlanId id) {
        return dao.getPlanById(id);
    }

    @Override
    @Transactional
    public List<ProductionPlan> getPlanByDetail(int id) {
        return dao.planByDetail(id);
    }

    @Override
    @Transactional
    public List<ProductionPlan> getPlanByWorkshop(int wNumber, int sNumber) {
        return dao.planByWorkshop(wNumber, sNumber);
    }

    @Override
    @Transactional
    public double countSum(String section) {
        return dao.countPlan(section);
    }

    @Override
    @Transactional
    public List<ProductionPlan> taskOneVariantOne(String month, int year) {
        return dao.taskOneVariantOne(month, year);
    }
}
