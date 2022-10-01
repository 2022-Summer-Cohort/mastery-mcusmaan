package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
@RequestMapping("/")
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;

    public HashtagController(HashtagRepository hashtagRepo,PostRepository postRepo) {
        this.hashtagRepo = hashtagRepo;
        this.postRepo=postRepo;
    }

    @RequestMapping("/hashtags")
    public String displayHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "all-hashtags-template";

    }

    @RequestMapping("/hashtags/{id}")
    public String displayHashtagById(Model model, @PathVariable long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }

    @PostMapping("/post/{id}/addHashtag")
    public String addHashtagToPost(@PathVariable long id, @RequestParam String hashtag) {
        Post post = postRepo.findById(id).get();
        Optional<Hashtag> hashtagOptional =  hashtagRepo.findByNameIgnoreCase(hashtag);

        if (hashtagOptional.isPresent()) {
            if (!post.getHashtags().contains(hashtagOptional.get())) {
                post.addHashtag(hashtagOptional.get());
            }
        }
        else {
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            post.addHashtag(hashtag1);

        }
        postRepo.save(post);
        return "redirect:/posts/" + id;

    }

}


