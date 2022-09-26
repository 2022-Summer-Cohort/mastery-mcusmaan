package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @ManyToOne
    private Topic topic;

    @ManyToMany(mappedBy = "posts")
    private Collection<Hashtag> hashtags;

    @Lob
    private String content;

    protected Post() {
    }

    public Post(String title, Topic topic, String content) {
        this.title = title;
        this.topic = topic;
        this.content = content;
    }

    public Post(String title, Topic topic, String content, String author) {
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getAuthor() {
        return author;
    }


    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (topic != null ? !topic.equals(post.topic) : post.topic != null) return false;
        return content != null ? content.equals(post.content) : post.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 25 * result + (title != null ? title.hashCode() : 0);
        result = 25 * result + (topic != null ? topic.hashCode() : 0);
        result = 25 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
        public void addTopic(Topic topic) {

        }
}
