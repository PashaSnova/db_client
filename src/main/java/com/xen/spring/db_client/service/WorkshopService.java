package com.xen.spring.db_client.service;

import com.xen.spring.db_client.entity.WorkshopDirectory;

import java.util.List;

public interface WorkshopService {


    public List<WorkshopDirectory> getAllWorkshops();

    public void addWorkshop(WorkshopDirectory workshopDirectory);

    public void deleteWorkshop(int workshopNumber, int sectionNumber);

    public WorkshopDirectory getWorkshop(int workshopNumber, int sectionNumber);

}
