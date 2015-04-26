package com.courses.domain;

import com.courses.dao.ParametersDAO;

/**
 * Created by vladimir on 27.04.2015.
 */
public class Add {
    private ParametersDAO dao;
    private int result;

    public void setDao(ParametersDAO dao) {
        this.dao = dao;
    }

    public void calculate() {
        result = dao.getParam1() + dao.getParam2();
    }

    public int getA() {
        return dao.getParam1();
    }

    public int getB() {
        return dao.getParam2();
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Add{" +
                "a=" + dao.getParam1() +
                ", b=" + dao.getParam2() +
                ", result=" + result +
                '}';
    }
}
