package com.wonwoo.wonwooblog.category;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // !!!!!!!!!!!!!!!!!!!!!!!!

import lombok.RequiredArgsConstructor;

/**
 * CategoryService
 */
@Service
@Transactional
@RequiredArgsConstructor
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
        if(oldCategory != null){
            oldCategory.setName(category.getName());
        }
    }

    @Transactional(readOnly=true)
    public Page<Category> findAll(Pageable pageable) {
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