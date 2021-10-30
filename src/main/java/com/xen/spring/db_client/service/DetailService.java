package com.xen.spring.db_client.service;

import com.xen.spring.db_client.entity.Detail;

import java.util.List;

public interface DetailService {

    public List<Detail> getAllDetails();

    public void addDetail(Detail detail);
}
