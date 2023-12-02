package com.thebasics.blogsapi.viewmodel;

import com.thebasics.blogsapi.entity.Category;
import com.thebasics.blogsapi.entity.CategoryType;

public record CatePostVm(Long id, String name, String slug, String prefix, Boolean isShow,
                         String displayName) {

    public Category toModel() {
        CategoryType type = prefix.equals("blogs") ? CategoryType.BLOGS : CategoryType.LIBRARY;
        return Category.builder().name(name).slug(slug).displayName(displayName).isShow(isShow)
            .type(type).build();
    }
}
