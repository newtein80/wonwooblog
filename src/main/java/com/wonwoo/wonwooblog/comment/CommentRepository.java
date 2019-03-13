package com.wonwoo.wonwooblog.comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CommentRepository
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{

    
}