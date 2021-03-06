package com.wonwoo.wonwooblog.category;

import javax.validation.Valid;

import com.wonwoo.wonwooblog.config.Navigation;
import com.wonwoo.wonwooblog.config.Section;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

/**
 * CategoryController
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
@Navigation(Section.CATEGORY)
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String categories(Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        return "pages/blog/category/list";
    }

    @GetMapping("/new")
    public String newCategory(@ModelAttribute CategoryDto categoryDto) {
        return "pages/blog/category/new";
    }

    @GetMapping("/{id}") // @RequestMapping(method = RequestMethod.GET)
    public String findByPost(@PathVariable Long id, Model model) {
        model.addAttribute("categoryDto", categoryService.findOne(id));
        return "pages/blog/category/category";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("categoryDto", categoryService.findOne(id));
        return "pages/blog/category/edit";
    }

    @PostMapping // mapping url 이 없지만 기본 매핑 url(Controller에 매핑된 url)로 매핑됨. 단, list와 다른점은 method type이 다름
    public String createCategory(@ModelAttribute @Valid CategoryDto categoryDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/blog/category/new";
        }
        categoryService.createCategory(new Category(categoryDto.getId(), categoryDto.getName()));
        return "redirect:/categories";
    }

    @PostMapping("/{id}/edit")
    public String modifyCategory(@PathVariable Long id, @ModelAttribute @Valid CategoryDto categoryDto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/blog/category/edit";
        }
        categoryService.updateCategory(new Category(id, categoryDto.getName()));
        return "redirect:/categories/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}