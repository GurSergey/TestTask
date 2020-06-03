package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class WorkExperienceInCompany {
    @Getter @Setter
    private int id;
    @Getter @Setter private Date dateStart;
    @Getter @Setter private Date dateEnd;
    @Getter @Setter private Project project;
    @Getter @Setter private Employee employee;
    @Getter @Setter private Role role;
}
