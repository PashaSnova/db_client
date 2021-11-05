package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        Detail detail = factory.getCurrentSession().get(Detail.class, pp.getPpId().getDetail_id());
        int wNumber = pp.getPpId().getWdId().getWorkshopNumber();
        int sNumber = pp.getPpId().getWdId().getSectionNumber();
        WorkshopDirectory wd = factory.getCurrentSession().get(WorkshopDirectory.class, new WorkshopDirectoryId(wNumber, sNumber));
        pp.setDetail(detail);
        pp.setWd(wd);
        if (detail.getPlanList() == null)
            detail.setPlanList(new ArrayList<>());
        detail.getPlanList().add(pp);
        if (wd.getPlanList() == null)
            wd.setPlanList(new ArrayList<>());
        wd.getPlanList().add(pp);
        factory.getCurrentSession().saveOrUpdate(pp);
    }

    @Override
    public void deletePlan(ProductionPlanId id) {
        ProductionPlan plan = factory.getCurrentSession().get(ProductionPlan.class, id);
        plan.getDetail().getPlanList().remove(plan);
        plan.getWd().getPlanList().remove(plan);
        factory.getCurrentSession()
                .delete(plan);
    }

    @Override
    public ProductionPlan getPlanById(ProductionPlanId id) {
        return factory
                .getCurrentSession()
                .get(ProductionPlan.class, id);
    }
}
