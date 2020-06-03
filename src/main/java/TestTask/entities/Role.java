package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

public class Role {

    @Getter @Setter private int id;
    @Getter @Setter private Employee employee;
    @Getter @Setter private Grade grade;
    @Getter @Setter private Position position;
    @Getter @Setter private Specialization specialization;
}
