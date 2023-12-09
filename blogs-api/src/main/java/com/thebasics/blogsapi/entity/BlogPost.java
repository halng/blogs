package com.thebasics.blogsapi.entity;

import com.thebasics.blogsapi.viewmodel.BlogMetaDataPostVm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blog_post")
public class BlogPost extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(unique = true)
    private String slug;
    private Boolean isShow;
    private String nextBlog;
    private String previousBlog;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "post")
    private BlogContent blog;
    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    private Category category;

    public boolean equalsWithVm(BlogMetaDataPostVm blogPost) {
        if (blogPost == null) {
            return false;
        }
        return Objects.equals(id, blogPost.id()) && Objects.equals(title, blogPost.title())
            && Objects.equals(slug, blogPost.slug()) && Objects.equals(isShow, blogPost.isShow())
            && Objects.equals(nextBlog, blogPost.nextBlog()) && Objects.equals(previousBlog,
            blogPost.previousBlog()) && Objects.equals(category.getId(), blogPost.cateId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, slug, isShow, nextBlog, previousBlog, category);
    }
}
