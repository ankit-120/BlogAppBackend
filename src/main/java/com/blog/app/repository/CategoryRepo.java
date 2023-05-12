package com.blog.app.repository;

import com.blog.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    Category findByTitle(String title);

}
