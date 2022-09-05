package com.vn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.entity.News;
import com.vn.entity.Role;
import com.vn.repository.INewsRepo;
import com.vn.repository.IRoleRepo;
import com.vn.service.Interface.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService {
	@Autowired
    IRoleRepo iRoleRepo;

    @Override
    public void create(Role role) {
        iRoleRepo.save(role);
    }

    @Override
    public void update(Role role) {
        iRoleRepo.save(role);
    }

    @Override
    public void delete(int id) {
        iRoleRepo.deleteById(id);
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return iRoleRepo.findAll(pageable);
    }

    @Override
    public List<Role> findAll() {
        return iRoleRepo.findAll();
    }

    @Override
    public Role findById(int id) {
        return iRoleRepo.findById(id).orElse(null);
    }
}
