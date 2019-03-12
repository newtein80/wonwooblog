package com.wonwoo.wonwooblog.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 */
public interface PostRepository extends JpaRepository<Post, Long>{

    Post findByIdAndStatus(Long id, PostStatus status);
}