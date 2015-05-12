package com.courses.phones.domain;

import com.courses.phones.Phone;
import com.courses.phones.dao.PhoneDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 27.04.2015.
 */
public class PhoneServiceImpl implements PhoneService {
    private PhoneDAO dao;

    public PhoneServiceImpl() {}
    public PhoneServiceImpl(PhoneDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public Phone create(String name, Integer price) {
        Phone phone = new Phone();
        phone.setName(name);
        phone.setPrice(price);

        return create(phone);
    }

    @Transactional
    public Phone create(Phone phone) {
        return dao.add(phone);
    }

    @Transactional
    public Phone getPhoneBy(Long id) {
        return dao.getPhoneBy(id);
    }

    @Transactional(readOnly = true)
    public List<Phone> getAll() {
        return dao.getAll();
    }

    @Transactional
    public void increasePrice(Long id, Integer dif) {
        Phone phone = dao.getPhoneBy(id);
        phone.setPrice(phone.getPrice() + dif);

        dao.update(phone);
    }

}
