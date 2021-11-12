package com.xen.spring.db_client.service;

import com.xen.spring.db_client.dao.WorkshopDirectoryDAO;
import com.xen.spring.db_client.entity.WorkshopDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkshopServiceImpl implements WorkshopService{

    @Autowired
    WorkshopDirectoryDAO dao;

    @Override
    @Transactional
    public List<WorkshopDirectory> getAllWorkshops() {
        return dao.getAllWorkshops();
    }

    @Override
    @Transactional
    public void addWorkshop(WorkshopDirectory workshopDirectory) {
        dao.addWorkshop(workshopDirectory);
    }

    @Override
    @Transactional
    public void deleteWorkshop(int workshopNumber, int sectionNumber) {
        dao.deleteWorkshop(workshopNumber, sectionNumber);
    }

    @Override
    @Transactional
    public WorkshopDirectory getWorkshop(int workshopNumber, int sectionNumber) {
        return dao.getWorkshop(workshopNumber, sectionNumber);
    }
}
