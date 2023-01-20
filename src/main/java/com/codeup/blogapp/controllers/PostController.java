package com.codeup.blogapp.controllers;

import com.codeup.blogapp.model.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class PostController {

//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @ResponseBody
//    public String allPost() {
//        return "This will be a post";
//    }
//
//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String post(@PathVariable int id) {
//        return "This will return an individual post " + id;
//    }
//
//
//
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String createPost () {
//        return "view the form for creating a post ";
//    }


//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String postPost () {
//        return "create a new post ";
//    }








    @GetMapping("/posts")
    public String allPosts (Model model) {

        List<Post> posts = new ArrayList<>();
        posts.add(new Post("TV", "Watch when you need a break."));
        posts.add(new Post("Coffee", "Drink when you feel low."));
        model.addAttribute("allPosts", posts);

        return "posts/Index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {

        Post currentPost = new Post(id, "Car", "Takes us from A to B.");
        model.addAttribute("post", currentPost);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate() {
        return "Form for creating a post!";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "Posts the create a post page!";
    }
















}
