package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    public String hashTagM;

    @ManyToMany
    private Collection<Post> posts;

    public Hashtag(String hashTagM, Post... posts) {
        this.hashTagM = hashTagM;
        this.posts = new ArrayList<>();

    }

    private Hashtag(){

    }

    public long getId() {
        return id;
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public String getHashTagM() {
        return hashTagM;
    }

}
