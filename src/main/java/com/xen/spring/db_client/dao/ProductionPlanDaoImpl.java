package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.ProductionPlanId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductionPlanDaoImpl implements ProductionPlanDAO {

    @Autowired
    SessionFactory factory;

    @Override
    public List<ProductionPlan> getPlan() {
        return factory.getCurrentSession().createQuery("from ProductionPlan ", ProductionPlan.class).getResultList();
    }

    @Override
    public void addPlan(ProductionPlan pp) {
        factory.getCurrentSession().saveOrUpdate(pp);
    }

    @Override
    public void deletePlan(ProductionPlanId id) {

    }
}
