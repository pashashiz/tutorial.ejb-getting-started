package com.ps.tutorial.ejb;

import javax.ejb.Singleton;

@Singleton
public class RequestCounter {

    private int count;

    public int getCount() {
        return ++count;
    }

}
