package com.thebasics.blogsapi.viewmodel;

/**
 * @param id:        blog metadata id
 * @param content:   content under readme syntax
 * @param createdBy: create user
 * @param updatedBy: update user
 */
public record BlogContentPostVm(Long id, String content, String createdBy, String updatedBy) {

}
