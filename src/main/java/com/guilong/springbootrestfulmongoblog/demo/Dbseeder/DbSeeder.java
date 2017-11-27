package com.guilong.springbootrestfulmongoblog.demo.Dbseeder;

import com.guilong.springbootrestfulmongoblog.demo.model.Comment;
import com.guilong.springbootrestfulmongoblog.demo.model.Post;
import com.guilong.springbootrestfulmongoblog.demo.model.User;
import com.guilong.springbootrestfulmongoblog.demo.services.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner{

    private PostService postService;

     public DbSeeder(PostService postService){
         this.postService=postService;
     }

     public void run(String...strings) throws Exception{
         Post post1=new Post(
                 "Spring boot question 1",
                   "In this post, we are going talk about how to use spring boot and mongoDB to build a RESTful api.",
                  new User (new ObjectId(),"Jack", "Li", "jackli", "ilikejava", "8133857101", "guilongli@ymail.com"),
                 Arrays.asList(
                         new Comment(new ObjectId(),"Great post!", new Date(2011, 12, 12 ), "Jerry"),
                         new Comment(new ObjectId(),"Thanks for the information!", new Date(), "Bill"),
                         new Comment(new ObjectId(),"I learned a lot, thanks!", new Date(2017, 1,1), "Steve")

                 ),
                 new Date()

         );

         Post post2=new Post(
                 "Spring boot question 2",
                 "This is for mongDB learning.",
                 new User (new ObjectId(),"Bill", "Gates", "bill", "ilikespring", "8138888888", "bill@ymail.com"),
                 Arrays.asList(
                         new Comment(new ObjectId(),"nice post!!", new Date(2012, 11, 11 ), "Jerry"),
                         new Comment(new ObjectId(),"This is a very usefull post!", new Date(), "guilong"),
                         new Comment(new ObjectId(),"good mongoDB tutorial!", new Date(2016, 5,5), "Clinton")

                 ),
                 new Date(2010, 10,10)

         );
         Post post3=new Post(
                 "Spring boot question 3",
                 "Data in MongoDB has a flexible schema.documents in the same collection. They do not need to have the same set of fields or structure, and common fields in a collection’s documents may hold different types of data.",
                 new User (new ObjectId(),"Trump", "Li", "Trumpli", "ilikemongo", "8139999999", "trump@ymail.com"),
                 Arrays.asList(
                         new Comment(new ObjectId(), "good!", new Date(2013, 11, 12 ), "Jerry"),
                         new Comment(new ObjectId(),"Nice mongodb tutorial!", new Date(), "Bill"),
                         new Comment(new ObjectId(),"Good explanation!", new Date(2016, 2,1), "Steve")

                 ),
                 new Date(2000, 1,2)

         );

         this.postService.deleteAll();

         List<Post> posts=Arrays.asList(post1, post2, post3);
         for(Post post:posts) this.postService.save(post);
     }
}
