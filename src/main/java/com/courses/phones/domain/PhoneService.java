package com.courses.phones.domain;

import com.courses.phones.Phone;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 06.05.2015.
 */
public interface PhoneService {
    Phone create(String name, Integer price);

    Phone create(Phone phone);

    Phone getPhoneBy(Long id);

    List<Phone> getAll();

    void increasePrice(Long id, Integer dif);
}
