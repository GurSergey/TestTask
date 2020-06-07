package TestTask.input;

import TestTask.entities.Department;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmployeeInput {

    @Getter
    @Setter
    @NotEmpty(message = "Family is mandatory")
    private String family;
    @NotNull(message = "Birthday is mandatory")
    @Getter @Setter private Date birthday;
    @NotEmpty(message = "patronymic is mandatory")
    @Getter @Setter private String patronymic;
    @NotNull(message = "gender is mandatory")
    @Getter @Setter private Integer gender;
    @NotEmpty(message = "Name is mandatory")
    @Getter @Setter private String name;
    @NotEmpty(message = "phone is mandatory")
    @Getter @Setter private String phone;
    @NotEmpty(message = "email is mandatory")
    @Email(message="Please provide a valid email address")
    @Getter @Setter private String email;

    @NotNull(message = "Birthday is mandatory")
    @Getter @Setter
    private Date employmentDate;
    @NotNull(message = "salary is mandatory")
    @Getter @Setter
    Integer salary;
    @NotNull(message = "head is mandatory")
    @Getter @Setter
    Boolean head;
    @NotNull(message = "id_department is mandatory")
    @Getter @Setter
    Department department;
}
