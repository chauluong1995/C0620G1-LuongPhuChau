package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;

@Controller
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/convert")
    public String result(@RequestParam String usd, @RequestParam String rate, Model model) {
        String result = convertService.convert(usd, rate);
        model.addAttribute("result", result);
        return "home";
    }
}
