package com.thebasics.blogsapi.viewmodel;

public record BlogVm(String createdBy, String updateBy, String lastUpdatedTime, String content,
                     String title, String nextBlog, String previousBlog) {

}
