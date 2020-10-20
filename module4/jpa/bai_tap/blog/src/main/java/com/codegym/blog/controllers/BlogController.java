package com.codegym.blog.controllers;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "");
        model.addAttribute("blogList", blogService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        try {
            this.blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "Create Complete !");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Create Failed !");
        }
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String viewBlog(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.edit(blog);
        redirectAttributes.addFlashAttribute("message", "Update Complete !");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam String id, RedirectAttributes redirectAttributes) {
        this.blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Complete !");
        return "redirect:/";
    }
}
