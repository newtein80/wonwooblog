package com.wonwoo.wonwooblog.category;

import java.io.Serializable;
// import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.*;

import com.wonwoo.wonwooblog.post.Post;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
// import lombok.Getter; // 위의 것과 뭐가 다른가 ?????
// import lombok.Setter;
import lombok.ToString;

/**
 * Category
 * post와 category 와의 관계는 다대일 관계이다. 반대로도 생각할 수 도 있는데 category 와 post의 관계는 일대다 다.
 * 보통의 db의 경우에는 양방향으로 검색이 가능하다. 예를들어 category기준으로 post를 검색할 수도 있고 post기준으로 category를 검색 할 수 도 있다.
 * 하지만 객체의 경우에는 양방향이라는게 없다. 왜냐하면 객체는 항상 단방향이기 때문이다.
 * 단방향이지만 양방향으로 만들 수 있는데 참조하는 쪽에 연관관계를 한개 더 만들면 가능하다. 하지만 이것은 양방향이라기보다 서로 다른 단방향 관계 2개다.
 */
@Data
@Entity
@ToString(exclude = {"post"})
@EqualsAndHashCode(exclude = {"post"})
public class Category implements Serializable {

    // https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/jpa-primary-key.html
    
    // private static final long serialVersionUID = 7501653724348655218L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime regDate;

    /**
     * 즉시로딩일 경우에는 Category를 가져올때 무조건 post도 가져온다는 의미이고
     * 지연로딩일 경우에는 Category를 가져올때 post는 프록시 객체로 가져오고 만약 post를 사용한다면 그때 쿼리해서 가져온다.
     * 말은 쉽지 실제 모르고 개발하면 쉽지 않다. 영속성과 관련도 많이 있어서.. 특별한 경우가 아니라면 지연로딩을 추천하고 있다.
     */


    @OneToMany(mappedBy="category", fetch=FetchType.LAZY) // mappedBy = 연관관계의 주인, fetch의 경우에는 즉시로딩 과 지연로딩을 설정
    private List<Post> post = new ArrayList<>();

    public Category(){

    }

    public Category(Long id){
        this.id = id;
    }

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }
}