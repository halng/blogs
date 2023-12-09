package com.thebasics.blogsapi.entity;

import com.thebasics.blogsapi.viewmodel.CatePostVm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String slug;
    private String parent;
    private Boolean isShow;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<BlogPost> blogPostList;

    public boolean equalsWithVm(CatePostVm o) {
        if (o == null) {
            return false;
        }
        return Objects.equals(id, o.id()) && Objects.equals(name, o.name())
            && Objects.equals(slug, o.slug()) && Objects.equals(parent,
            o.parent()) && Objects.equals(isShow, o.isShow());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, parent, isShow);
    }
}
