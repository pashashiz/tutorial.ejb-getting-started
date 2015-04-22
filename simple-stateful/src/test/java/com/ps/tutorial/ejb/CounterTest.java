package com.ps.tutorial.ejb;

import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import static junit.framework.Assert.assertEquals;

public class CounterTest {

    @Test
    public void testCounter() throws Exception {
        final Context context = EJBContainer.createEJBContainer().getContext();
        Counter counterA = (Counter) context.lookup("java:global/simple-stateful/Counter");

        assertEquals(0, counterA.count());
        assertEquals(0, counterA.reset());
        assertEquals(1, counterA.increment());
        assertEquals(2, counterA.increment());
        assertEquals(0, counterA.reset());

        counterA.increment();
        counterA.increment();
        counterA.increment();
        counterA.increment();

        assertEquals(4, counterA.count());

        // Get a new counter
        Counter counterB = (Counter) context.lookup("java:global/simple-stateful/Counter");
        // The new bean instance starts out at 0
        assertEquals(0, counterB.count());
    }

}
