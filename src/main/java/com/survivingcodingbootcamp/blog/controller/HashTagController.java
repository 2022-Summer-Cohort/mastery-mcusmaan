package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.service.HashTagStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Set;

@Controller
@RequestMapping("/hashtags")
public class HashTagController {

    private HashTagStorage hashTagStorage;

    @Autowired
    public HashTagController(HashTagStorage hashTagStorage) {
        this.hashTagStorage = hashTagStorage;
    }

    @GetMapping("/")
    public ModelAndView loadAllHashTags(ModelAndView view) {
        Set<HashTag> hashTagSet = this.hashTagStorage.getAllHashTags( );
        view.addObject( "hashTagSet", hashTagSet );
        view.setViewName( "hashtag/all-hashtag-template" );
        return view;
    }
    @GetMapping("/{id}")
    public String displayHashTag(Model model, @PathVariable Long id){
       HashTag hashTag =  hashTagStorage.getHashTabById(id);
        model.addAttribute("hashTag", hashTag);
        return   "hashtag/single-hashtag-template";
    }

}
