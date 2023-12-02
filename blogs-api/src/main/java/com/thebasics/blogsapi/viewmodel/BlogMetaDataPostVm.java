package com.thebasics.blogsapi.viewmodel;

import com.thebasics.blogsapi.entity.BlogPost;

public record BlogMetaDataPostVm(String createdBy, String updateBy, String lastUpdatedTime,
                                 String title, String nextBlog, String previousBlog, String slug, Long cate_id, Boolean isShow) {

}
