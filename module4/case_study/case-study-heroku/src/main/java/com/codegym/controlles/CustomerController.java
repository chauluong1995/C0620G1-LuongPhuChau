package com.codegym.controlles;

import com.codegym.entity.customer.Customer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
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
        model.addAttribute("newCustomer", new Customer());
        model.addAttribute("customerTypeList", this.customerService.allCustomerType());
        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Unknow");
        model.addAttribute("genderList", genderList);

        return "customer/customer-home";
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam String deleteId, RedirectAttributes redirectAttributes) {
        this.customerService.deleteCustomer(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Customer Complete !");
        return "redirect:/customer";
    }

    @PostMapping("/createNew")
    public String createNewCustomer(@ModelAttribute Customer newCustomer, RedirectAttributes redirectAttributes) {
        this.customerService.save(newCustomer);
        redirectAttributes.addFlashAttribute("message", "Create Complete !");
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer newCustomer, RedirectAttributes redirectAttributes) {
        this.customerService.update(newCustomer);
        redirectAttributes.addFlashAttribute("message", "Update Complete !");
        return "redirect:/customer";
    }
}
