package TestTask.mappers;

import TestTask.entities.Employee;
import TestTask.input.EmployeeInput;
import TestTask.output.EmployeeStructs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeInputMapper {
    Employee sourceToDestination(EmployeeInput employee);
    EmployeeInput destinationToSource(Employee destination);
}
