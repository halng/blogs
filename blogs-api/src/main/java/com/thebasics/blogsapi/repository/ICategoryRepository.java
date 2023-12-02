package com.thebasics.blogsapi.repository;

import com.thebasics.blogsapi.entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    boolean existsBySlug(String slug);
    Optional<Category> findBySlug(String slug);
    List<Category> findByIsShowTrue();
}
