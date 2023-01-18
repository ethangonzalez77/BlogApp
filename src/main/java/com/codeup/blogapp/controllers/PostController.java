package com.codeup.blogapp.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String allPost() {
        return "This will be a post";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String post(@PathVariable int id) {
        return "This will return an individual post " + id;
    }

//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String post(@PathVariable int id) {
//        return "This will return an individual post " + id;
//    }




}
