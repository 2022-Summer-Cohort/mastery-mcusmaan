package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private TopicRepository topicRepo;
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;

    public Populator(TopicRepository topicRepo, PostRepository postRepo, HashtagRepository hashtagRepo) {
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hashtag hashtag1 = new Hashtag("#Developer");
        hashtagRepo.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("#appdeveloper");
        hashtagRepo.save(hashtag2);
        Hashtag hashtag3 = new Hashtag("#javaprogramming");
        hashtagRepo.save(hashtag3);
        Hashtag hashtag4 = new Hashtag("#Tech");
        hashtagRepo.save(hashtag4);
        Hashtag hashtag5 = new Hashtag("#Dev");
        hashtagRepo.save(hashtag5);
        Hashtag hashtag6 = new Hashtag("#Future");
        hashtagRepo.save(hashtag6);


        Topic topic1 = new Topic("Learning TDD");
        topicRepo.save(topic1);
        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicRepo.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicRepo.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicRepo.save(topic4);


        Post post1 = new Post("TDD For Fun and Profit", topic1, "Dumbledor", "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", hashtag1, hashtag2, hashtag3);
        postRepo.save(post1);

        Post post4 = new Post("Test the Fear Away", topic4, "Edgar Allen Poe ", "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ", hashtag2, hashtag5, hashtag6);
        postRepo.save(post4);

        Post post3 = new Post("Unit Tests and You", topic3, "MadMax", "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut e", hashtag1, hashtag4, hashtag5, hashtag6);
        postRepo.save(post3);

        Post post2 = new Post("Test the fear Away", topic2, "Liban", "Lorem ipsum dolor sit amet, consectetur dipiscing elit, sed do eiusmod tempor incididunt ut labore et ", hashtag2, hashtag3);
        postRepo.save(post2);
    }
}
