package com.thebasics.blogsapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserBlogsService {

    ResponseEntity<?> getAllCategories();

    ResponseEntity<?> getAllBlogs(String slug);

    ResponseEntity<?> getDetailBlog(String slug);
}
