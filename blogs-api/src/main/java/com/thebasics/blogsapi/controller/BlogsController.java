package com.thebasics.blogsapi.controller;


import com.thebasics.blogsapi.service.IUserBlogsService;
import com.thebasics.blogsapi.viewmodel.ResVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogsController {

    private final IUserBlogsService service;

    @Autowired
    public BlogsController(IUserBlogsService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public ResponseEntity<ResVm> checkStatus() {
        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), "[USER] Alive"));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<?> getAllBlog(@PathVariable String slug) {
        return this.service.getAllBlogs(slug);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory() {
        return this.service.getAllCategories();
    }

    @GetMapping("/detail/{slug}")
    public ResponseEntity<?> getDetailBlog(@PathVariable String slug) {
        return this.service.getDetailBlog(slug);
    }

}