package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

    //personal notes

    @Controller//how we tell Spring that this component will handle requests and reponses.
    class HelloController {

        @GetMapping("/hello")//the request that our component will listen for, or in other words respond to
        @ResponseBody//how our component will respond to the request
        public String hello() {
            return "Hello from Spring!";
        }
        









    }










