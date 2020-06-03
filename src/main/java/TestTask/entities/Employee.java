package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class Employee {

    @Getter @Setter private int id;
    @Getter @Setter private String family;
    @Getter @Setter private Date birthday;
    @Getter @Setter private String patronymic;
    @Getter @Setter private int gender;
    @Getter @Setter private String name;
    @Getter @Setter private String phone;
    @Getter @Setter private String email;
    @Getter @Setter private Date employmentDate;
    @Getter @Setter private Date dismosalDate;
    @Getter @Setter private int salary;
    @Getter @Setter private boolean head;
    @Getter @Setter private Employee lineManager;
    @Getter @Setter private Department department;
    @Getter @Setter
    private List<ProficiencyLevel> proficiencyLevel;

}
