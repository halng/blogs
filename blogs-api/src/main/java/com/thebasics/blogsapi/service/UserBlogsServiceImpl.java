package com.thebasics.blogsapi.service;

import com.thebasics.blogsapi.entity.BlogPost;
import com.thebasics.blogsapi.entity.Category;
import com.thebasics.blogsapi.exceptions.EntityNotFoundException;
import com.thebasics.blogsapi.repository.IBlogContentRepository;
import com.thebasics.blogsapi.repository.IBlogPostRepository;
import com.thebasics.blogsapi.repository.ICategoryRepository;
import com.thebasics.blogsapi.viewmodel.BlogResVm;
import com.thebasics.blogsapi.viewmodel.ResCommon;
import com.thebasics.blogsapi.viewmodel.ResDataVm;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBlogsServiceImpl implements IUserBlogsService {

    private final ICategoryRepository iCategoryRepository;
    private final IBlogPostRepository iBlogPostRepository;
    private final IBlogContentRepository iBlogContentRepository;

    @Override
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = this.iCategoryRepository.findByIsShowTrue();
        List<ResCommon> library = new ArrayList<>();
        List<ResCommon> blogs = new ArrayList<>();

//        for (var obj : categories) {
//            var res = new ResCommon(obj.getName(), obj.getSlug());
//            if (obj.getType().equals(CategoryType.BLOGS)) {
//                blogs.add(res);
//            } else {
//                library.add(res);
//            }
//        }
//
//        var obj1 = new CategoryResVm(CategoryType.BLOGS.name(), blogs);
//        var obj2 = new CategoryResVm(CategoryType.LIBRARY.name(), library);

//        return ResponseEntity.ok(
//            new ResDataVm<>(HttpStatus.OK.value(), "Success", Arrays.asList(obj1, obj2)));
        return null;
    }

    @Override
    public ResponseEntity<?> getAllBlogs(String slug) {
        Category category = this.iCategoryRepository.findBySlug(slug).orElseThrow(
            () -> new EntityNotFoundException("Category %s not found".formatted(slug)));

        Set<BlogPost> blogPosts = category.getBlogPostList();
        List<ResCommon> results = new ArrayList<>();

        for (var blog : blogPosts) {
            if (blog.getIsShow()) {
                results.add(new ResCommon(blog.getTitle(), blog.getSlug()));
            }
        }

        return ResponseEntity.ok(new ResDataVm<>(HttpStatus.OK.value(), "Success", results));
    }

    @Override
    public ResponseEntity<?> getDetailBlog(String slug) {
        BlogPost blogPost = this.iBlogPostRepository.findBySlug(slug)
            .orElseThrow(() -> new EntityNotFoundException("Blog %s not found".formatted(slug)));

        BlogResVm blogResVm = new BlogResVm(blogPost.getCreatedBy(), blogPost.getUpdatedBy(),
            blogPost.getUpdatedTime().toString(), blogPost.getTitle(), blogPost.getNextBlog(),
            blogPost.getPreviousBlog(), blogPost.getSlug(), blogPost.getBlog().getContent());

        return ResponseEntity.ok(blogResVm);
    }
}
