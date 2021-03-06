package com.wonwoo.wonwooblog.index;

import com.wonwoo.wonwooblog.config.Navigation;
import com.wonwoo.wonwooblog.config.Section;
import com.wonwoo.wonwooblog.post.Post;
import com.wonwoo.wonwooblog.post.PostRepository;
import com.wonwoo.wonwooblog.post.PostStatus;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

/**
 * IndexController
 */
@Controller
@RequiredArgsConstructor
@Navigation(Section.HOME)
public class IndexController {

    private final PostRepository postRepository;

    /**
     * spring boot의 경우에 resources/templates/ 아래의 경로에는 사용할 view templates 파일들을 넣으면 되고
     * resources/static 아래에는 정적 파일들을 넣으면 된다. 우리는 thymeleaf라는 view templates을 사용하므로
     * resources/templates에 html을 넣고 나머지 css나 js, 폰트 경우에는 static아래에 넣으면 된다.
     * org.springframework.data.domain.Pageable 페이징도 처리 해야 하므로 Pageable을 파라미터로 받으면
     * 알아서 페이징을 해준다.
     */
    // @GetMapping("/")
    // public String home(Model model, Pageable pageable) {
    // // model.addAttribute("message", "hello");
    // model.addAttribute("posts", postRepository.findAll(pageable));
    // return "index";
    // }
    @GetMapping("/")
    public String home(@RequestParam(required = false) String q, Model model, @PageableDefault(size = 5, sort = "regDate", direction = Direction.DESC) Pageable pageable) {
        
        // Example<Post> post = Example.of(
        //     new Post(q, PostStatus.Y),
        //     matching().withMatcher("title", ExampleMatcher.GenericPropertyMatcher::contains)
        // );
        Example<Post> post = Example.of(
            new Post(q, PostStatus.Y),
            ExampleMatcher.matching().withMatcher("title", ExampleMatcher.GenericPropertyMatcher::contains)
        );

        model.addAttribute("posts", postRepository.findAll(post, pageable));
        // return "index";
        return "pages/blog/post/index";
    }
}