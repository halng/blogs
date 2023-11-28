package com.thebasics.blogsapi.controller;


import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin-blogger")
public class BlogsAdminController {

    /**
     * Handle category: - Create new category - Update category name/type - Disable category
     */
    @PostMapping("/categories")
    public ResponseEntity<ResVm> createNewCategory(@RequestBody CatePostVm catePostVm) {
        return null;
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<ResVm> updateCategory(@RequestBody CatePostVm catePostVm,
        @PathVariable String id) {
        return null;
    }

    @PatchMapping("/categories/{id}")
    public ResponseEntity<ResVm> updateStatusCategory(@PathVariable String id) {
        return null;
    }

    /**
     * Handle blog post: - Create new blog - Update content/title/slug - Disable blog
     */

    @PostMapping("/blogs")
    public ResponseEntity<ResVm> createNewBlog(@RequestBody CatePostVm catePostVm) {
        return null;
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<ResVm> updateBlog(@RequestBody CatePostVm catePostVm,
        @PathVariable String id) {
        return null;
    }

    @PatchMapping("/blogs/{id}")
    public ResponseEntity<ResVm> updateStatusBlog(@PathVariable String id) {
        return null;
    }

    @GetMapping("/status")
    public ResponseEntity<ResVm> checkStatus() {
        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), "[ADMIN] Alive"));
    }
}
