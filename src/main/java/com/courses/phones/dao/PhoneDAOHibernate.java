package com.courses.phones.dao;

import com.courses.phones.Phone;
import com.courses.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 06.05.2015.
 */
public class PhoneDAOHibernate implements PhoneDAO {
    private SessionFactory factory;

//    public PhoneDAOHibernate(Session session) {
//        this.session = session;
//    }

//    public PhoneDAOHibernate() {
//        this.session = HibernateUtil.getSession();
//    }

    public PhoneDAOHibernate(SessionFactory factory) {
        this.factory = factory;
    }

    public Phone getPhoneBy(Long id) {
        Phone phone = (Phone) factory.getCurrentSession().get(Phone.class, id);
        return phone;
    }

    public Phone add(final Phone phone) {
        factory.getCurrentSession().save(phone);

        return phone;
    }

    public void update(Phone phone) {
        factory.getCurrentSession().update(phone);
    }

    public List<Phone> getAll() {
        Query q = factory.getCurrentSession().createQuery("from Phone");
        List<Phone> phones =  (List<Phone>) q.list();

        return phones;
    }
}
