package com.thebasics.blogsapi.service;

import com.thebasics.blogsapi.entity.Category;
import com.thebasics.blogsapi.exceptions.BadRequestException;
import com.thebasics.blogsapi.exceptions.EntityNotFoundException;
import com.thebasics.blogsapi.repository.IBlogContentRepository;
import com.thebasics.blogsapi.repository.IBlogPostRepository;
import com.thebasics.blogsapi.repository.ICategoryRepository;
import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import java.lang.reflect.Field;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminBlogsServiceImpl implements IAdminBlogsService {

    private final ICategoryRepository iCategoryRepository;
    private final IBlogPostRepository iBlogPostRepository;
    private final IBlogContentRepository iBlogContentRepository;

    /**
     * Generic method for create new entity
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T, K> ResponseEntity<ResVm> create(T data, Function<T, K> createFunc) {
        K obj = createFunc.apply(data);
        try {
            Field field = obj.getClass().getDeclaredField("name");
            field.setAccessible(true);
            String value = (String) field.get(obj);
            return ResponseEntity.ok(new ResVm(HttpStatus.CREATED.value(),
                "Create new %s: %s successfully".formatted(obj.getClass(), value)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T, K> ResponseEntity<ResVm> update(T data, Function<T, K> updateFunc) {
        K obj = updateFunc.apply(data);
        try {
            Field field = obj.getClass().getDeclaredField("name");
            field.setAccessible(true);
            String value = (String) field.get(obj);
            return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(),
                "Update %s: %s successfully".formatted(obj.getClass(), value)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ResponseEntity<ResVm> createCategory(CatePostVm data) {
        if (this.iCategoryRepository.existsBySlug(data.slug())) {
            throw new BadRequestException(
                "Category: %s Already Exits.".formatted(data.displayName()));
        }
        return this.create(data.toModel(), this.iCategoryRepository::save);
    }

    @Override
    public ResponseEntity<ResVm> updateCategory(Long id, CatePostVm data) {
        Category cate = this.iCategoryRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Category with id: %d not found".formatted(id)));

        if (!cate.getSlug().equals(data.slug()) && this.iCategoryRepository.existsBySlug(
            data.slug())) {
            throw new BadRequestException(
                "Category with slug: %s already exists".formatted(data.slug()));
        }

        Category newCate = data.toModel();
        newCate.setId(id);
        newCate.setCreatedTime(cate.getCreatedTime());
        newCate.setCreatedBy(cate.getCreatedBy());
        return this.update(newCate, this.iCategoryRepository::save);
    }

    @Override
    public ResponseEntity<ResVm> updateStatusCategory(Long id) {
        Category cate = this.iCategoryRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Category with id: %d not found".formatted(id)));
        cate.setIsShow(!cate.getIsShow());
        return this.update(cate, this.iCategoryRepository::save);
    }
}
