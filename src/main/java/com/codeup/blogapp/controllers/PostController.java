package com.codeup.blogapp.controllers;

import com.codeup.blogapp.model.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {


    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
        //dependency injection
    }






    @GetMapping("/posts")
    public String allPosts(Model model){
//        ArrayList<Post> all = new ArrayList<>(2);
//        Post post1 = new Post("post #1 title", "post #1 body");
//        Post post2 = new Post("post #2 title", "post #2 body");
//        all.add(post1);
//        all.add(post2);
//        model.addAttribute("title", "All Posts");
//        model.addAttribute("allPosts", all);

        model.addAttribute("posts", postDao.findAll());


        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String post(Model model){
        Post post1 = new Post("post #1 title", "post #1 body");
        model.addAttribute("title", "Individual Post");
        model.addAttribute("postTitle", post1.getTitle());
        model.addAttribute("postBody", post1.getBody());
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
    public String getCreate(){

        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        postDao.save(new Post(title, body));
        return "redirect:/posts";
    }
}
