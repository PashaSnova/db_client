package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.WorkshopDirectory;
import com.xen.spring.db_client.entity.WorkshopDirectoryId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkshopDirectoryDaoImpl implements WorkshopDirectoryDAO {

    @Autowired
    SessionFactory factory;

    @Override
    public List<WorkshopDirectory> getAllWorkshops() {
        return factory.getCurrentSession().createQuery("from WorkshopDirectory ", WorkshopDirectory.class).getResultList();
    }

    @Override
    public void addWorkshop(WorkshopDirectory workshopDirectory) {
        factory.getCurrentSession().saveOrUpdate(workshopDirectory);
    }

    @Override
    public void deleteWorkshop(int workshopNumber, int sectionNumber) {
        factory.
                getCurrentSession()
                .createQuery("delete from WorkshopDirectory " +
                "where wdId.workshopNumber=:workshopNumber and wdId.sectionNumber=:sectionNumber")
                .setParameter("workshopNumber", workshopNumber)
                .setParameter("sectionNumber", sectionNumber)
                .executeUpdate();
    }

    @Override
    public WorkshopDirectory getWorkshop(int workshopNumber, int sectionNumber) {
        return factory.getCurrentSession().get(WorkshopDirectory.class, new WorkshopDirectoryId(workshopNumber, sectionNumber));
    }
}
