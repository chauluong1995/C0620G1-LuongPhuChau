package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TranslateService;

@Controller
public class ConvertController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/translate")
    public String result(@RequestParam String english, Model model) {
        String result = translateService.translate(english);
        model.addAttribute("result", result);
        return "home";
    }
}
