package com.codegym.controllers;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"", "/home"})
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute User user, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "home";
        }
        String warning = this.userService.save(user);
        if (warning.contains("complete")) {
            redirectAttributes.addFlashAttribute("message", "Sign up complete !");
            return "redirect:/home";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("warning", warning);
            return "home";
        }
    }
}
