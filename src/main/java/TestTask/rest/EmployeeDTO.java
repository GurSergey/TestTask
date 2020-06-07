package TestTask.rest;

import TestTask.entities.Employee;
import TestTask.exception.IdNotFound;

public interface EmployeeDTO {
    public Employee getEmployee(int id) throws IdNotFound;
    public Employee[] getAllEmployees();
    public Employee[] searchEmployeeByPatternFamily(String pattern);
    public void addEmployee(Employee employee);
}
