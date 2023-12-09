package com.thebasics.blogsapi.controller;


import com.thebasics.blogsapi.service.IAdminBlogsService;
import com.thebasics.blogsapi.viewmodel.BlogContentPostVm;
import com.thebasics.blogsapi.viewmodel.BlogMetaDataPostVm;
import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final IAdminBlogsService service;

    @Autowired
    public BlogsAdminController(IAdminBlogsService service) {
        this.service = service;
    }

    @PostMapping("/categories")
    public ResponseEntity<ResVm> createNewCategory(@RequestBody CatePostVm catePostVm) {
        return this.service.createCategory(catePostVm);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<ResVm> updateCategory(@RequestBody CatePostVm catePostVm,
        @PathVariable Long id) {
        return this.service.updateCategory(id, catePostVm);
    }

    /**
     * Handle blog post: - Create new blog - Update content/title/slug - Disable blog
     */

    @PostMapping("/blogs")
    public ResponseEntity<ResVm> createNewBlog(@RequestBody BlogMetaDataPostVm data) {
        return this.service.createBlog(data);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<ResVm> updateBlogMetadata(@RequestBody BlogMetaDataPostVm data,
        @PathVariable Long id) {
        return this.service.updateBlog(id, data);
    }

    /**
     * Handle blog content
     */

    @PostMapping("/blogs-content")
    public ResponseEntity<ResVm> createContentBlog(@RequestBody BlogContentPostVm data) {
        return this.service.createContentBlog(data);
    }

    @PutMapping("/blogs-content")
    public ResponseEntity<ResVm> updateContentBlog(@RequestBody BlogContentPostVm data) {
        return this.service.updateContentBlog(data);
    }

    @GetMapping("/status")
    public ResponseEntity<ResVm> checkStatus() {
        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), "[ADMIN] Alive"));
    }

    @PostMapping("/initialize/{type}")
    public ResponseEntity<ResVm> initializeData(@RequestBody Object data, @PathVariable String type)
        throws IOException {
        return this.service.initialize(data, type);
    }
}
