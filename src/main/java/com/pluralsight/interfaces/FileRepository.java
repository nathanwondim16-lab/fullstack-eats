package com.pluralsight.interfaces;

import com.pluralsight.models.Order;

public interface FileRepository<T> {

    void save(T item);
}
