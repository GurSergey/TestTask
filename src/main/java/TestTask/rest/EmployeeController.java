package TestTask.rest;


import TestTask.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDTO dto;

    @GetMapping("/get_employee")
    public Employee greeting(@RequestParam(value = "id") int id) {
        return dto.getEmployee(id);
    }
}