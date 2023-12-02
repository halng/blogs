package com.thebasics.blogsapi.service;

import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IAdminBlogsService {

    ResponseEntity<ResVm> createCategory(CatePostVm data);

    ResponseEntity<ResVm> updateCategory(Long id, CatePostVm data);

    ResponseEntity<ResVm> updateStatusCategory(Long id);
}
