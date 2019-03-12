package com.wonwoo.wonwooblog.post;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * PostController: 컨트롤러에서 비지니스 로직은 넣지않고 파라미터 체크나 매핑정도만 한다.
 * 대부분 비지니스들은 트랜잭션이 한꺼번에 묶여있어야 하므로 Service에서 하는게 좋다고 생각한다.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}") // @RequestMapping(method = RequestMethod.GET)
    public String findByPost(@PathVariable Long id, Model model) throws NotFoundException {
        Post post = postService.findByIdAndStatus(id, PostStatus.Y);

        if(post == null){
            throw new NotFoundException(id + " <-- Controller not found post.");
        }

        model.addAttribute("post", post);
        return "post/post";
    }

    @GetMapping("/new")
    public String registPost(PostDto postDto) {
        return "post/new";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) throws NotFoundException {

        Post post = postService.findByIdAndStatus(id, PostStatus.Y);

        if(post == null){
            throw new NotFoundException(id + " <-- Controller not found post. Can't update.");
        }
        
        PostDto createPostDto = new PostDto();

        createPostDto.setTitle(post.getTitle());
        createPostDto.setCode(post.getCode());
        createPostDto.setContent(post.getContent());
        createPostDto.setId(id);

        model.addAttribute("editPost", createPostDto);
        return "post/edit";
    }

    @PostMapping
    public String createPost(@ModelAttribute @Valid PostDto createPostItem, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "post/new";
        }

        Post post = new Post(
            createPostItem.getTitle(),
            createPostItem.getContent(),
            createPostItem.getCode(),
            PostStatus.Y
        );

        Post newPost = postService.createPost(post);
        model.addAttribute("post", newPost);

        return "redirect:/posts/" + newPost.getId();
    }

    @PostMapping("/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("editPost") @Valid PostDto updatePostItem, BindingResult bindingResult) throws NotFoundException {

        if(bindingResult.hasErrors()){
            return "post/edit";
        }
        
        postService.updatePost(
            id,
            new Post(
                updatePostItem.getTitle(),
                updatePostItem.getContent(),
                updatePostItem.getCode(),
                PostStatus.Y
            )
        );

        return "redirect:/posts/" + id;
    }

    @PostMapping("{id}/delete")
    public String deletePost(@PathVariable Long id) throws NotFoundException {
        postService.deletePost(id);
        return "redirect:/#/";
        
    }
}