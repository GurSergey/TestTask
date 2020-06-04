package TestTask.mappers;

import TestTask.entities.Employee;
import TestTask.output.EmployeeStructs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeStructs sourceToDestination(Employee employee);
    Employee destinationToSource(EmployeeStructs destination);
}
