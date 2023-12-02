package com.thebasics.blogsapi.viewmodel;

public record BlogResVm(String createdBy, String updateBy, String lastUpdatedTime, String title,
                        String nextBlog, String previousBlog, String slug, String content) {

}
