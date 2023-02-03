package com.etiya.customer.management.core.dataAccess;

import java.util.List;

public interface GenericRepository<T> {
    List<T> getAll();
    T getById(int id);
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
