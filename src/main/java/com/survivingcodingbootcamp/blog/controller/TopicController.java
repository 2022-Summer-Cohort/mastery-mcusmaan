package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.dto.PostDto;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;

    public TopicController(TopicRepository topicRepo) {

        this.topicRepo = topicRepo;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

    @GetMapping("/add/{id}")
    public String displayFormToCreateNewPost(@PathVariable long id, Model model, PostDto post) {
        Topic topic = topicRepo.findById(id).get();
        post.setTopicId( topic.getId() );
        post.setTopicName( topic.getName() );
        model.addAttribute("topic",topic);
        model.addAttribute("post",post);
        return "single-category-template";
    }
}
