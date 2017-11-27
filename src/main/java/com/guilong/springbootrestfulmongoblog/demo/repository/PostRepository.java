package com.guilong.springbootrestfulmongoblog.demo.repository;

import com.guilong.springbootrestfulmongoblog.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    Post findById(String id);
    List<Post> findByDate();

    @Query("{'title': ?0}")
    List<Post> findByTitle(String title);

    @Query("{'userName': ?0}")
    List<Post> findByUserName(String userName);
}
