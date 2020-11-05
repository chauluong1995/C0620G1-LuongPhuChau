package com.codegym.controlles;

import com.codegym.entity.employee.AppUser;
import com.codegym.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = "userLogin")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping({"", "/login"})
    public String goLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("appRoleList", this.userDetailsService.allAppRole());
        model.addAttribute("newUser", new AppUser());
        return "register";
    }

    @PostMapping("/registerNew")
    public String registerNew(@ModelAttribute AppUser appUser, @RequestParam Long appRoleId, RedirectAttributes redirectAttributes) {
        boolean check = true;
        List<AppUser> appUserList = this.userDetailsService.allAppUser();
        for (AppUser appUserExist : appUserList) {
            if (appUser.getUserName().equals(appUserExist.getUserName())) {
                check = false;
                break;
            }
        }
        if (check) {
            appUser.setEncrytedPassword(this.bCryptPasswordEncoder.encode(appUser.getEncrytedPassword()));
            appUser.setUserId((long) (Math.random() * 1000));
            this.userDetailsService.saveNewUser(appUser);
            this.userDetailsService.saveUserRole(appUser, appRoleId);
            redirectAttributes.addFlashAttribute("message", "Register Complete !");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("message", "User Name is existed !");
            return "redirect:/register";
        }
    }

    @GetMapping("/no-accessing")
    public String goNoAccessing(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Sorry ! You do not have access !");
        return "redirect:/home";
    }

    @GetMapping("/wrong-password")
    public String wrongPassword(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messageWrong", "Sorry ! The password you entered" +
                " is incorrect !");
        return "redirect:/login/";
    }
}