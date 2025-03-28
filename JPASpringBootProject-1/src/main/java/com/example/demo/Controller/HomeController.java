package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Use @Controller instead of @RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;

@Controller // Use @Controller for rendering views
public class HomeController {

    @Autowired
    private EmployeeService service;

    // Handle the "/employee" endpoint
    @GetMapping("/employee")
    public String insertEmployee(Model model) {

        // Create a new Employee object and set its values
        Employee emp = new Employee();
        emp.setEmployeename("Sabarish Reddy");
        emp.setEmployeeDept("BackEnd Team");
        emp.setEmployeeDesignation("Senior Java Developer");
        emp.setEmployeeExp(10);

        // Save the Employee to the database using the service layer
        service.saveEmployee(emp);

        // Create a success message for the view
        String msg = "Employee " +
                emp.getEmployeename() + " - " + emp.getEmployeeId() + " has been added.";

        // Add attributes to the model to be accessed in the view
        model.addAttribute("Employee", emp);
        model.addAttribute("message", msg);

        // Return the name of the view (index.jsp)
        return "index"; // JSP will be located at /WEB-INF/views/index.jsp
    }
}
