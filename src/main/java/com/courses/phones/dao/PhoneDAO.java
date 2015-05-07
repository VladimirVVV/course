package com.courses.phones.dao;

import com.courses.phones.Phone;

import java.util.List;

/**
 * Created by vladimir on 06.05.2015.
 */
public interface PhoneDAO {
    Phone getPhoneBy(Long id);

    Phone add(final Phone phone);

    void update(Phone phone);

    List<Phone> getAll();
}
