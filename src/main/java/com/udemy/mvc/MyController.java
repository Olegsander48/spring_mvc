package com.udemy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @RequestMapping("/")
    public String showFirstView() {
        return "myView";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);
        return "show-emp-detail";
    }
}
