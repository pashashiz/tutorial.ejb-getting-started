package com.ps.tutorial.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Course {

    @Inject
    private Faculty faculty;

    private String courseName;

    private int capacity;

    @PostConstruct
    private void init() {
        assert faculty != null;
        courseName = "CDI 101 - Introduction to CDI";
        capacity = 100;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public Faculty getFaculty() {
        return faculty;
    }

}
