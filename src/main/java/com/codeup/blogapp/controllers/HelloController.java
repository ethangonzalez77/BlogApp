package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

    //personal notes

    @Controller//how we tell Spring that this component will handle requests and reponses.
    class HelloController {

        @GetMapping("/hello")//the request that our component will listen for, or in other words respond to
        @ResponseBody//how our component will respond to the request
        public String hello() {
            return "Hello from Spring!";
        }


        @GetMapping("/hello/{name}")//🍔1.the parameter {name} is set up in the url
        @ResponseBody
        public String sayHello(@PathVariable String name) {//🍔2. this method has the parameter set up as it usually is however, this time the @PathVariable is added so that the parameter in this method is connected to the parameter in url, also each parameter needs the @PathVariable annotation
            return "Hello " + name + "!";
        }









    }










