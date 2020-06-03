package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

public class Education {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private Employee employee;
    @Getter @Setter
    private String pathImg;
    @Getter @Setter
    private TypeEducation typeEducation;
    @Getter @Setter
    private String title;
}
