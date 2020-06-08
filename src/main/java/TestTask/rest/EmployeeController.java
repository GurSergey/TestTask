package TestTask.rest;


import TestTask.entities.Employee;
import TestTask.exception.IdNotFound;
import TestTask.mappers.EmployeeInputMapper;
import TestTask.mappers.EmployeeOutputMapper;
import TestTask.output.EmployeeStructs;
import TestTask.input.EmployeeInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Api(tags = "API")
public class EmployeeController {
    @Autowired
    EmployeeDTO dto;
    @Autowired
    EmployeeOutputMapper employeeOutputMapper;
    @Autowired
    EmployeeInputMapper employeeInputMapper;



    @GetMapping("/get_employee")
    @ApiOperation(value = "Get employee by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not found id")
    })
    public EmployeeStructs getEmployee(@RequestParam(value = "id") int id) throws IdNotFound {
        return employeeOutputMapper.sourceToDestination( dto.getEmployee(id));
    }

    @GetMapping("/search_employee")
    @ApiOperation(value = "Search employee by family")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success")
    })
    public EmployeeStructs[] searchEmployeeByFamily
            (@RequestParam(value = "familyPattern") String pattern) {
        return employeeOutputMapper.sourceToDestination( dto.searchEmployeeByPatternFamily(pattern));
    }

    @GetMapping("/get_all_employees")
    @ApiOperation(value = "Get all employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success")
    })
    public EmployeeStructs[] getAll
            () {
        return employeeOutputMapper.sourceToDestination( dto.getAllEmployees());

    }

    @ApiOperation(value = "Add employee")
    @PostMapping("/add_employee")
    ResponseEntity<String> addUser(@Valid @RequestBody EmployeeInput employee) {
        dto.addEmployee(employeeInputMapper.sourceToDestination(employee));
        return ResponseEntity.ok("User added");
    }
}