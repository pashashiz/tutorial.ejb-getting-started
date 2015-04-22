package com.ps.tutorial.ejb;

import javax.ejb.Stateful;

@Stateful
public class Counter {

    private int count = 0;

    public int count() {
        return count;
    }

    public int increment() {
        return ++count;
    }

    public int reset() {
        return (count = 0);
    }

}
