package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class WorkExperience {
    @Getter
    @Setter
    private int id;
    @Getter @Setter
    private Employee employee;
    @Getter @Setter
    private Date dataReciept;
    @Getter @Setter
    private Date dateDismossal;
    @Getter @Setter private String nameOfCompany;
    @Getter @Setter private String namePosition;
}
