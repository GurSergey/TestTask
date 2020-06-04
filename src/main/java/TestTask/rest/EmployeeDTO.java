package TestTask.rest;

import TestTask.entities.Employee;
import TestTask.exception.IdNotFound;

public interface EmployeeDTO {
    public Employee getEmployee(int id) throws IdNotFound;
}
