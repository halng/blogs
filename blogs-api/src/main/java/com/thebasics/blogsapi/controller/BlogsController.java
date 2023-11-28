package com.thebasics.blogsapi.controller;


import com.thebasics.blogsapi.viewmodel.ResVm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogsController {

    @GetMapping("/status")
    public ResponseEntity<ResVm> checkStatus() {
        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), "[USER] Alive"));
    }
    /** TODO:
     *  - Get all category under category type
     *  - Get all blog by category
     *  - Get detail blog
     */
}