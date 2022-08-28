package com.vn.service.Impl;

import com.vn.entity.News;
import com.vn.repository.INewsRepo;
import com.vn.service.Interface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    INewsRepo iNewsRepo;

    @Override
    public void create(News news) {
        iNewsRepo.save(news);
    }

    @Override
    public void update(News news) {
        iNewsRepo.save(news);
    }

    @Override
    public void delete(int id) {
        iNewsRepo.deleteById(id);
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return iNewsRepo.findAll(pageable);
    }

    @Override
    public List<News> findAll() {
        return iNewsRepo.findAll();
    }

    @Override
    public News findById(int id) {
        return iNewsRepo.findById(id).orElse(null);
    }
}
