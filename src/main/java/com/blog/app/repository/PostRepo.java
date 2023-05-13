package com.blog.app.repository;

import com.blog.app.model.Category;
import com.blog.app.model.Post;
import com.blog.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    //find post by user
    List<Post> findAllByUser(User user);

    //find post by category
    List<Post> findAllByCategory(Category category);

}
