package com.spandigital.assessment.store;

import com.spandigital.assessment.contract.Database;

import java.util.*;

public class InMemory<V> implements Database<V> {

    private Hashtable<String,V> database = new Hashtable<>();

    @Override
    public boolean save(String key, V value) {
        Objects.requireNonNull(key);
        database.put(key,value);
        return count() > 0;
    }

    @Override
    public Optional<V> get(String key) {
        return Optional.ofNullable(database.get(key));
    }

    @Override
    public Iterable<V> getAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int count() {
        return database.size();
    }

    @Override
    public void clear() {
        if (database != null)
            database.clear();
    }
}
