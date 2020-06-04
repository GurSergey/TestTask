package TestTask.rest;


import TestTask.exception.IdNotFound;
import TestTask.mappers.EmployeeMapper;
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
@Api(tags = "Scheduler API")
public class EmployeeController {
    @Autowired
    EmployeeDTO dto;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/get_employee")
    @ApiOperation(value = "Get employee by id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not found id")
    })
    public EmployeeStructs greeting(@RequestParam(value = "id") int id) throws IdNotFound {
        return employeeMapper.sourceToDestination( dto.getEmployee(id));
    }

    @PostMapping("/add_employee")
    ResponseEntity<String> addUser(@Valid @RequestBody EmployeeInput user) {

        return ResponseEntity.ok("User added");
    }
}