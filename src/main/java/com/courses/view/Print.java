package com.courses.view;

import com.courses.domain.Add;

/**
 * Created by vladimir on 27.04.2015.
 */
public class Print {
    private Add calc;

    public void setCalc(Add calc) {
        this.calc = calc;
    }

    public void print() {
        calc.calculate();
        System.out.println(calc);
    }
}
