package com.codeup.blogapp.model;


import jakarta.persistence.*;

@Entity
@Table (name = "posts")
public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;









    public Post(){};

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}