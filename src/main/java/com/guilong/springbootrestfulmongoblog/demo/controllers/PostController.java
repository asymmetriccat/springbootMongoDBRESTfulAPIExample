package com.guilong.springbootrestfulmongoblog.demo.controllers;

import com.guilong.springbootrestfulmongoblog.demo.model.Post;
import com.guilong.springbootrestfulmongoblog.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
   @Autowired
   private PostService postService;

   @GetMapping("/latest10Posts")
   public ResponseEntity<List<Post>> ShowLatest10Posts() {
      List<Post> latest10Posts = postService.getLast10Post();
      HttpStatus status= !latest10Posts.isEmpty()? HttpStatus.OK: HttpStatus.NOT_FOUND;
      return new ResponseEntity<List<Post>>(latest10Posts,status);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Post> getById(@PathVariable String id) {
      Post post = postService.getById(id);
      HttpStatus status= post!=null? HttpStatus.OK: HttpStatus.NOT_FOUND;
      return new ResponseEntity<Post>(post,status);
   }
   @GetMapping("/titles/{title}")
   public ResponseEntity<List<Post>> getByTitle(@PathVariable String title) {
      List<Post> list = postService.getByTitle(title);
      HttpStatus status= !list.isEmpty()? HttpStatus.OK: HttpStatus.NOT_FOUND;
      return new ResponseEntity<List<Post>>(list,status);
   }

   @GetMapping("/username/{userName}")
   public ResponseEntity<List<Post>> getByUserName(@PathVariable String userName) {
      List<Post> list = postService.getByUserName(userName);
      HttpStatus status= !list.isEmpty()? HttpStatus.OK: HttpStatus.NOT_FOUND;
      return new ResponseEntity<List<Post>>(list,status);
   }

   @PutMapping
   public void createPost(@RequestBody Post post){
      postService.createPost(post);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deletePost(@PathVariable String id){
      postService.deletePostById(id);

   }

}
