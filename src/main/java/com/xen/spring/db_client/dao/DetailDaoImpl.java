package com.xen.spring.db_client.dao;

import com.xen.spring.db_client.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("delete from Detail " +
                "where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Detail getDetail(int id) {
        return factory.getCurrentSession().get(Detail.class, id);
    }
}
