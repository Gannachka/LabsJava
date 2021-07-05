package com.example.Lab25.repository;

import java.util.List;

public interface Repository<T> {

    void insert(T element);
    void delete(T element);
    void update(T element);
    T select(int id);
}
