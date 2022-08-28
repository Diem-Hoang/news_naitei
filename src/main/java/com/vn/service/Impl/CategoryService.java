package com.vn.service.Impl;

import com.vn.entity.Category;
import com.vn.repository.ICategoryRepo;
import com.vn.service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Override
    public void create(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void update(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        iCategoryRepo.deleteById(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepo.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).orElse(null);
    }
}
