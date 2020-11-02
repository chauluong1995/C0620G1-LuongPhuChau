package com.codegym.controlles;

import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        redirectAttributes.addFlashAttribute("message", "");

        String keywordOld = "";
        if (keyword.isPresent()) {
            keywordOld = keyword.get();
            model.addAttribute("customerList", this.customerService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);

        return "customer/customer-home";
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam String deleteId, RedirectAttributes redirectAttributes) {
        this.customerService.deleteCustomer(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Customer Complete !");
        return "redirect:/customer";
    }
}
