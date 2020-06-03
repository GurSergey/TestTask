package TestTask.entities;

import lombok.Getter;
import lombok.Setter;

public class Project {
    @Getter @Setter
    private int id;
    @Getter @Setter private Employee manager;
    @Getter @Setter private String nameProject;
}
