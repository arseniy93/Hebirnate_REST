package com.rigin.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T, ID extends Serializable> {

    Optional<T> findById(ID id);

    List<T> getAll();

    void save(T t);

    void delete(T t);

    T update(T t);
    void deleteById(ID id);
}
