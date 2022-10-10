package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HashTagReposiotry extends JpaRepository<HashTag, Long> {

    public Optional<HashTag> findByName(String name);
}
