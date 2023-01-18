package com.codeup.blogapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {





    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " add by " + number2 + " is " + (number1 + number2) + "!";
    }


    @RequestMapping(path = "/subtract/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractOne(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " subtract by " + number2 + " is " + (number1 - number2) + "!";
    }


    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyOne(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " multiply by " + number2 + " is " + (number1 * number2) + "!";
    }


    @RequestMapping(path = "/divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divideOne(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " divided by " + number2 + " is " + (number1 / number2) + "!";
    }



}







