package com.blog.app.repository;

import com.blog.app.model.Comment;
import com.blog.app.model.Post;
import com.blog.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

    List<Comment> findByUser(User user);

    List<Comment> findByPost(Post post);

}
