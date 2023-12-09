package com.thebasics.blogsapi.viewmodel;

import com.thebasics.blogsapi.entity.BlogPost;

public record BlogMetaDataPostVm(Long id, String createdBy, String updateBy, String title,
                                 String nextBlog,
                                 String previousBlog, String slug, Long cateId, Boolean isShow) {

    public static BlogMetaDataPostVm fromModel(BlogPost p) {
        return new BlogMetaDataPostVm(p.getId(), p.getCreatedBy(), p.getUpdatedBy(), p.getTitle(),
            p.getNextBlog(), p.getPreviousBlog(), p.getSlug(), p.getCategory().getId(),
            p.getIsShow());
    }
}
