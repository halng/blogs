package com.thebasics.blogsapi.entity;

import com.thebasics.blogsapi.viewmodel.BlogContentPostVm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "blog_content")
public class BlogContent extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", length = 60000)
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "slug", referencedColumnName = "slug")
    private BlogPost post;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        BlogContentPostVm that = (BlogContentPostVm) o;
        return Objects.equals(id, that.id()) && Objects.equals(content, that.content());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, post);
    }
}
