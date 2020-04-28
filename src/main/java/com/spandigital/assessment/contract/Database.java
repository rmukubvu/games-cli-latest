package com.spandigital.assessment.contract;

import java.util.Optional;

public interface Database<V> {
    boolean save(String key, V value);
    Optional<V> get(String key);
    Iterable<V> getAll();
    int count();
    void clear();
}
