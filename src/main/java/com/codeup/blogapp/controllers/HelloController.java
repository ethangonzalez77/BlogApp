//package com.codeup.blogapp.controllers;
//
//import ch.qos.logback.core.model.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
////personal notes
//
//    @Controller//how we tell Spring that this component will handle requests and reponses.
//    class HelloController {
//
//        @GetMapping("/hello")//the request that our component will listen for, or in other words respond to
//        @ResponseBody//how our component will respond to the request
//        public String hello() {
//            return "Hello from Spring!";
//        }
//
//
//        @GetMapping("/hello/{name}")//🍔1.the parameter {name} is set up in the url
//        @ResponseBody
//        public String sayHello(@PathVariable String name) {//🍔2. this method has the parameter set up as it usually is however, this time the @PathVariable is added so that the parameter in this method is connected to the parameter in url, also each parameter needs the @PathVariable annotation
//            return "Hello " + name + "!";
//
//            //@RequestMapping annotation
//            //@GetMapping
//
//            //🥪1.Both are similar, however @RequestMapping annotation, which is just the longer version of @GetMapping
//
//        }
//
//
//        @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//        @ResponseBody
//        public String addOne(@PathVariable int number) {
//            return number + " plus one is " + (number + 1) + "!";
//
//            //🥪2.Of course this same exact method can be done by using @GetMapping
//        }
//
//
//        @GetMapping("/increment/{number}")
//        @ResponseBody
//        public String multiplyOne(@PathVariable int num) {
//            return num + " * 5 = " + (num * 5);
//
//            //🥪3. Here is a simalar method like the addOne(), however this one multiplies and its able to accomplish the same output as addOne() using the @GetMapping
//        }
//
//
//        //🍩0.2. Below are some notes for the view aspect (aka Thymeleaf) of MVC. how we pass data from our controller to the view
//
////        @GetMapping("/hello/{name}")
////        public String sayHello(@PathVariable String name, Model model) {
////            model.addAttribute("name", name);
////            return "hello";//return this html.file
////
////            //Notice this component doesn't have the ResponseBody annotation
////
////            //🍩0.3 check hello.html this is how we pass data to our "views" aka our html that has Thymeleaf
////
////        }
////
////
////        //Getting Data from Views
////
////        @GetMapping("/join")
////        public String showJoinForm() {
////            return "join";
////        }
////
////        @PostMapping("/join")//retrieving info/data from the html
////        public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
////            model.addAttribute("cohort", "Welcome to " + cohort + "!");
////            return "join";
////        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
