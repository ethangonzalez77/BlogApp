package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

//    @GetMapping("/home")
//    @ResponseBody
//    public String hello() {
//        return "homeiessssss";
//    }



    //🍩0.1. Below are some notes for the view aspect (aka Thymeleaf) of MVC, look for 🍩0.2 for the continuation for these notes
    @GetMapping("/")
//    @ResponseBody
    public String welcome() {
        return "home";

        //🍩1. This particular component doesn't have a @ResponseBody annotation
        //🍩2. That's because we are gunna respond with a html file by redirecting the user to that html file that has Thymeleaf.
        //🍩3. So we don't need the @ResponseBody annotation
        //🍩4. look at home.html file for notes that continue
    }




}
