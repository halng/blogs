package com.thebasics.blogsapi.service;

import com.thebasics.blogsapi.viewmodel.BlogContentPostVm;
import com.thebasics.blogsapi.viewmodel.BlogMetaDataPostVm;
import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IAdminBlogsService {

    ResponseEntity<ResVm> createCategory(CatePostVm data);

    ResponseEntity<ResVm> updateCategory(Long id, CatePostVm data);

    ResponseEntity<ResVm> createBlog(BlogMetaDataPostVm data);

    ResponseEntity<ResVm> updateBlog(Long id, BlogMetaDataPostVm data);

    ResponseEntity<ResVm> createContentBlog(BlogContentPostVm data);

    ResponseEntity<ResVm> updateContentBlog(BlogContentPostVm data);
}
