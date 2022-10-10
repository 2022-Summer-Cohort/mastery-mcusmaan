package com.survivingcodingbootcamp.blog.service;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.repository.HashTagReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HashTagStorage {

    private HashTagReposiotry hashTagReposiotry;

    @Autowired
    public HashTagStorage(HashTagReposiotry hashTagReposiotry) {
        this.hashTagReposiotry = hashTagReposiotry;
    }

    public Set<HashTag> getAllHashTags() {
        Set<HashTag> hashTags =  this.hashTagReposiotry.findAll().stream().collect( Collectors.toSet());
            return hashTags;
    }

    public HashTag getHashTabById(Long id) {
        return this.hashTagReposiotry.findById( id ).get();
    }
}
