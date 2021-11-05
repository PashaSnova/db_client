package com.xen.spring.db_client.service;

import com.xen.spring.db_client.dao.DetailDAO;
import com.xen.spring.db_client.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailDAO dao;

    @Override
    @Transactional
    public List<Detail> getAllDetails() {
        return dao.getAllDetails();
    }

    @Override
    @Transactional
    public void addDetail(Detail detail) {
        dao.addDetail(detail);
    }

    @Override
    @Transactional
    public void deleteDetail(int id) {
        dao.deleteDetail(id);
    }

    @Override
    @Transactional
    public Detail getDetail(int id) {
        return dao.getDetail(id);
    }
}
