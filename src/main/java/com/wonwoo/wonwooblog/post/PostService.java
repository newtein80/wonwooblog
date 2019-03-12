package com.wonwoo.wonwooblog.post;

import java.time.LocalDateTime;

import com.wonwoo.wonwooblog.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * PostService
 */
@Service
@Transactional
@RequiredArgsConstructor // private final 변수의 에러가 사라짐 ?????
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        post.setRegDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post oldPost = postRepository.findByIdAndStatus(id, PostStatus.Y);

        if(oldPost == null){
            throw new NotFoundException(id + " not found ! Can't Update !");
        }

        oldPost.setContent(post.getContent());
        oldPost.setCode(post.getCode());
        oldPost.setTitle(post.getTitle());

        /**
         * 실제 update 하는 로직이 존재하지 않는다.
         * JPA 의 영속성과 관련있음 ?????
         * Transaction 범위에서는 영속상태의 객체를 만들수 있다.
         * 일단 이것만 기억하자.
         * 영속상태인 객체가 변경되고 트랜잭션이 끝나면 변경된 객체의 속성을 감지하여 update 쿼리를 날린다.
         * 이것을 변경감지라고 한다. 
         */

        return oldPost;
    }

    public void deletePost(Long id) {
        Post oldPost = postRepository.findByIdAndStatus(id, PostStatus.Y);

        if(oldPost == null){
            throw new NotFoundException(id + " not found ! Can't Delete !");
        }

        // remove 하지 않는다.
        oldPost.setStatus(PostStatus.N);
    }

    @Transactional(readOnly=true)
    public Post findByIdAndStatus(Long id, PostStatus status) {
        Post post = postRepository.findByIdAndStatus(id, status);

        if(post == null){
            throw new NotFoundException(id + " not found ! Can't Search !");
        }

        return post;
    }

}