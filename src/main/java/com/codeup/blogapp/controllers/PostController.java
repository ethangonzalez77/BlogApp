package com.codeup.blogapp.controllers;

import com.codeup.blogapp.model.Post;
import com.codeup.blogapp.model.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {


    private final PostRepository postDao;//creating a new object
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

//    @GetMapping(path = "/posts/{id}")
//    public String post(Model model){
//        Post post1 = new Post("post #1 title", "post #1 body");
//        model.addAttribute("title", "Individual Post");
//        model.addAttribute("postTitle", post1.getTitle());
//        model.addAttribute("postBody", post1.getBody());
//        model.addAttribute("userEmail", post1.getEmail());
//        return "posts/show";
//    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
//        model.addAttribute("title", "Individual Post");
//        model.addAttribute("post", postDao.findById(id));
        Post post = postDao.getReferenceById(id);

        User user = userDao.getReferenceById(post.getUser().getId());
        model.addAttribute("postTitle", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        model.addAttribute("postID", post.getId());
        model.addAttribute("userEmail", user.getEmail());

        return "posts/show";
    }



//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
////    @ResponseBody
//    public String getCreate(){
//
//        return "posts/create";
//    }

    @GetMapping("/posts/create")
    public String getForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = userDao.getReferenceById(1L);
        post.setUser(user);

        emailService.preparedAndSend(post, "testing blog post" + post.getTitle(), "body of post" + post.getBody());
        postDao.save(post);

        return "redirect:/posts";
    }



    @GetMapping(path = "/posts/{id}/edit")
    public String getEdit(@PathVariable long id, Model model){
//        model.addAttribute("title", "Edit Post");
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping(path = "/posts/{id}/edit")
    public String postEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body){
        Post post = postDao.getReferenceById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }


}
