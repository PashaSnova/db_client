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

    }
}
