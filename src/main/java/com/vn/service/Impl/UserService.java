package com.vn.service.Impl;

import com.vn.entity.User;
import com.vn.repository.IUserRepo;
import com.vn.service.Interface.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
	@Autowired
    IUserRepo iUserRepo;

    @Override
    public void create(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void update(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void delete(int id) {
        iUserRepo.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepo.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return iUserRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return iUserRepo.findById(id).orElse(null);
    }
}
