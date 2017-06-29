package com.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by student on 6/29/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "signup";
    }

}
