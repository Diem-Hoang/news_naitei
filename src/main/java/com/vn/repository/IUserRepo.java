package com.vn.repository;

import com.vn.entity.Category;
import com.vn.entity.User;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{

}
