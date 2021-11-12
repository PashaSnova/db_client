package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.Detail;

import java.util.List;

public interface DetailDAO {

    public List<Detail> getAllDetails();

    public void addDetail(Detail detail);

    public void deleteDetail(int id);

    public Detail getDetail(int id);

}
