package com.vn.repository;

import com.vn.entity.News;
import com.vn.entity.Role;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {

}
