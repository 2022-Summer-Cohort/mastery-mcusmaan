package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.dto.PostDto;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashTagReposiotry;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;

    private TopicRepository topicRepository;

    private HashTagReposiotry hashTagReposiotry;

    @Autowired
    public PostController(PostRepository postRepo, TopicRepository topicRepository, HashTagReposiotry hashTagReposiotry ) {
        this.postRepo = postRepo;
        this.topicRepository = topicRepository;
        this.hashTagReposiotry = hashTagReposiotry;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        com.survivingcodingbootcamp.blog.model.Post post = postRepo.findById( id).get();
        model.addAttribute("post", post);
        return "single-post-template";
    }

    @PostMapping("/{id}")
    public String addHashTag(Model model,@PathVariable long id, com.survivingcodingbootcamp.blog.model.Post currentPost ){
        Post post = postRepo.findById( id).get();
        HashTag  hashTag =   this.hashTagReposiotry.findByName( currentPost.getHashTagName() ).orElse( new HashTag( currentPost.getHashTagName() ) );
        post.getHashTags().add( hashTag );
        hashTag.getPosts().add( post );
        this.postRepo.save( post );

        model.addAttribute("post", post);
        return "single-post-template";
    }


    @PostMapping("/create")
    public String displayCreatePostForm(Model model, PostDto postdto){
        Topic topic = this.topicRepository.findById( postdto.getTopicId() ).get();

        Post post = new Post(postdto.getTitle(), topic, postdto.getContent(), postdto.getAuthor());
        topic.getPosts().add( post );
        this.postRepo.save( post );
        model.addAttribute("post", post);
        return "single-post-template";
    }

}
