package com.codegym.controlles;

import com.codegym.entity.employee.Employee;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        redirectAttributes.addFlashAttribute("message", "");

        String keywordOld = "";
        if (keyword.isPresent()) {
            keywordOld = keyword.get();
            model.addAttribute("employeeList", this.employeeService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("employeeList", this.employeeService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("positionList", this.employeeService.allPosition());
        model.addAttribute("divisionList", this.employeeService.allDivision());
        model.addAttribute("educationDegreeList", this.employeeService.allEducationDegree());
        model.addAttribute("userList", this.employeeService.allUser());

        return "employee/employee-home";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer deleteId, RedirectAttributes redirectAttributes) {
        this.employeeService.deleteEmployee(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Employee Complete !");
        return "redirect:/employee";
    }

    @PostMapping("/createNew")
    public String createNewEmployee(@ModelAttribute Employee newEmployee, RedirectAttributes redirectAttributes) {
        this.employeeService.save(newEmployee);
        redirectAttributes.addFlashAttribute("message", "Create Complete !");
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee newEmployee, RedirectAttributes redirectAttributes) {
        this.employeeService.update(newEmployee);
        redirectAttributes.addFlashAttribute("message", "Update Complete !");
        return "redirect:/employee";
    }
}
