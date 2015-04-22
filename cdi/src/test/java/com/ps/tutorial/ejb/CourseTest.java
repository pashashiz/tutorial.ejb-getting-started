package com.ps.tutorial.ejb;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourseTest {

    private static EJBContainer container;

    @EJB
    private Course course;

    @BeforeClass
    public static void start() {
        container = EJBContainer.createEJBContainer();
    }

    @Before
    public void setUp() throws Exception {
        container.getContext().bind("inject", this);
    }

    @Test
    public void test() {
        // Was the EJB injected?
        assertTrue(course != null);
        // Was the Course @PostConstruct called?
        assertNotNull(course.getCourseName());
        assertTrue(course.getCapacity() > 0);
        // Was a Faculty instance injected into Course?
        final Faculty faculty = course.getFaculty();
        assertTrue(faculty != null);
        // Was the @PostConstruct called on Faculty?
        assertEquals(faculty.getFacultyName(), "Computer Science");
        assertEquals(faculty.getFacultyMembers().size(), 2);
    }

    @AfterClass
    public static void stop() {
        container.close();
    }
}
