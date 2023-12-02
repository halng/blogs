package com.thebasics.blogsapi.viewmodel;

public record BlogMetaDataPostVm(String createdBy, String updateBy,
                                 String title, String nextBlog, String previousBlog, String slug, Long cate_id, Boolean isShow) {

}
