package com.guilong.springbootrestfulmongoblog.demo.services;

import com.guilong.springbootrestfulmongoblog.demo.model.Post;

import java.util.Date;
import java.util.List;

public interface PostService {
    Post getById(String id);
    List<Post> getLast10Post();
    List<Post> getByUserName(String userName);
    List<Post> getByTitle(String title);
    Post createPost(Post post);
    void deletePostById(String id);
    void  deleteAll();
    Post save(Post post);


}
