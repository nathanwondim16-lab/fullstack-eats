package com.pluralsight.interfaces;

import java.nio.file.Path;

public interface FileRepository<T> {
    Path save(T item);
}
