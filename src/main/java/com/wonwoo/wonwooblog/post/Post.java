package com.wonwoo.wonwooblog.post;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.wonwoo.wonwooblog.category.Category;
import com.wonwoo.wonwooblog.comment.Comment;

import lombok.Data;

/**
 * Post
 */
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String content;

    @Lob
    private String code;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    private LocalDateTime regDate;

    /**
     * fetch = FetchType.LAZY 일 경우에는 지연로딩을 한다고 했다.
     * 지연로딩은 해당 프로퍼티가 사용될 때 실제 쿼리를 날린다.
     * 하지만 조건이 있는데 트랜잭션 안에서만 그게 가능하다.
     * 트랜잭션 안에서는 마음껏 사용해도 되지만 트랜잭션 밖에서 사용하면 에러가 발생한다.
     * 처음 jpa를 사용하면 자주 나오는 exception인 lazyinitializationexception이다.
     * 이방법을 해결하기 위한것은 opensessioninview 이하 osiv 이라는 것인데 이거 또한 설명할 양이 꽤 된다.
     * 간단하게 설명하자면 view까지 영속성을 확장 한다는 의미이다.
     * 하지만 여기서 중요한것은 확장을 한다고 해도 트랜잭션안에서만 변경이 가능하다.
     * 우리는 아무 설정도 하지 않았는데 lazyinitializationexception이 나오지 않았다.
     * 그것은 기본적으로 Spring boot는 opensessioninview를 사용하고 있다. 그래서 에러가 나오지 않았던 것이다.
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy="post", fetch=FetchType.LAZY) // One 의 대상이 되는 객체의 이름 ?????
    private List<Comment> comments;

    public Post(){

    }

    public Post(Long id){
        this.id = id;
    }

    public Post(String title, PostStatus status){
        this.title = title;
        this.status = status;
    }

    public Post(Long id, String title, String content, String code, PostStatus status){
        this.id = id;
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
    }

    public Post(String title, String content, String code, PostStatus status){
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
    }
    
    public Post(String title, String content, String code, PostStatus status, Category category){
        this.title = title;
        this.content = content;
        this.code = code;
        this.status = status;
        this.category = category;
    }
}