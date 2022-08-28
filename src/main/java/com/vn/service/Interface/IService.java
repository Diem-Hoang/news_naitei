package com.vn.service.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<E> {
    void create(E e);
    void update(E e);
    void delete(int id);
    Page<E> findAll(Pageable pageable);
    List<E> findAll();
    E findById(int id);
}
