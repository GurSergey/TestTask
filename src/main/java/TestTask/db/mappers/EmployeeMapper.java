package TestTask.db.mappers;

import TestTask.entities.Employee;

import java.util.List;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);
    Employee[] getEmployeeByFamilyPattern(String familyPattern);
    void addEmployee(Employee employee);

//    List<Employee> getEmployees();

}