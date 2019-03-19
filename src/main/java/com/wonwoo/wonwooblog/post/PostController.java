package com.wonwoo.wonwooblog.post;

import java.util.List;

import javax.validation.Valid;

import com.wonwoo.wonwooblog.category.Category;
import com.wonwoo.wonwooblog.category.CategoryService;
import com.wonwoo.wonwooblog.comment.CommentDto;
import com.wonwoo.wonwooblog.config.Navigation;
import com.wonwoo.wonwooblog.config.Section;
import com.wonwoo.wonwooblog.exception.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * PostController: 컨트롤러에서 비지니스 로직은 넣지않고 파라미터 체크나 매핑정도만 한다.
 * 대부분 비지니스들은 트랜잭션이 한꺼번에 묶여있어야 하므로 Service에서 하는게 좋다고 생각한다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
@Navigation(Section.POST)
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        List<Category> test = categoryService.findAll();
        // return categoryService.findAll();
        return test;
    }

    @GetMapping("/{id}") // @RequestMapping(method = RequestMethod.GET)
    public String findByPost(@PathVariable Long id, Model model, @ModelAttribute CommentDto commentDto) {
        Post post = postService.findByIdAndStatus(id, PostStatus.Y);

        if(post == null){
            throw new NotFoundException(id + " <-- Controller not found post.");
        }

        model.addAttribute("post", post);
        return "pages/blog/post/post";
    }

    @GetMapping("/new")
    public String registPost(PostDto postDto) {
        // return "post/new";
        return "pages/blog/post/new";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {

        Post post = postService.findByIdAndStatus(id, PostStatus.Y);

        if(post == null){
            throw new NotFoundException(id + " <-- Controller not found post. Can't update.");
        }
        
        PostDto createPostDto = new PostDto();

        createPostDto.setCategoryId(post.getCategory().getId());
        createPostDto.setCategoryName(post.getCategory().getName());

        createPostDto.setTitle(post.getTitle());
        createPostDto.setCode(post.getCode());
        createPostDto.setContent(post.getContent());
        createPostDto.setId(id);

        model.addAttribute("editPost", createPostDto);
        return "pages/blog/post/edit";
    }

    @PostMapping
    public String createPost(@ModelAttribute @Valid PostDto createPost, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "post/new";
        }

        Post post = new Post(
            createPost.getTitle(),
            createPost.getContent(),
            createPost.getCode(),
            PostStatus.Y,
            new Category(createPost.getCategoryId())
        );

        Post newPost = postService.createPost(post);
        model.addAttribute("post", newPost);

        return "redirect:/posts/" + newPost.getId();
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("editPost") @Valid PostDto updatePostItem, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "post/edit";
        }
        
        // post도 comment와 마찬가지로 생성시에 연관관계의 category를 넣어 줬다. 연관관계의 주인만이 읽기, 쓰기가 모두 가능하다. 주인이 아닌 곳에서는 읽기만 가능하다.
        postService.updatePost(
            id,
            new Post(
                updatePostItem.getTitle(),
                updatePostItem.getContent(),
                updatePostItem.getCode(),
                PostStatus.Y,
                new Category(updatePostItem.getCategoryId())
            )
        );

        return "redirect:/posts/" + id;
    }

    @PostMapping("{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/#/";
        
    }
}