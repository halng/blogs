package com.thebasics.blogsapi.service;

import com.thebasics.blogsapi.entity.BlogContent;
import com.thebasics.blogsapi.entity.BlogPost;
import com.thebasics.blogsapi.entity.Category;
import com.thebasics.blogsapi.exceptions.BadRequestException;
import com.thebasics.blogsapi.exceptions.EntityNotFoundException;
import com.thebasics.blogsapi.repository.IBlogContentRepository;
import com.thebasics.blogsapi.repository.IBlogPostRepository;
import com.thebasics.blogsapi.repository.ICategoryRepository;
import com.thebasics.blogsapi.viewmodel.BlogContentPostVm;
import com.thebasics.blogsapi.viewmodel.BlogMetaDataPostVm;
import com.thebasics.blogsapi.viewmodel.CatePostVm;
import com.thebasics.blogsapi.viewmodel.ResVm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminBlogsServiceImpl implements IAdminBlogsService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminBlogsServiceImpl.class);

    private final ICategoryRepository iCategoryRepository;
    private final IBlogPostRepository iBlogPostRepository;
    private final IBlogContentRepository iBlogContentRepository;

    private BlogPost findBlogById(Long id) {
        return this.iBlogPostRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Blog with id: %d doesn't exists".formatted(id)));
    }

    private Category findCategoryById(Long id) {
        return this.iCategoryRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Category with id: %d doesn't exists".formatted(id)));
    }


    @Override
    public ResponseEntity<ResVm> createCategory(CatePostVm data) {
        LOG.info("Receive request to create new category with " + data.toString());

        if (this.iCategoryRepository.existsBySlug(data.slug())) {
            throw new BadRequestException(
                "Category: %s Already Exits.".formatted(data.displayName()));
        }

        Category newCate = this.iCategoryRepository.save(data.toModel());

        CatePostVm res = new CatePostVm(newCate.getId(), newCate.getName(), newCate.getSlug(),
            newCate.getType().name().toLowerCase(), newCate.getIsShow(), newCate.getDisplayName());
        return ResponseEntity.ok(new ResVm(HttpStatus.CREATED.value(), res));
    }

    @Override
    public ResponseEntity<ResVm> updateCategory(Long id, CatePostVm data) {
        LOG.info("Receive request to update category" + id + " with " + data.toString());

        Category cate = this.findCategoryById(id);

        if (!cate.getSlug().equals(data.slug()) && this.iCategoryRepository.existsBySlug(
            data.slug())) {
            throw new BadRequestException(
                "Category with slug: %s already exists".formatted(data.slug()));
        }

        cate.setName(data.name());
        cate.setSlug(data.slug());
        cate.setDisplayName(data.displayName());
        cate.setIsShow(data.isShow());

        Category updatedCate = this.iCategoryRepository.save(cate);

        CatePostVm res = new CatePostVm(updatedCate.getId(), updatedCate.getName(),
            updatedCate.getSlug(), updatedCate.getType().name().toLowerCase(),
            updatedCate.getIsShow(), updatedCate.getDisplayName());
        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), res));
    }

    public String getValidSlug(String originSlug) {
        if (StringUtils.isNotEmpty(originSlug) && StringUtils.isNotBlank(originSlug)) {
            if (this.iBlogPostRepository.existsBySlug(originSlug)) {
                return originSlug;
            } else {
                throw new EntityNotFoundException(
                    "Blog with slug %s not found".formatted(originSlug));
            }
        }
        return "";
    }

    @Override
    public ResponseEntity<ResVm> createBlog(BlogMetaDataPostVm data) {
        LOG.info("Receive request to create new blog with " + data.toString());

        BlogPost blogPost = BlogPost.builder().isShow(data.isShow()).title(data.title())
            .slug(data.slug()).build();

        blogPost.setCategory(findCategoryById(data.cateId()));
        blogPost.setCreatedBy(data.createdBy());
        blogPost.setUpdatedBy(data.updateBy());
        blogPost.setNextBlog(getValidSlug(data.nextBlog()));
        blogPost.setPreviousBlog(getValidSlug(data.previousBlog()));

        BlogPost newBlogPost = this.iBlogPostRepository.save(blogPost);
        BlogMetaDataPostVm metaDataPostVm = BlogMetaDataPostVm.fromModel(newBlogPost);

        return ResponseEntity.ok(new ResVm(HttpStatus.CREATED.value(), metaDataPostVm));
    }

    @Override
    public ResponseEntity<ResVm> updateBlog(Long id, BlogMetaDataPostVm data) {
        LOG.info("Receive request to update blog" + id + " with " + data.toString());

        BlogPost blogPost = this.findBlogById(id);

        if (!data.slug().equals(blogPost.getSlug()) && this.iBlogPostRepository.existsBySlug(
            data.slug())) {
            throw new BadRequestException(
                "Blog with slug: %s already exists".formatted(data.slug()));
        }

        blogPost.setTitle(data.title());
        blogPost.setSlug(data.slug());
        blogPost.setIsShow(data.isShow());
        blogPost.setNextBlog(getValidSlug(data.nextBlog()));
        blogPost.setPreviousBlog(getValidSlug(data.previousBlog()));
        blogPost.setCategory(findCategoryById(data.cateId()));

        BlogPost newBlogPost = this.iBlogPostRepository.save(blogPost);
        BlogMetaDataPostVm metaDataPostVm = BlogMetaDataPostVm.fromModel(newBlogPost);

        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), metaDataPostVm));
    }


    @Override
    public ResponseEntity<ResVm> createContentBlog(BlogContentPostVm data) {
        LOG.info("Receive request to create blog content " + data.id());

        BlogPost blogPost = this.findBlogById(data.id());

        BlogContent blogContent = BlogContent.builder().content(data.content()).post(blogPost)
            .build();

        blogContent.setUpdatedBy(data.updatedBy());
        blogContent.setCreatedBy(data.createdBy());

        BlogContent newBlog = this.iBlogContentRepository.save(blogContent);

        blogPost.setBlog(newBlog);
        this.iBlogPostRepository.save(blogPost);

        return ResponseEntity.ok(new ResVm(HttpStatus.CREATED.value(), "Create new success"));
    }

    @Override
    public ResponseEntity<ResVm> updateContentBlog(BlogContentPostVm data) {
        LOG.info("Receive request to update blog content " + data.id());

        BlogPost blogPost = this.findBlogById(data.id());
        BlogContent content = blogPost.getBlog();
        content.setContent(data.content());
        content.setUpdatedBy(data.updatedBy());
        this.iBlogContentRepository.save(content);

        return ResponseEntity.ok(new ResVm(HttpStatus.OK.value(), "Update success"));
    }
}
