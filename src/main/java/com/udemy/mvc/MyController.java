package com.udemy.mvc;

import com.udemy.mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String showFirstView() {
        return "myView";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSurname("Petrov");
        employee.setSalary(5000);
        model.addAttribute("employee", employee);
        return "ask-emp-details";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee employee) {
        employee.setName("Ne Ivan");
        return "show-emp-detail";
    }
}
