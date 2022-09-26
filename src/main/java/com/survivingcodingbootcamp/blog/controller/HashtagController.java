package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class HashtagController {
    private final PostRepository postRepo;
    private final HashtagRepository hashtagRepo;

    public HashtagController(PostRepository postRepo, TopicRepository topicRepo, HashtagRepository hashtagRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/hashtags")
    public String showHashtagsTemplate(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        model.addAttribute("filterName", "All Hashtags");
        return "all-hashtags-template";
    }

    @RequestMapping("/hashtag/{id}")
    public String showHashtagTemplate(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }

    @PostMapping("/post/{id}/addHashtag")
    public String addHashtagToConsole(@PathVariable long id, @RequestParam String hashtag) {
        Optional<Post> tempPost = postRepo.findById(id);
        Optional<Hashtag> hashtagToAdd = hashtagRepo.findByHashTagMIgnoreCase(hashtag);
        if (tempPost.isPresent()) {
            Hashtag tempHashtag;
            if (hashtagToAdd.isPresent()) {
                tempHashtag = hashtagToAdd.get();
            } else {
                tempHashtag = new Hashtag(hashtag);
            }
            tempHashtag.addPost(tempPost.get());
            hashtagRepo.save(tempHashtag);
        }
        return "redirect:/posts/" + id;
    }
}

