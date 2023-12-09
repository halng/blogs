package com.thebasics.blogsapi.viewmodel;

import com.thebasics.blogsapi.entity.Category;

public record CatePostVm(Long id, String name, String slug, Boolean isShow,
                         String parent) {

    public Category toModel() {
        return Category.builder().name(name).slug(slug).parent(parent).isShow(isShow).build();
    }
}
