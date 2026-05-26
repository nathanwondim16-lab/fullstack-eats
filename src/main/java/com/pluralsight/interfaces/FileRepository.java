package com.pluralsight.interfaces;

public interface FileRepository<T> {

    void save(T details);
}
