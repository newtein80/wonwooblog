package com.wonwoo.wonwooblog.index;

import com.wonwoo.wonwooblog.post.PostRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/**
 * IndexController
 * Lombok을 사용하면 생성자도 자동으로 생성할 수 있습니다.
 * @NoArgsConstructor 어노테이션은 파라미터가 없는 기본 생성자를 생성해주고,
 * @AllArgsConstructor 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다.
 * 마지막으로 @RequiredArgsConstructor 어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.
 * 
        @NoArgsConstructor
        @RequiredArgsConstructor
        @AllArgsConstructor
        public class User {
            private Long id;

            @NonNull
            private String username;

            @NonNull
            private String password;

            private int[] scores;
        }

        User user1 = new User();
        User user2 = new User("dale", "1234");
        User user3 = new User(1L, "dale", "1234", null);

 */
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostRepository postRepository;
    /**
     * spring boot의 경우에 resources/templates/ 아래의 경로에는 사용할 view templates 파일들을 넣으면 되고 resources/static 아래에는 정적 파일들을 넣으면 된다.
     * 우리는 thymeleaf라는 view templates을 사용하므로 resources/templates에 html을 넣고 나머지 css나 js, 폰트 경우에는 static아래에 넣으면 된다.
     * org.springframework.data.domain.Pageable
     * 페이징도 처리 해야 하므로 Pageable을 파라미터로 받으면 알아서 페이징을 해준다.
     */
    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        // model.addAttribute("message", "hello");
        model.addAttribute("posts", postRepository.findAll(pageable));
        return "index";
    }
}