package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.Detail;
import com.xen.spring.db_client.entity.WorkshopDirectory;

import java.util.List;

public interface WorkshopDirectoryDAO {

    public List<WorkshopDirectory> getAllWorkshops();

    public void addWorkshop(WorkshopDirectory workshopDirectory);

    public void deleteWorkshop(int workshopNumber, int sectionNumber);

    public WorkshopDirectory getWorkshop(int workshopNumber, int sectionNumber);
}
