package com.thebasics.blogsapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogsController {

    @GetMapping("/")
    public String getAllBlogs() {
        return "hello world";
    }

    @PostMapping("/")
    public String getAllBlogsV2() {
        return "hello world v2";
    }

}
