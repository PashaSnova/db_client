package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailDaoImpl implements DetailDAO {

    @Autowired
    SessionFactory factory;

    @Override
    public List<Detail> getAllDetails() {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Detail", Detail.class).getResultList();
    }

    @Override
    public void addDetail(Detail detail) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(detail);
    }

    @Override
    public void deleteDetail(int id) {
        factory
                .getCurrentSession()
                .createQuery("delete from Detail where id=:id")
                .setParameter("id", id)
                .executeUpdate();
//        Detail detail = factory.getCurrentSession().get(Detail.class, id);
//        System.out.println(detail.getId());
//        System.out.println(detail.getDetailName());
//        factory.getCurrentSession().delete(detail);
    }

    @Override
    public Detail getDetail(int id) {
        return factory.getCurrentSession().get(Detail.class, id);
    }
}
