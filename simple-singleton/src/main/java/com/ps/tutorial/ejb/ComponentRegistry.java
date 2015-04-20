package com.ps.tutorial.ejb;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Lock(READ)
public class ComponentRegistry {

    private final Map<Class, Object> components = new HashMap<>();

    public <T> T getComponent(final Class<T> type) {
        return (T) components.get(type);
    }

    public Collection<?> getComponents() {
        return new ArrayList(components.values());
    }

    @Lock(WRITE)
    public <T> T setComponent(final Class<T> type, final T value) {
        return (T) components.put(type, value);
    }

    @Lock(WRITE)
    public <T> T removeComponent(final Class<T> type) {
        return (T) components.remove(type);
    }

}