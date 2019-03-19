package com.wonwoo.wonwooblog.category;

import java.time.LocalDateTime;
import java.util.List;

import com.wonwoo.wonwooblog.exception.NotFoundException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // !!!!!!!!!!!!!!!!!!!!!!!!

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CategoryService
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        category.setRegDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category) {
        // https://stackoverflow.com/questions/49561425/cant-use-findone-in-my-code-with-jparepository
        // http://memo.polypia.net/archives/2900
        Category oldCategory = categoryRepository.findById(category.getId()).get();
        if(oldCategory == null){
            throw new NotFoundException(category.getId() + " not found...");    
        }

        oldCategory.setName(category.getName());
    }

    @Cacheable("blog.category")
    @Transactional(readOnly=true)
    public Page<Category> findAll(Pageable pageable) {
        log.info("blog.category cache");
        return categoryRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
  
    public Category findOne(Long id) {
        return categoryRepository.findById(id).get();
    }
}