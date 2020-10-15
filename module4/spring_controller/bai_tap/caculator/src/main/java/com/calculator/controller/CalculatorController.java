package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping("calculate")
    public String calculate(Model model, @RequestParam String num1, @RequestParam String num2, @RequestParam String calculator) {
        if (!num1.matches("\\d+") || !num2.matches("\\d+")) {
            model.addAttribute("result", "Invalid Number !");
        } else {
            boolean check = true;
            double result = 0;
            double temp1 = Integer.parseInt(num1);
            double temp2 = Integer.parseInt(num2);
            if (calculator.contains("+")) {
                result = temp1 + temp2;
            } else if (calculator.contains("-")) {
                result = temp1 - temp2;
            } else if (calculator.contains("X")) {
                result = temp1 * temp2;
            } else {
                if (temp2 == 0) {
                    check = false;
                    model.addAttribute("result", "Invalid Number 2 ! Number 2 must different 0 !");
                } else {
                    result = temp1 / temp2;
                }
            }
            if (check) {
                model.addAttribute("result", "Result : " + result);
            }
        }
        return "home";
    }
}
