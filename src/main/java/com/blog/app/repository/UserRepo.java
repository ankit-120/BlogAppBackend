package com.blog.app.repository;

import com.blog.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
