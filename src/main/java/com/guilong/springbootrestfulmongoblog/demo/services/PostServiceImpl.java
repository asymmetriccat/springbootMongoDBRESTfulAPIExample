package com.guilong.springbootrestfulmongoblog.demo.services;

import com.guilong.springbootrestfulmongoblog.demo.model.Post;
import com.guilong.springbootrestfulmongoblog.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    //private List<Post> posts=new ArrayList<>();

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository=postRepository;
    }

   @Override
    public Post getById(String id){

        return postRepository.findById(id);
    }
   @Override
    public List<Post> getLast10Post(){
        List<Post> list = new ArrayList<>();
        list=postRepository.findAll().stream().sorted((a,b)->b.getDate().compareTo(a.getDate())).limit(10).collect(Collectors.toList());
       return list;
    }
   @Override
    public List<Post> getByUserName(String userName){

        return postRepository.findAll().stream().filter(p->p.getAuthor().getUserName().equals(userName)).collect(Collectors.toList());
    }
   @Override
    public List<Post> getByTitle(String title){

        return postRepository.findByTitle(title);
    }
   @Override
    public Post createPost(Post post){

        return postRepository.insert(post);
    }
   @Override
    public void deletePostById(String id){

        Post post =postRepository.findById(id);
        postRepository.delete(post);
    }
   @Override
    public void deleteAll(){
        postRepository.deleteAll();
    }
   @Override
    public Post save(Post post){
        return postRepository.save(post);
    }
}
