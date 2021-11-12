package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
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

    @Override
    public List<ProductionPlan> planByDetail(int id) {
        return factory
                .getCurrentSession()
                .createQuery("from ProductionPlan where detail.id =: id", ProductionPlan.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<ProductionPlan> planByWorkshop(int wNumber, int sNumber) {
        return factory
                .getCurrentSession()
                .createQuery("from ProductionPlan" +
                        " where ppId.wdId.workshopNumber=:wNumber" +
                        " and ppId.wdId.sectionNumber=:sNumber", ProductionPlan.class)
                .setParameter("wNumber", wNumber)
                .setParameter("sNumber", sNumber)
                .getResultList();
    }

    @Override
    public double countPlan(String section) {

        return factory
                .getCurrentSession()
                .createQuery("from WorkshopDirectory where sectionName=:section", WorkshopDirectory.class)
                .setParameter("section", section)
                .getResultList().size() == 0 ? -1 :
                (double)factory
                .getCurrentSession()
                .createStoredProcedureQuery("count_plan_by_section")
                .registerStoredProcedureParameter("sect_name", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("summary", Double.class, ParameterMode.OUT)
                .setParameter("sect_name", section)
                .getOutputParameterValue("summary");
    }

    @Override
    public List<ProductionPlan> taskOneVariantOne(String month, int year) {
        return factory
                .getCurrentSession()
                .createQuery("select pp from ProductionPlan pp " +
                        "join WorkshopDirectory wd on pp.ppId.wdId = wd.wdId " +
                        "where pp.ppId.releaseYear=:year and pp.ppId.releaseMonth=:month", ProductionPlan.class)
                .setParameter("year", year)
                .setParameter("month", month)
                .getResultList();
    }
}
