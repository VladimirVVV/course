package com.courses.phones.dao;

import com.courses.phones.Phone;
import com.courses.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 06.05.2015.
 */
public class PhoneDAOHibernate implements PhoneDAO {
    private Session session;

    public PhoneDAOHibernate(Session session) {
        this.session = session;
    }

    public PhoneDAOHibernate(SessionFactory factory) {
        this(factory.openSession());
    }

    public PhoneDAOHibernate() {
        this.session = HibernateUtil.getSession();
    }

    public Phone getPhoneBy(Long id) {
        Phone phone = (Phone) session.get(Phone.class, id);
        return phone;
    }

    public Phone add(final Phone phone) {
        session.save(phone);

        return phone;
    }

    public void update(Phone phone) {
        session.update(phone);
    }

    public List<Phone> getAll() {
        Query q = session.createQuery("from Phone");
        List<Phone> phones =  (List<Phone>) q.list();

        return phones;
    }
}
