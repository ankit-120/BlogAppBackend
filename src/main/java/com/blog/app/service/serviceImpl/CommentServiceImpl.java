package com.blog.app.service.serviceImpl;

import com.blog.app.dto.CommentDto;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.model.Comment;
import com.blog.app.model.Post;
import com.blog.app.model.User;
import com.blog.app.repository.CommentRepo;
import com.blog.app.repository.PostRepo;
import com.blog.app.repository.UserRepo;
import com.blog.app.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    //add comment
    @Override
    public CommentDto addComment(CommentDto commentDto, int postId, int userId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        Comment map = this.modelMapper.map(commentDto, Comment.class);
        map.setUser(user);
        map.setPost(post);
        Comment save = this.commentRepo.save(map);
        return this.modelMapper.map(save, CommentDto.class);
    }

    @Override
    public void deleteComment(int commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        this.commentRepo.delete(comment);
    }

    @Override
    public List<CommentDto> getCommentByUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        List<Comment> comments = this.commentRepo.findByUser(user);
        return comments.stream().map((comment -> this.modelMapper.map(comment, CommentDto.class))).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getCommentByPost(int postId) {
        log.info("inside get comment by post service");
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        List<Comment> comments = this.commentRepo.findByPost(post);
        return comments.stream().map((comment -> this.modelMapper.map(comment, CommentDto.class))).collect(Collectors.toList());
    }
}
