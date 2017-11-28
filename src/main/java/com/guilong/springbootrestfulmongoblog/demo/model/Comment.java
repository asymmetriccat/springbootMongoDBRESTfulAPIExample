package com.guilong.springbootrestfulmongoblog.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Comment {
    @Id
    private ObjectId _id;
    private String body;
    private Date date;
    private String author;
   
    public Comment() {}
    public Comment(ObjectId _id, String body, Date date, String author) {
        this._id = _id;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
