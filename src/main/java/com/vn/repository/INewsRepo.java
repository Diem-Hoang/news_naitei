package com.vn.repository;

import com.vn.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsRepo extends JpaRepository<News, Integer> {
}
